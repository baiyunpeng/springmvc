package com.pmp.controller.user.register;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.pmp.service.jdbc.UserService;
import com.pmp.session.SessionHolder;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView toRegister(HttpServletRequest request,
			HttpServletResponse response) {
		return getMov();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Parameter
	@Token(remove=true)
	@Log(moduleType=ModuleConstant.REGISTER,operationType=OperationConstant.INSERT,logInfo="用户注册",describe="用户注册")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response,User user) {
		if(WebUtils.isSubmitSuccess(request)){
			userService.add(user);
		}
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/register/toRegister");
		return mov;
	}

}
