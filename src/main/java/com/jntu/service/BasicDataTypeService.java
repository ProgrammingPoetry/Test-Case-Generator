package com.jntu.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.random.RandomNumberGenerator;

@Service
public class BasicDataTypeService {

	@Autowired
	RandomNumberGenerator generator;

	public Map<String,String> processNumberRequest(Map<String, Object> requestParams) {
		
		Map<String,String> jsonResponse = new HashMap<>();
		
		System.out.println("Inside the service");
		int min = Integer.parseInt(requestParams.get("min").toString());
		int max = Integer.parseInt(requestParams.get("max").toString());
		
		int randomNumber = (int) generator.getRandomNumber(min, max);
		System.out.println("Random number generated is: " + randomNumber);
		
	    String data = randomNumber + "\n" + randomNumber;
		
	    jsonResponse.put("status", "success");
		jsonResponse.put("description", "Successfully generated the test data");
		jsonResponse.put("Time Taken", "10 sec");
		jsonResponse.put("testdata", data);
	    
		return jsonResponse;
	}
	
}