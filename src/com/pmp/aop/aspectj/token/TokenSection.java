package com.pmp.aop.aspectj.token;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.pmp.common.RText;
import com.pmp.constant.SessionConstant;
import com.pmp.session.SessionHolder;

/**
 * 验证表单重复提交 Token
 * 
 * @author Administrator
 * 
 */
@Aspect
@Component
public class TokenSection {
	/**
	 * token 处理
	 * 
	 * @param jp
	 * @param token
	 */
	@Before("@annotation(token)")
	public void token(JoinPoint jp, Token token) {
		Object[] objectArray = jp.getArgs();
		HttpServletRequest request = (HttpServletRequest) objectArray[0];
		if (token.save()) {
			SessionHolder.setValueToSession(
					SessionConstant.GLOBAL_SESSION_TOKEN, RText.getUUID());
		} else if (token.remove()) {
			if (isRepeatSubmit(request)) {
				request.setAttribute(SessionConstant.GLOBAL_SESSION_SUBMIT,
						SessionConstant.GLOBAL_SESSION_SUBMIT_FAILURE);
			} else {
				request.setAttribute(SessionConstant.GLOBAL_SESSION_SUBMIT,
						SessionConstant.GLOBAL_SESSION_SUBMIT_SUCCESS);
			}
			SessionHolder.removeValueToSession(SessionConstant.GLOBAL_SESSION_TOKEN);
		}
	}

	public boolean isRepeatSubmit(HttpServletRequest request) {
		String serverToken = RText.toString(SessionHolder
				.getValueFromSession(SessionConstant.GLOBAL_SESSION_TOKEN));
		if (RText.isEmpty(serverToken)) {
			return true;
		}
		String clientToken = request
				.getParameter(SessionConstant.GLOBAL_SESSION_TOKEN);
		if (RText.isEmpty(clientToken)) {
			return true;
		}
		if (!serverToken.equals(clientToken)) {
			return true;
		}
		return false;
	}
}
