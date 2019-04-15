package com.gui.star_compute_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注解@EnableDiscoveryClient的作用： 激活Eureka中的DiscoveryClient实现，用来发现服务注册中心的其他服务
 * 
 * 注解@EnableCaching开启应用缓存功能。
 * 
 * @author wuhoujian
 *
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class ComputeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComputeServiceApplication.class, args);
	}
}