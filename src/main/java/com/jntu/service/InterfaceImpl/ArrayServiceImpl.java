package com.jntu.service.InterfaceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.random.interfaces.RandomStringGeneratorInterface;
import com.jntu.service.Interface.ArrayServiceInterface;

@Service
public class ArrayServiceImpl implements ArrayServiceInterface {

	@Autowired
	RandomNumberGeneratorInterface randomNumbers;

	@Autowired
	RandomCharacterGeneratorInterface randomCharacters;

	@Autowired
	RandomStringGeneratorInterface randomStrings;

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
		switch (category) {
		case ApplicationConstants.NUMBERS:
			return processArrayOfNumbersRequest(requestParams);
		case ApplicationConstants.CHARACTERS:
			return processArrayOfCharactersRequest(requestParams);
		case ApplicationConstants.STRINGS:
			return processArrayOfStringsRequest(requestParams);
		default:
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Category: " + category + " is INVALID");
		}
		return jsonResponse;
	}

	@Override
	public Map<String, String> processArrayOfNumbersRequest(Map<String, Object> requestParams) {
		Map<String, String> jsonResponse = new HashMap<>();
		// TODO validations here
		String whiteSpace = requestParams.get(ApplicationConstants.WHITE_SPACE_CHARACTER).toString();
		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minSize = Long.parseLong(requestParams.get(ApplicationConstants.MIN_SIZE).toString());
		long maxSize = Long.parseLong(requestParams.get(ApplicationConstants.MAX_SIZE).toString());
		boolean isDistinct = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());
		boolean printSize = Boolean.parseBoolean(requestParams.get(ApplicationConstants.PRINT_SIZE).toString());
		String sorted = requestParams.get(ApplicationConstants.SORTED).toString();
		String seperatedBy = requestParams.get(ApplicationConstants.SPACE_CHARACTER).toString();
		String data = testCases + whiteSpace;
		long size;
		long minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
		long maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());
		boolean isPrime = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_PRIME).toString());
		long multipleOf = Long.parseLong(requestParams.get(ApplicationConstants.MULTIPLE_OF).toString());
		for (long i = 0; i < testCases; i++) {
			size = randomNumbers.getRandomNumber(minSize, maxSize);
			data += randomNumbers.getArrayOfNumbers(size, minValue, maxValue, isDistinct, isPrime, multipleOf,
					printSize, sorted, seperatedBy).toString() + whiteSpace;
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, data);
		return jsonResponse;
	}

	@Override
	public Map<String, String> processArrayOfCharactersRequest(Map<String, Object> requestParams) {
		Map<String, String> jsonResponse = new HashMap<>();
		// TODO validations here
		String whiteSpace = requestParams.get(ApplicationConstants.WHITE_SPACE_CHARACTER).toString();
		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minSize = Long.parseLong(requestParams.get(ApplicationConstants.MIN_SIZE).toString());
		long maxSize = Long.parseLong(requestParams.get(ApplicationConstants.MAX_SIZE).toString());
		boolean isDistinct = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());
		boolean printSize = Boolean.parseBoolean(requestParams.get(ApplicationConstants.PRINT_SIZE).toString());
		String sorted = requestParams.get(ApplicationConstants.SORTED).toString();
		String seperatedBy = requestParams.get(ApplicationConstants.SPACE_CHARACTER).toString();
		String data = testCases + whiteSpace;
		long size;
		char minCharValue = requestParams.get(ApplicationConstants.MIN_VALUE).toString().charAt(0);
		char maxCharValue = requestParams.get(ApplicationConstants.MAX_VALUE).toString().charAt(0);
		boolean specialCharactersAllowed = Boolean
				.parseBoolean(requestParams.get(ApplicationConstants.SPECIAL_CHARACTERS_ALLOWED).toString());
		String charCase = requestParams.get(ApplicationConstants.CHARACTER_CASE).toString();
		for (long i = 0; i < testCases; i++) {
			size = randomNumbers.getRandomNumber(minSize, maxSize);
			data += randomCharacters.getArrayOfCharacters(size, minCharValue, maxCharValue, isDistinct, charCase,
					specialCharactersAllowed, printSize, sorted, seperatedBy).toString() + whiteSpace;
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, data);
		return jsonResponse;
	}

	@Override
	public Map<String, String> processArrayOfStringsRequest(Map<String, Object> requestParams) {
		Map<String, String> jsonResponse = new HashMap<>();
		// TODO validations here
		String whiteSpace = requestParams.get(ApplicationConstants.WHITE_SPACE_CHARACTER).toString();
		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minSize = Long.parseLong(requestParams.get(ApplicationConstants.MIN_STRING_LENGTH).toString());
		long maxSize = Long.parseLong(requestParams.get(ApplicationConstants.MAX_STRING_LENGTH).toString());
		boolean isDistinct = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());
		String sorted = requestParams.get(ApplicationConstants.SORTED).toString();
		String seperatedBy = requestParams.get(ApplicationConstants.SPACE_CHARACTER).toString();
		String data = testCases + whiteSpace;
		long size;
		char minStringCharValue = requestParams.get(ApplicationConstants.MIN_CHAR_VALUE).toString().charAt(0);
		char maxStringCharValue = requestParams.get(ApplicationConstants.MAX_CHAR_VALUE).toString().charAt(0);
		boolean specialCharactersAllowedString = Boolean
				.parseBoolean(requestParams.get(ApplicationConstants.SPECIAL_CHARACTERS_ALLOWED).toString());
		boolean printLength = Boolean.parseBoolean(requestParams.get(ApplicationConstants.PRINT_LENGTH).toString());
		String stringCase = requestParams.get(ApplicationConstants.CHARACTER_CASE).toString();
		boolean isPalindrome = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_PALINDROME).toString());
		String individuallySorted = requestParams.get(ApplicationConstants.INDIVIDUALLY_SORTED).toString();
		for (long i = 0; i < testCases; i++) {
			size = randomNumbers.getRandomNumber(minSize, maxSize);
			data += randomStrings.getArrayOfStrings(size, minStringCharValue, maxStringCharValue,
					specialCharactersAllowedString, stringCase, isPalindrome, printLength, individuallySorted, sorted,
					seperatedBy) + whiteSpace;
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, data);
		return jsonResponse;
	}

}
