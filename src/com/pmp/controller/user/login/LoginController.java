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
import com.pmp.aop.aspectj.parameter.Parameter;
import com.pmp.aop.aspectj.token.Token; 
import com.pmp.common.RText;
import com.pmp.common.WebUtils;
import com.pmp.constant.ModuleConstant;
import com.pmp.constant.OperationConstant;
import com.pmp.constant.SessionConstant;
import com.pmp.controller.base.BaseController;
import com.pmp.pojo.User;
import com.pmp.service.UserService;
import com.pmp.session.SessionHolder;

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

	/**
	 * 跳转到登陆页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	@Token(save = true)
	public ModelAndView toLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mov = new ModelAndView();
		//mov.setViewName("/user/login/toLogin");
		return mov;
	}

	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Log(moduleType = ModuleConstant.LOGIN, operationType = OperationConstant.VISIT, logInfo = "用户登录", describe = "用户登录")
	@Token(remove = true)
	@Parameter
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		User loginUser = userService.testLogin(user);
		if (null != loginUser) {
			SessionHolder.setValueToSession(SessionConstant.GLOBAL_SESSION_USER, loginUser);
		}
		ModelAndView mov = new ModelAndView();
		mov.setViewName("redirect:/login/index.html");
		return mov;
	}

	/**
	 * 检查登陆
	 * @param request
	 * @param response
	 * @return
	 */
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

	/**
	 * 退出登陆
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	@Log(moduleType = ModuleConstant.LOGINOUT, operationType = OperationConstant.VISIT, logInfo = "用户退出", describe = "用户退出")
	public ModelAndView loginOut(HttpServletRequest request,
			HttpServletResponse response) {
		
		//记录username 和useralias 用于Log 日志记录账号和姓名
		String username = WebUtils.getWebUserName(request);
		String useralias = WebUtils.getWebUserAlias(request);
		request.setAttribute("username", username);
		request.setAttribute("useralias", useralias);
		
		SessionHolder.logOut();
		ModelAndView mov = new ModelAndView();
		mov.setViewName("redirect:/login/index.html");
		return mov;
	}

}
