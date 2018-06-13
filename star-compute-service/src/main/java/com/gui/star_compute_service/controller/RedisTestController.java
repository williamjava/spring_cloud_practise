package com.gui.star_compute_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gui.star_compute_service.util.RedisUtil;
import com.gui.star_compute_service.vo.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Redis测试控制器
 * 
 * @author wuhoujian
 *
 */
@Api(value = "redis测试控制器", tags = "redis测试相关操作")
@RestController
@RequestMapping("/redisTest")
@CacheConfig(cacheNames = "users")
public class RedisTestController {
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 添加key
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	@ApiOperation(value = "添加key", notes = "添加key", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "key", value = "键", required = true, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "value", value = "值", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(value = "/addKey", method = RequestMethod.GET)
	public String addKey(String key, String value) {
		redisUtil.set(key, value);
		return "添加key成功";
	}

	/**
	 * 获取key
	 * 
	 * @param key
	 * @return
	 */
	@ApiOperation(value = "获取key", notes = "获取key", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "key", value = "键", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(value = "/getKey", method = RequestMethod.GET)
	public Object getKey(String key) {
		return redisUtil.get(key);
	}

	/**
	 * 测试添加单个值到redis
	 * 
	 * @return
	 */
	@Cacheable(value = "singleVal")
	@RequestMapping(value = "/setSingleVal", method = RequestMethod.GET)
	public String setSingleVal() {
		return "Redis World!";
	}

	/**
	 * 测试添加单个对象到redis
	 * 
	 * @return
	 */
	@Cacheable(value = "singleObj")
	@RequestMapping(value = "/setSingleObj", method = RequestMethod.GET)
	public UserVo setSingleObj() {
		return new UserVo("William", 27, "Software Engineer");
	}
}
