package com.pmp.aop.aspectj.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
	/**
	 * 生成token
	 * */
	boolean save() default false;

	/**
	 * 验证并销毁token
	 * */
	boolean remove() default false;
}
