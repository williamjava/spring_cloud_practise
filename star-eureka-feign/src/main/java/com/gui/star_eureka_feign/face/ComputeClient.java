package com.gui.star_eureka_feign.face;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 注解@FeignClient的作用：用来绑定要调用的具体接口compute-service
 * 
 * @author wuhoujian
 *
 */
@FeignClient("compute-service")
public interface ComputeClient {
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}