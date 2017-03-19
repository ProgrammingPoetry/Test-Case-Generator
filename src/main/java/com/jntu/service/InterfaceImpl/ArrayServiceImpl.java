package com.jntu.service.InterfaceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.Interface.ArrayServiceInterface;

@Service
public class ArrayServiceImpl implements ArrayServiceInterface {
	
	@Autowired
	RandomNumberGeneratorInterface randomNumbers;

	@Override
	public Map<String, String> getResponse(Map<String, Object> requestParams) {
		Map<String, String> jsonResponse = new HashMap<>();

		if (!requestParams.containsKey(ApplicationConstants.CATEGORY)) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "No category selected!");
			return jsonResponse;
		}

		// TODO validation for all the following fields
		String category = requestParams.get(ApplicationConstants.CATEGORY).toString();
		String whiteSpace = "\n";
		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minSize = Long.parseLong(requestParams.get(ApplicationConstants.MIN_SIZE).toString());
		long maxSize = Long.parseLong(requestParams.get(ApplicationConstants.MAX_SIZE).toString());
		String data = testCases + whiteSpace;
		long size;
		switch (category) {
		case ApplicationConstants.NUMBERS:
			//TODO validations here
			long minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
			long maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());
			boolean isPrime = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_PRIME).toString());
			boolean isDistinct = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());
			long multipleOf = Long.parseLong(requestParams.get(ApplicationConstants.MULTIPLE_OF).toString());
			for (long i = 0; i < testCases; i++){
				size=randomNumbers.getRandomNumber(minSize,maxSize);
				data += randomNumbers.getArrayOfNumbers(size,minValue,maxValue,isDistinct,isPrime,multipleOf," ")+ whiteSpace;
			}
			break;	
		case ApplicationConstants.CHARACTERS:
			for (long i = 0; i < testCases; i++){
				size=randomNumbers.getRandomNumber(minSize,maxSize);
				//data += getArrayOfCharacters(size) + whiteSpace;
			}
			break;
		case ApplicationConstants.STRINGS:
			for (long i = 0; i < testCases; i++){
				size=randomNumbers.getRandomNumber(minSize,maxSize);
				//data += getArrayOfStrings(size) + whiteSpace;
			}
			break;	
		default:
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Category: " + category + " is INVALID");
		}
		return jsonResponse;
	}

}
