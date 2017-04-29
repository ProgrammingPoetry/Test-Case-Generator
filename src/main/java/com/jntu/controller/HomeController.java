package com.jntu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;

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
	public String viewArraysPage(Map<String, Object> model) {
		model.put("arrayOfNumbersForm", new ArrayOfNumbers());
		model.put("arrayOfCharactersForm", new ArrayOfCharacters());
		model.put("arrayOfStringsForm", new ArrayOfStrings());
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
