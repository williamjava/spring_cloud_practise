package com.gui.star_compute_service.controller;

import com.gui.star_compute_service.executor.BuyQueue;
import com.gui.star_compute_service.executor.DealQueueThread;
import com.gui.star_compute_service.form.BuyRequest;
import com.gui.star_compute_service.service.BuyGoodService;
import com.gui.star_compute_service.service.BuyOrdersService;
import com.gui.star_compute_service.util.RedisUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Api(value = "购买管理api", tags = "购买相关操作")
@RestController
@RequestMapping("/buy")
@Slf4j
public class BuyController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    BuyGoodService buyGoodService;

    @Autowired
    BuyOrdersService buyOrdersService;

    private static BuyQueue<BuyRequest> buyqueue =null;//线程安全的请求队列

    @RequestMapping(value = "/addOrders", method = RequestMethod.POST)
    public Object addOrders(BuyRequest buyrequest){
        Map<String, Object> results = new HashMap<>();

        try {
            //下订单之前，先获取商品的剩余数量
            int residue = Integer.valueOf(redisUtil.get("residue"+buyrequest.getGood_id()).toString());
            if(residue<1){//如果剩余数量不足，直接响应客户端“卖完了”
                results.put("msg", "卖完了");
                results.put("done", false);
                return results;
            }

            //如果还有剩余商品,就准备将请求放到请求队列中
            if(buyqueue==null){//第一次初始化请求队列,队列的容量为当前的商品剩余数量
                buyqueue=new BuyQueue<BuyRequest>(residue);
            }
            if(buyqueue.remainingCapacity()>0){//当队列的可用容量大于0时,将请求放到请求队列中
                buyqueue.put(buyrequest);
            }else{//当请求队列已满,本次请求不能处理,直接响应客户端提示请求队列已满
                results.put("msg", "抢购队列已满，请稍候重试！");
                results.put("done", false);
                return results;
            }

            if(!DealQueueThread.excute){//如果线程类的当前执行标志为未执行,即空闲状态,通过线程池启动线程
                DealQueueThread dealQueue = new DealQueueThread(buyqueue, redisUtil);
                //ThreadPoolUtil.pool.execute(dealQueue);
                ExecutorService threadPool = Executors.newFixedThreadPool(3);
                threadPool.execute(dealQueue);
                log.info("Thread.activeCount()="+Thread.activeCount());
            }
            //请求放入到队列中，即完成下单请求
            results.put("done", true);
            results.put("msg", "下订单成功");

        } catch (Exception e) {
            results.put("done", false);
            results.put("msg", "下单失败");
            //log.info("addOrders results="+JSON.toJSONString(results));
            log.error("addOrders",e);
        }

        return results;
    }
}