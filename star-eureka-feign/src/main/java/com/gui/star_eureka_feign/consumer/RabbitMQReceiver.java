package com.gui.star_eureka_feign.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ消息的消费者
 * 
 * 指定需要监听的队列:@RabbitListener注解
 * 
 * @author wuhoujian
 *
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitMQReceiver {
	/*
	 * 监听到消息后开始执行具体的业务处理
	 * 
	 * 接收到的消息数据格式为：(Body:'我的mq消息'MessageProperties [headers={}, timestamp=null,
	 * messageId=null, userId=null, appId=null, clusterId=null, type=null,
	 * correlationId=null, replyTo=null, contentType=text/plain,
	 * contentEncoding=UTF-8, contentLength=0, deliveryMode=PERSISTENT,
	 * expiration=null, priority=0, redelivered=false, receivedExchange=,
	 * receivedRoutingKey=hello, deliveryTag=2, messageCount=0])
	 * 
	 * 包括Header和body
	 * 
	 */
	@RabbitHandler
	public void process(Object msg) {
		System.out.println("接收到的消息为：" + msg);

		System.out.println("准备开始处理实际业务。。。");
	}
}
