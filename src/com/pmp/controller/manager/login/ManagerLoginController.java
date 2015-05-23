package com.pmp.controller.manager.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pmp.common.RText;
import com.pmp.controller.base.BaseController;
import com.pmp.pojo.User;
import com.pmp.service.UserService;

@Controller
@RequestMapping("/manager/login")
public class ManagerLoginController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/tologin", method = RequestMethod.GET)
	public ModelAndView tologin() {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/manager/login/login");
		return mov;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public String checkLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user = userService.findUser(user);
		if (null == user) {
			// 用户不存在
			msg = "-1";
		} else {
			int status = user.getStatus();
			msg = RText.toString(status);
		}
		return msg;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/manager/login/login");
		return mov;
	}
}
