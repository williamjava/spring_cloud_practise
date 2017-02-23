package com.gui.star_eureka_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate用来调用远程服务
 * 
 * @author wuhoujian
 *
 */
@RestController
public class ConsumerController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
	}
}