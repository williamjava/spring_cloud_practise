package com.gui.star_configserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 注解@EnableConfigServer的作用：开启ConfigServer，说明该应用是一个分布式配置服务器
 * 
 * 注解@EnableDiscoveryClient的作用：把ConfigServer注册到服务中心
 * 
 * @author wuhoujian
 *
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigserverApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigserverApplication.class).web(true).run(args);
	}
}