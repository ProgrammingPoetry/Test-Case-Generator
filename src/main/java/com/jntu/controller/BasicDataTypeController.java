package com.jntu.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jntu.constants.ApplicationConstants;
import com.jntu.service.BasicDataTypeService;

/*
 * This class handles all the endpoints for "Basic-Data-Type" category
 * Note: For each category use separate controller
 *  
 * */

@Controller
public class BasicDataTypeController {

	// This is the service which will handle our business logic pertaining to "Basic-Data-Type" category
	@Autowired
	BasicDataTypeService service;
	
	// Logger is used for showing debugging statements in the console
	private static Logger log = Logger.getLogger(BasicDataTypeController.class.getName());
	
	@RequestMapping(value = "/datatype", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> numbers(@RequestParam Map<String,Object> requestParams) {
		
		log.info("'/numbers' Controller has been hit");
		log.info("Request params are: " + requestParams);
		
		// Measure the time taken by the user's request
		long startTime = System.currentTimeMillis();
		Map<String,String> jsonResponse = service.getResponse(requestParams);
		long endTime = System.currentTimeMillis();
		
		long timeTaken = endTime - startTime;
		
		// Show the timetaken to the user only when the 'status' is 'success'
		// Otherwise (if there is an exception or some error) it is pointless to show the timetaken
		if(jsonResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.SUCCESS_STATUS))
			jsonResponse.put(ApplicationConstants.TIME_TAKEN, String.valueOf(timeTaken) + " ms");
		
		log.info("Returning jsonResponse, Status is : " + jsonResponse.get(ApplicationConstants.STATUS));
		
		/*
		 * The jsonResponse(which is of type Map<String,String>) will  automatically
		 * be converted into actual JSON format which can then be parsed at the front-end
		 * */ 
		return jsonResponse;
	}
	
}
