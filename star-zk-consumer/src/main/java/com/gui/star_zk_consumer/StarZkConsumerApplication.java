package com.gui.star_zk_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StarZkConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarZkConsumerApplication.class, args);
    }

}
