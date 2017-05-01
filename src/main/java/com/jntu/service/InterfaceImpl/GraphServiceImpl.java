package com.jntu.service.InterfaceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.Interface.GraphServiceInterface;
import com.jntu.util.Utility;

@Service
public class GraphServiceImpl implements GraphServiceInterface {

	// The randomNumberGenerator which is used to generate randomNumbers
	@Autowired
	RandomNumberGeneratorInterface generator;

	// Logger is used to generate logs in the console for debugging purposes
	private static Logger log = Logger.getLogger(GraphServiceImpl.class.getName());
		
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
		case ApplicationConstants.BASIC_GRAPH:
			return processBasicGraphRequest(requestParams);
		case ApplicationConstants.N_PARTITE_GRAPH:
			return processNPartiteGraphRequest(requestParams);
		case ApplicationConstants.COMPLETE_GRAPH:
			return processCompleteGraphRequest(requestParams);
		default:
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Category: " + category + " is INVALID");
		}
		return jsonResponse;
	}

	@Override
	public Map<String, String> processBasicGraphRequest(Map<String, Object> requestParams) {
		
		log.info("Basic graph subcategory has been selected");
		
		return null;
	}

	@Override
	public Map<String, String> processNPartiteGraphRequest(Map<String, Object> requestParams) {
		
		log.info("N Partite graph subcategory has been selected");
		
		return null;
	}

	@Override
	public Map<String, String> processCompleteGraphRequest(Map<String, Object> requestParams) {
		
		log.info("Complete graph subcategory has been selected");

		Map<String, String> jsonResponse = new HashMap<>();

		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
				ApplicationConstants.TEST_CASES,
				ApplicationConstants.MIN_VALUE,
				ApplicationConstants.MAX_VALUE,
				ApplicationConstants.IS_WEIGHTED,
				ApplicationConstants.MIN_WEIGHT,
				ApplicationConstants.MAX_WEIGHT,
				ApplicationConstants.IS_DISTINCT,
				ApplicationConstants.INDEXED_FROM
		};
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
		
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
		
		// Retrieve mandatory parameters from the request

		long testCases, minValue, maxValue;
		long minWeight = ApplicationConstants.NOT_PRESENT, maxWeight = ApplicationConstants.NOT_PRESENT;
		
		int indexedFrom = 0;
		
		boolean isWeighted = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_WEIGHTED, requestParams);
		boolean isDistinct = false;
		
		try {			
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			indexedFrom = Integer.parseInt(requestParams.get(ApplicationConstants.INDEXED_FROM).toString());
			minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
			maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());
			if(testCases < 0) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Test cases cannot be less than zero");
				return jsonResponse;
			}
			if(!(indexedFrom == 0 || indexedFrom == 1)) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Indexed From attribute should be either 0 or 1");
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
			if(isWeighted) {
				minWeight = Long.parseLong(requestParams.get(ApplicationConstants.MIN_WEIGHT).toString());
				maxWeight = Long.parseLong(requestParams.get(ApplicationConstants.MAX_WEIGHT).toString());
				if(minWeight > maxWeight) {
					jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
					jsonResponse.put(ApplicationConstants.DESCRIPTION, "MinWeight should be less than or equal to MaxWeight");
					return jsonResponse;
				}				
				isDistinct = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DISTINCT, requestParams);
				if(isDistinct) {
					long distinctWeights = maxWeight - minWeight + 1;
					long maxEdges = maxValue * (maxValue - 1) / 2;
					
					if(distinctWeights < maxEdges) {
						jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
						jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct weights cannot be generated within the given limits");
						return jsonResponse;
					}
				}
			}
		} catch(NumberFormatException e) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/minValue/maxValue/minWeight/maxWeight/isWeighted/isDistinct");
			return jsonResponse;
		}

		return generateCompleteGraph(testCases,minValue,maxValue,isWeighted,minWeight,maxWeight,isDistinct,indexedFrom);
	}

	private Map<String, String> generateCompleteGraph(long testCases, long minValue, long maxValue, boolean isWeighted,
			long minWeight, long maxWeight, boolean isDistinct, long indexedFrom) {
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		String testData = testCases + "\n";
		
		for(long i = 0;i < testCases;++i) {
			long nodes = generator.getRandomNumber(minValue, maxValue);
			long edges = nodes * (nodes - 1) / 2;
			testData += nodes + " " + edges + "\n";
			long lower = indexedFrom;
			long upper = (indexedFrom == 0 ? nodes - 1 : nodes);
			for(long j = lower;j < upper;++j) {
				for(long k = j + 1;k <= upper;++k) {
					testData += j + " " + k;
					if(isWeighted) {
						long weight = generator.getRandomNumber(minWeight, maxWeight);
						testData += " " + weight;
					}
					testData += "\n";
				}
			}
			testData += "\n";
		}
		
		// Return the response
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

}
