package com.pmp.controller.user.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pmp.aop.aspectj.log.Log;
import com.pmp.common.RText;
import com.pmp.constant.ModuleConstant;
import com.pmp.constant.OperationConstant;
import com.pmp.controller.base.BaseController;
import com.pmp.pojo.User;
import com.pmp.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView Index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/login/Index");
		return mov;
	}

	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public ModelAndView toLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/login/toLogin");
		return mov;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Log(moduleType=ModuleConstant.LOGIN,operationType=OperationConstant.VISIT,logInfo="用户登录",describe="用户登录")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		User loginUser = userService.testLogin(user);
		if(null!=loginUser){
			putSession("user", loginUser);
		}
		ModelAndView mov = new ModelAndView();
		mov.setViewName("redirect:/login/index.html");
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
	
	
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	@Log(moduleType=ModuleConstant.LOGINOUT,operationType=OperationConstant.VISIT,logInfo="用户退出",describe="用户退出")
	public ModelAndView loginOut(HttpServletRequest request,
			HttpServletResponse response) {
		getSession().invalidate();
		ModelAndView mov = new ModelAndView();
		mov.setViewName("redirect:/login/index.html");
		return mov;
	}

}
