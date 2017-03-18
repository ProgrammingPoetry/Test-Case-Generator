package com.jntu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jntu.service.BasicDataTypeService;

@Controller
public class BasicDataTypeController {

	@Autowired
	BasicDataTypeService service;
	
	@RequestMapping(value = "/numbers", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> numbers(@RequestParam Map<String,Object> requestParams) {
		
		System.out.println("Inside the controller: " + requestParams);
		
		Map<String,String> jsonResponse = service.processNumberRequest(requestParams);
		
		if(jsonResponse.get("status").equals("success")) {
			System.out.println("Successfully written!");
		} else {
			System.out.println("Error");
		}
		
		return jsonResponse;
	}
	
}
