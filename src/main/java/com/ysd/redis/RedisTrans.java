package com.ysd.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RedisTrans {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 删除/判断（修改此处暂不写，其实就是先删再存）
	 */
	// 删除key和对应的value
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	// 删除多个key和对应的value
	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	// 判断是否含key
	public Boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

	// String存储
	public void setString(String key, String str) {
		redisTemplate.opsForValue().set(key, str);
	}

	// String存储(设置失效)
	public void setStringAndTimeOut(String key, String str, Integer expise) {
		redisTemplate.opsForValue().set(key, str);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// String获取
	public String getString(String key) {
		return redisTemplate.opsForValue().get(key).toString();
	}

	// List存储
	public void setList(String key, List<Object> value2) {
		redisTemplate.opsForList().leftPush(key, value2);
	}

	// List存储(设置失效)
	public void setListAndTimeOut(String key, List<Object> value2, Integer expise) {
		redisTemplate.opsForList().leftPush(key, value2);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// List获取
	@SuppressWarnings("unchecked")
	public List<Object> getList(String key) {
		return (List<Object>) redisTemplate.opsForList().leftPop(key);
	}

	// Map存储
	public void setMap(String key, Map<Object, Object> value3) {
		redisTemplate.opsForHash().putAll(key, value3);
	}

	// Map存储(设置失效)
	public void setMapAndTimeOut(String key, Map<Object, Object> value3, Integer expise) {
		redisTemplate.opsForHash().putAll(key, value3);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// Map获取
	public Map<Object, Object> getMap(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	// 取所有key
	public Set<Object> getMapKeys(String key) {
		return redisTemplate.opsForHash().keys(key);
	}

	// 取所有value
	public List<Object> getMapValues(String key) {
		return redisTemplate.opsForHash().values(key);
	}

	// 取对应Map对应key�?
	public Object getValueByMapKey(String map, String key) {
		return redisTemplate.opsForHash().get(map, key);
	}

	// Set存储
	public void setSet(String key, Set<Object> set) {
		redisTemplate.opsForSet().add(key, set);
	}

	// Set存储(设置失效)
	public void setSetAndTimeOut(String key, Set<Object> set, Integer expise) {
		redisTemplate.opsForSet().add(key, set);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// Set获取
	public Set<Object> getSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}
}
