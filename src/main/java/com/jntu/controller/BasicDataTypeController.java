package com.jntu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicDataTypeController {

	@RequestMapping(value = "/numbers", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> numbers(@RequestParam Map<String,Object> requestParams) {
		System.out.println("Inside the controller: " + requestParams);
		return null;
	}
	
}
