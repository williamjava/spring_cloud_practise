package com.gui.star_compute_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 该控制提供所有对外的服务
 * 
 * 注解@RefreshScope的作用：使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
 * 
 * @author wuhoujian
 *
 */
@Api(value = "计算管理api", tags = "计算相关操作")
@RestController
@RefreshScope
public class ComputeController {
	private final Logger logger = LoggerFactory.getLogger(ComputeController.class);
	int count = 0;

	@Value("${author.name}")
	private String name;

	@Value("${author.age}")
	private Integer age;

	@Autowired
	private DiscoveryClient client;

	/**
	 * 求和
	 * 
	 * @param a
	 *            第一个数
	 * @param b
	 *            第二个数
	 * @return 和
	 */
	@ApiOperation(value = "求和", notes = "求和", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "a", value = "第一个数", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "b", value = "第二个数", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance instance = client.getLocalServiceInstance();
		Integer r = a + b;
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);

		count++;
		System.out.println("该服务端共被调用了" + count + "次");
		return r;
	}

	/**
	 * 测试配置
	 * 
	 * @return
	 */
	@ApiOperation(value = "测试配置", notes = "测试配置", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value = "/testconfig", method = RequestMethod.GET)
	public String test() {
		return "Author name is :" + name + "<br/> " + "Author age is :" + age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
