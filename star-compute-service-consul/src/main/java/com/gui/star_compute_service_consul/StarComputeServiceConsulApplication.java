package com.gui.star_compute_service_consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StarComputeServiceConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarComputeServiceConsulApplication.class, args);
    }

}
