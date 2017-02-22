package com.gui.star_eureka_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gui.star_eureka_feign.face.ComputeClient;

@RestController
public class ConsumerController {
    @Autowired
    ComputeClient computeClient;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}