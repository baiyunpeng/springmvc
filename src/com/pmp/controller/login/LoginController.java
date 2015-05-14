package com.pmp.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmp.pojo.User;
import com.pmp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView Index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/login/Index");
		return mov;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
/*		String email = request.getParameter("email");
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123");
		user.setEmail(email);
		User user1 = userService.findUser(user);
		System.out.println(user1);*/
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/login/Login");
		return mov;
	}
}
