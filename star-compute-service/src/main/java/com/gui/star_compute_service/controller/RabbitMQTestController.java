//package com.gui.star_compute_service.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gui.star_compute_service.util.RabbitMQUtil;
//import com.gui.star_compute_service.util.RedisUtil;
//import com.gui.star_compute_service.vo.UserVo;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//
///**
// * RabbitMQ测试控制器
// *
// * @author wuhoujian
// *
// */
//@Api(value = "rabbitMQ测试控制器", tags = "rabbitMQ测试相关操作")
//@RestController
//@RequestMapping("/mqTest")
//public class RabbitMQTestController {
//	@Autowired
//	private RabbitMQUtil rabbitMQUtil;
//
//	/**
//	 * 发送消息
//	 *
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	@ApiOperation(value = "发送消息", notes = "发送消息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiImplicitParams(value = {
//			@ApiImplicitParam(name = "msg", value = "发送的消息", required = true, dataType = "string", paramType = "query") })
//	@RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
//	public String addKey(String msg) {
//		rabbitMQUtil.send(msg);
//
//		return "消息发送成功";
//	}
//}
