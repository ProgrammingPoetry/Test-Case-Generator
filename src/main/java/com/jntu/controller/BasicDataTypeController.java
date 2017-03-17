package com.jntu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicDataTypeController {

	@RequestMapping(value = "/numbers")
	public @ResponseBody Map<String,String> numbers(@RequestParam Map<String,String> requestParams) {
		System.out.println("Inside the controller");
		return null;
	}
	
}
