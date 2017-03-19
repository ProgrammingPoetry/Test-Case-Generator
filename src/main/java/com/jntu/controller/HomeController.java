package com.jntu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// This controller is used to serve jsp pages of our application

@Controller
public class HomeController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homePageController() {
		return "index";
	}
	
	@RequestMapping(value = "/datatypes", method = RequestMethod.GET)
	public String basicDataTypePageController() {
		return "datatypes";
	}

}
