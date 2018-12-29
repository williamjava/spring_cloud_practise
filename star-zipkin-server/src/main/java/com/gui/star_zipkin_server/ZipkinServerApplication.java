package com.gui.star_zipkin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * SpringBoot2.0之后，zipkin-server不需要自己部署，该项目作废！
 * 
 * @author wuhoujian
 *
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
