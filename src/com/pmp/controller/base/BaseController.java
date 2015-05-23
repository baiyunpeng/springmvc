package com.pmp.controller.base;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BaseController {
	@Autowired
	private HttpSession session;

	public String msg = "";
	
	public void putSession(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public Object getSessionValue(String key) {
		return getSession().getAttribute(key);
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
