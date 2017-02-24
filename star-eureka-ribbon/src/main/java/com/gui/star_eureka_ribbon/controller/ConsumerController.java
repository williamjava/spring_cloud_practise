package com.gui.star_eureka_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gui.star_eureka_ribbon.service.ComputeService;

/**
 * RestTemplate用来调用远程服务
 * 
 * @author wuhoujian
 *
 */
@RestController
public class ConsumerController {
	@Autowired
    private ComputeService computeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return computeService.addService();
	}
}