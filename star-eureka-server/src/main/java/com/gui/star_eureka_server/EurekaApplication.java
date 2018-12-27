package com.gui.star_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注解@EnableEurekaServer的作用：启动一个服务注册中心，其他应用通过它进行对话
 * 
 * 如何实现高可用注册中心：
 * 
 * 1.两个配置文件application-peer1.yml和application-peer2.yml；
 * 
 * 2.java -jar xxx.jar --spring.profiles.active=peer1和java -jar xxx.jar
 * --spring.profiles.active=peer2
 * 
 * @author wuhoujian
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
		
		// SpringApplication.run(EurekaApplication.class,
		// "spring.profiles.active=peer1");
	}
}