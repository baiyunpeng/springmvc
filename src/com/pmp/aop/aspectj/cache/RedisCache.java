package com.pmp.aop.aspectj.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pmp.constant.RedisCacheConstant;

/**
 * redis缓存注解
 * 
 * @author Administrator
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface RedisCache {
	/**
	 * 缓存键
	 * 
	 * @return
	 */
	String cacheKey() default "";

	/**
	 * 键值生成模式
	 * 
	 * @return
	 */
	String keyGenerateMode() default RedisCacheConstant.REDIS_CACHE_KEYGENERATEMODE_DEF;

	/**
	 * 超时时间
	 * 
	 * @return
	 */
	int timeOut() default RedisCacheConstant.REDIS_CACHE_TIMEOUT_DEF;

	/**
	 * Redis 缓存数据类型默认String 类型
	 * 
	 * @return
	 */
	String dateType() default RedisCacheConstant.REDIS_CACHE_DATATYPE_DEF;

	/**
	 * 转换模式 用于其他类型转换为String 类型
	 * 
	 * @return
	 */
	String converMode() default RedisCacheConstant.REDIS_CACHE_CONVERMODE_DEF;

}
