package com.gui.star_eureka_ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 指定回调函数
	 * 
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "addServiceFallback")
	public String addService() {
		return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
	}

	public String addServiceFallback() {
		return "error";
	}
}