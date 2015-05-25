package com.pmp.aop.aspectj.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.pmp.aop.aspectj.log.Log;

/**
 * redis 缓存切面
 * @author Administrator
 *
 */
@Aspect
@Component
public class RedisCacheSection {

	@Around("@annotation(redisCache)")
	public void cache(JoinPoint jp, RedisCache redisCache){
		System.out.println("redis 缓存 启动");
	}
}
