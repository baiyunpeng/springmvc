package com.pmp.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmp.dao.redis.RedisBaseDAO;

@Service
public class RedisService {
	@Autowired
	private RedisBaseDAO redisBaseDao;

	public void setCache(String key, String value) {
		redisBaseDao.set(key, value);
	}

	public String getCache(String key) {
		return redisBaseDao.getString(key);
	}
}
