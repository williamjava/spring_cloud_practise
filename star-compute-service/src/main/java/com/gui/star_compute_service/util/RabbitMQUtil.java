//package com.gui.star_compute_service.util;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * RabbitMQ工具类
// *
// * @author wuhoujian
// *
// */
//@Component
//@Slf4j
//public class RabbitMQUtil {
//	/**
//	 * Spring提供的AmqpTemplate封装了大量的操作mq的方法
//	 */
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//
//	/**
//	 * 发送消息方法
//	 */
//	public void send(String msg) {
//		log.info("即将发送的消息为：{}", msg);
//
//		rabbitTemplate.convertAndSend("hello", msg);
//	}
//}
