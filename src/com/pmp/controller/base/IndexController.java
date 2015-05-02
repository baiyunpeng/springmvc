package com.pmp.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/base")
public class IndexController extends BaseController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mov = new ModelAndView("/base/Index");
		return mov;
	}
	
	@RequestMapping(value = "/ace", method = RequestMethod.GET)
	public ModelAndView ace() {
		ModelAndView mov = new ModelAndView("/base/Index");
		return mov;
	}
}
