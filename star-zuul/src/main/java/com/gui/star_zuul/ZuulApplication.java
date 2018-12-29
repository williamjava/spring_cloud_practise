package com.gui.star_zuul;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.gui.star_zuul.filter.AccessFilter;

/**
 * 注解@EnableZuulProxy的作用：开启Zuul
 * 
 * 注解@SpringCloudApplication整合了如下注解：@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，目的是简化配置
 * 
 * @author wuhoujian
 *
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}