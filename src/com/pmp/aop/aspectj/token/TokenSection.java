package com.pmp.aop.aspectj.token;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 验证表单重复提交 Token
 * @author Administrator
 *
 */
@Aspect
@Component
public class TokenSection {
	/**
	 * token 处理
	 * @param jp
	 * @param token
	 */
	@Before("@annotation(token)")
	public void token(JoinPoint jp, Token token){
		Object[] objectArray = jp.getArgs();
		HttpServletRequest request = (HttpServletRequest) objectArray[0];
	}
}
