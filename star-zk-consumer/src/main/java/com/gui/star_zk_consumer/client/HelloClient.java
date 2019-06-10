package com.gui.star_zk_consumer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class HelloClient {
    @Autowired
    private TheClient theClient;

    @FeignClient(name = "hello")
    interface TheClient {

        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        String hello();
    }

    public String hello() {
        return theClient.hello();
    }
}