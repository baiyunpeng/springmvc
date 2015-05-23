package com.pmp.aop.aspectj.log;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pmp.common.LogUtils;
import com.pmp.common.WebUtils;
import com.pmp.entity.log.LogEntity;
import com.pmp.service.log.LogService;

/**
 * 日志记录系统切面
 * 
 * @author Administrator
 * 
 */
@Aspect
@Component
public class LogSection {
	@Autowired
	private LogService logService;

	@Before("@annotation(log)")
	public void recordLog(JoinPoint jp, Log log) {
		// 得到操作类的类名
		String className = jp.getSignature().getDeclaringTypeName();
		// 得到操作类的方法名
		String methodName = jp.getSignature().getName();
		Object[] obj = jp.getArgs();
		String IP = WebUtils.getIpAddr((HttpServletRequest) obj[0]);
		String username = WebUtils.getWebUserName((HttpServletRequest) obj[0]);
		String userAlias = WebUtils
				.getWebUserAlias((HttpServletRequest) obj[0]);
		LogEntity logEntity = new LogEntity.Builder(log).IP(IP)
				.username(username).userAlias(userAlias).className(className)
				.methodName(methodName).builder();
		logService.save(logEntity);
	}
}
