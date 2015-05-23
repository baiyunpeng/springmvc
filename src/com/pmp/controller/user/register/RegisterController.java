package com.pmp.controller.user.register;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmp.aop.aspectj.parameter.Parameter;
import com.pmp.pojo.User;
import com.pmp.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public ModelAndView toRegister(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/register/toRegister");
		return mov;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Parameter
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,User user) {
		userService.add(user);
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/register/toRegister");
		return mov;
	}

}
