package com.pmp.aop.aspectj.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pmp.constant.AccountConstant;
import com.pmp.constant.ModuleConstant;
import com.pmp.constant.OperationConstant;


/**
 * 日志注解
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Log{
	
	
	
	/**
	 * 日志登记
	 * 
	 * @return
	 */
	String level() default "INFO";
	
	/**
	 * 模块类型
	 * 
	 * @return
	 */
	String moduleType() default ModuleConstant.DEFAULT;
	
	


	/**
	 * 操作类型
	 * 
	 * @return
	 */
	String operationType() default OperationConstant.DEFAULT;;

	/**
	 * 日志
	 * 
	 * @return
	 */
	String logInfo() default "";

	/**
	 * 描述
	 * 
	 * @return
	 */
	String describe() default "";

}
