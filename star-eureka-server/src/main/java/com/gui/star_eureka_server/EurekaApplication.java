package com.gui.star_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注解@EnableEurekaServer的作用：启动一个服务注册中心，其他应用通过它进行对话
 * 
 * @author wuhoujian
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class,"--spring.profiles.active=peer2");
	}
}