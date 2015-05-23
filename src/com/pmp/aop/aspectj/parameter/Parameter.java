package com.pmp.aop.aspectj.parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
/**
 * SpringMVC参数注入注解
 * @author Administrator
 *
 */
public @interface Parameter {
	/**
	 * 注入参数位置 默认第三个 如果找不到则不进行注入
	 * @return
	 */
	int paramIndex() default 2;
	
	/**
	 * 注入参数类型 默认自动判断
	 * @return
	 */
	String paramType() default "auto";
}
