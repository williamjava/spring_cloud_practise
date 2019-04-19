package com.gui.star_compute_service.executor;

import com.gui.star_compute_service.entity.BuyOrders;
import com.gui.star_compute_service.form.BuyRequest;
import com.gui.star_compute_service.service.BuyGoodService;
import com.gui.star_compute_service.service.BuyOrdersService;
import com.gui.star_compute_service.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class DealQueueThread implements Runnable {
    private static DealQueueThread dealQueueThread;

    @Autowired
    public static RedisUtil redisUtil;

    @Autowired
    BuyGoodService buyGoodService;

    @Autowired
    BuyOrdersService buyOrdersService;

    private BuyQueue<BuyRequest> buyqueue;

    public static boolean excute = false;//线程的默认执行标志为未执行,即空闲状态

    public DealQueueThread() {

    }

    public DealQueueThread(BuyQueue<BuyRequest> buyqueue, RedisUtil redisUtil) {
        this.buyqueue = buyqueue;
        this.redisUtil = redisUtil;
    }

    @PostConstruct
    public void init() {
        dealQueueThread = this;
        dealQueueThread.buyGoodService = this.buyGoodService;
        dealQueueThread.buyOrdersService = this.buyOrdersService;
        dealQueueThread.redisUtil = this.redisUtil;
    }

    @Override
    public void run() {
        try {
            excute = true;//修改线程的默认执行标志为执行状态
            //开始处理请求队列中的请求,按照队列的FIFO的规则,先处理先放入到队列中的请求
            while (buyqueue != null && buyqueue.size() > 0) {
                BuyRequest buyreq = (BuyRequest) buyqueue.take();//取出队列中的请求
                dealWithQueue(buyreq);//处理请求
            }
        } catch (InterruptedException e) {
            log.error("DealQueueThread:", e);
        } finally {
            excute = false;
        }
    }

    public synchronized void dealWithQueue(BuyRequest buyreq) {
        log.info("开始处理请求{}", buyreq.getUser_id());
        try {
            //为了尽量确保数据的一致性,处理之前先从redis中获取当前抢购商品的剩余数量
            int residue = Integer.valueOf(redisUtil.get("residue" + buyreq.getGood_id()).toString());
            if (residue < 1) {//如果没有剩余商品,就直接返回
                buyreq.setResponse_status(3);
                return;
            }
            //如果有剩余商品,先在redis中将剩余数量减一,再开始下订单
            redisUtil.set("residue" + buyreq.getGood_id(), residue - 1);
            //redisUtil.decr("residue" + buyreq.getGood_id());
            //将数据库中将剩余数量减一,这一步处理可以在队列处理完成之后一次性更新剩余数量
            dealQueueThread.buyGoodService.minusResidue(buyreq.getGood_id());

            //处理请求,下订单
            BuyOrders bo = new BuyOrders();
            bo.setGood_id(buyreq.getGood_id());
            bo.setUser_id(buyreq.getUser_id());

            //保存订单
            //int order_id = dealQueueThread.buyOrdersService.insert(bo);
//            BuyOrders orders = dealQueueThread.buyOrdersService.getById(order_id);
//            buyreq.setOrder_id(order_id);//订单id
//            buyreq.setBuyOrders(orders);//订单信息
            buyreq.setResponse_status(1);//处理完成状态
        } catch (Exception e) {
            buyreq.setResponse_status(2);//异常状态
            log.error("DealQueueThread dealWithQueue:", e);
        }
    }
}