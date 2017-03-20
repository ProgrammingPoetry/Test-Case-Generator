package com.jntu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jntu.aop.annotations.Validate;
import com.jntu.enums.MainCategories;
import com.jntu.service.Interface.ArrayServiceInterface;

/*
 * This class handles all the end points for "Array" category
 * Note: For each category use separate controller
 *  
 * */
@Controller
@RequestMapping("/*")
public class ArrayController {

	// This is the service which will handle our business logic pertaining to
	// "Array" category
	@Autowired
	ArrayServiceInterface service;


	@RequestMapping(value = "/arrays", method = RequestMethod.POST)
	@Validate(MainCategories.ARRAYS)
	public @ResponseBody Map<String, String> getArrays(@RequestParam Map<String, Object> requestParams) {
		//EVERYTHING IS HANDLED BY AOP
		return service.getResponse(requestParams);
	}

}
