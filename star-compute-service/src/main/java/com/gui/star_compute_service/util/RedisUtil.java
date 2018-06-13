package com.gui.star_compute_service.util;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Redis工具类
 * 
 * @author wuhoujian
 *
 */
@Component
@Slf4j
@SuppressWarnings("unchecked")
public class RedisUtil {
	@Autowired
	@SuppressWarnings("rawtypes")
	private RedisTemplate redisTemplate;

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 将键值对设定一个指定的时间timeout.
	 * 
	 * @param key
	 * @param timeout
	 *            键值对缓存的时间，单位是毫秒
	 * @return 设置成功返回true，否则返回false
	 */
	public boolean tryLock(String key, long timeout) {
		boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(key, "");
		if (isSuccess) {
			redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
		}
		return isSuccess;
	}

	/**
	 * 根据指定的key获取对应的value
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		try {
			log.info("准备获取key的value值,key:{}", key);

			Object result = null;
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			result = operations.get(key);

			log.info("result:{}", result);
			return result;
		} catch (Exception e) {
			log.error("获取指定key的value出现异常", e);

			return "error";
		}

	}

	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	public void delete(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		return set(key, value, null);
	}

	/**
	 * 
	 * 写入缓存带有效期
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			if (expireTime != null) {
				redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			log.error("删除redis中存在的一个键出现异常", e);
		}

		return result;
	}

}
