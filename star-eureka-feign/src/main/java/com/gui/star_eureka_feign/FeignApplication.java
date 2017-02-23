package com.gui.star_eureka_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是一个声明式的Web Service客户端，它使得编写Web Serivce客户端变得更加简单
 * 
 * 注解EnableFeignClients的作用： 开启Feign功能
 * 
 * @author wuhoujian
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}