package com.jntu.service.InterfaceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.Interface.MiscServiceInterface;
import com.jntu.util.Utility;

@Service
public class MiscServiceImpl implements MiscServiceInterface {

	// The randomNumberGenerator which is used to generate randomNumbers
	@Autowired
	RandomNumberGeneratorInterface generator;

	// Logger is used to generate logs in the console for debugging purposes
	private static Logger log = Logger.getLogger(MiscServiceImpl.class.getName());
		
	@Override
	public Map<String, String> getResponse(Map<String, Object> requestParams) {
		
		Map<String, String> jsonResponse = new HashMap<>();

		if (!requestParams.containsKey(ApplicationConstants.CATEGORY)) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "No category selected!");
			return jsonResponse;
		}

		String category = requestParams.get(ApplicationConstants.CATEGORY).toString();

		switch (category) {
		case ApplicationConstants.FIBONACCI_SERIES:
			return processFibonacciRequest(requestParams);
		default:
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Category: " + category + " is INVALID");
		}
		return jsonResponse;
	}

	@Override
	public Map<String, String> processFibonacciRequest(Map<String, Object> requestParams) {
		
		log.info("Fibonacci subcategory has been selected");

		Map<String, String> jsonResponse = new HashMap<>();

		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
				ApplicationConstants.TEST_CASES,
				ApplicationConstants.MIN_VALUE,
				ApplicationConstants.MAX_VALUE
		};
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
		
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
		
		// Retrieve mandatory parameters from the request

		long testCases, minValue, maxValue;
		
		try {			
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
			maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());
			if(testCases < 0) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Test cases cannot be less than zero");
				return jsonResponse;
			}
			if(minValue <= 0 || maxValue <= 0) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Minvalue and maxvalue must be greater than zero");
				return jsonResponse;
			}
			if(minValue > maxValue) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "MinValue should be less than or equal to MaxValue");
				return jsonResponse;
			}
		} catch(NumberFormatException e) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/minValue/maxValue");
			return jsonResponse;
		}

		return generateFibonacciSeries(testCases,minValue,maxValue);
	}

	private Map<String, String> generateFibonacciSeries(long testCases, long minValue, long maxValue) {
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		String testData = testCases + "\n";
		for(long i = 0;i < testCases;++i) {
			long n = generator.getRandomNumber(minValue, maxValue);
			testData += n + "\n";
			if(n >= 1)
				testData += "0 ";
			if(n >= 2)
				testData += "1 ";
			if(n > 2) {
				long a = 0, b = 1;
				for(long j = 3;j <= n;++j) {
					long c = a + b;
					testData += c + " ";
					a = b;
					b = c;
				}
			}
			testData += "\n";
		}
		
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

}
