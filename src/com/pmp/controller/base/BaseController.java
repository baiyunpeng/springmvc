package com.pmp.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基类Controller
 * 
 * @author Administrator
 * 
 */
@Controller
public class BaseController {
	public String msg = "";

	/**
	 * 得到一个 新的ModelAndView
	 * @return
	 */
	public ModelAndView getMov() {
		ModelAndView mov = new ModelAndView();
		return mov;
	}
}
