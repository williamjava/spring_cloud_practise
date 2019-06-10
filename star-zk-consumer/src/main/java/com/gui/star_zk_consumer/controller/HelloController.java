package com.gui.star_zk_consumer.controller;

import com.gui.star_zk_consumer.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        return helloClient.hello();
    }
}