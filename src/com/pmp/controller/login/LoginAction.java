package com.pmp.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/login/Index");
		return mov;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("email");
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/login/Index");
		return mov;
	}
}
