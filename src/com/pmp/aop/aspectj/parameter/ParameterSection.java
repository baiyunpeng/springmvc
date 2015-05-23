package com.pmp.aop.aspectj.parameter;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.support.BindingAwareModelMap;

import com.pmp.common.CollectionConverUtils;
import com.pmp.common.WebUtils;
import com.pmp.entity.parameter.ParameterEntity;

/**
 * 参数注册 切面
 * 
 * @author Administrator
 * 
 */
@Aspect
@Component
public class ParameterSection {
	/**
	 * 参数自动装配
	 * 
	 * @param jp
	 * @param log
	 */
	@Before("@annotation(parameter)")
	public void parameterAutoWired(JoinPoint jp, Parameter parameter) {
		Object[] objectArray = jp.getArgs();

		int paramIndex = parameter.paramIndex();
		if (objectArray.length <= paramIndex) {
			return;
		}
		HttpServletRequest request = (HttpServletRequest) objectArray[0];
		Object param = objectArray[paramIndex];
		if (param instanceof Map) {
			BindingAwareModelMap bindingAwareModelMap = (BindingAwareModelMap)param;
			Map paramMap = WebUtils.getWebParameterMap(request);
			bindingAwareModelMap = CollectionConverUtils.mapToBindingAwareModelMap(bindingAwareModelMap, paramMap);
			param =bindingAwareModelMap;
		} else if (param instanceof ParameterEntity) {
			ParameterEntity parameterEntity = (ParameterEntity) param;
			parameterEntity.setParameter(WebUtils.getWebParameterMap(request));
			param = parameterEntity;
		} else {
			if (null != objectArray[paramIndex]) {
				param = WebUtils.getWebParameterEntity(param, request);
			}

		}

		objectArray[paramIndex] = param;
	}
}
