package com.pmp.controller.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmp.controller.base.BaseController;
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController{

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ModelAndView demo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/demo/demo");
		return  mov;
	}
}
