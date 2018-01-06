package com.gui.star_compute_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping(value = "/say", method = RequestMethod.GET)
	public String sayHi(){
		return "Hello, I am hot deployment.111";
	}
}
