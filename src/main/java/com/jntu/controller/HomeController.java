package com.jntu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// This controller is used to serve jsp pages of our application

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePageController() {
		return "home";
	}
	
	@RequestMapping(value = "/datatypes", method = RequestMethod.GET)
	public String basicDataTypePageController() {
		return "datatypes";
	}
	@RequestMapping(value = "/arrays", method = RequestMethod.GET)
	public String arrayPageController() {
		return "Arrays";
	}
	
	@RequestMapping(value = "/matrix", method = RequestMethod.GET)
	public String matrixPageController() {
		return "matrix";
	}
	
	@RequestMapping(value = "/trees", method = RequestMethod.GET)
	public String treePageController() {
		return "trees";
	}
	
	@RequestMapping(value = "/graphs", method = RequestMethod.GET)
	public String graphPageController() {
		return "graphs";
	}
	
	@RequestMapping(value = "/misc", method = RequestMethod.GET)
	public String miscPageController() {
		return "misc";
	}

}
