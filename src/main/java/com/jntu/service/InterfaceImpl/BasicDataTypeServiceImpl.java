package com.jntu.service.InterfaceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.Interface.BasicDataTypeServiceInterface;
import com.jntu.util.Utility;

@Service
public class BasicDataTypeServiceImpl implements BasicDataTypeServiceInterface {

	// The randomNumberGenerator which is used to generate randomNumbers
	@Autowired
	RandomNumberGeneratorInterface generator;

	// Logger is used to generate logs in the console for debugging purposes
	private static Logger log = Logger.getLogger(BasicDataTypeServiceImpl.class.getName());

	

	
	// The main function which will be called by controller and which this class is responsible for performing
	@Override
	public Map<String, String> getResponse(Map<String, Object> requestParams) {

		Map<String, String> jsonResponse = new HashMap<>();

		// Check if category key is present in the request parameters
		if (!requestParams.containsKey(ApplicationConstants.CATEGORY)) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "No category selected!");
			return jsonResponse;
		}

		String category = requestParams.get(ApplicationConstants.CATEGORY).toString();

		// Determine the value of category key and take appropriate action
		switch (category) {
		case ApplicationConstants.NUMBERS:
			return processNumberRequest(requestParams);
		case ApplicationConstants.CHARACTERS:
			return processCharacterRequest(requestParams);
		case ApplicationConstants.STRINGS:
			return processStringRequest(requestParams);
		default:
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Category: " + category + " is INVALID");
		}
		return jsonResponse;
	}
	
	

	
	// All the below functions process requests based on sub-category
	
	// For numbers sub-category
	@Override
	public Map<String, String> processNumberRequest(Map<String, Object> requestParams) {

		log.info("Numbers subcategory has been selected");

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
			if(testCases < 0)
				throw new NumberFormatException();
			minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
			maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());
		
		} catch(NumberFormatException e) {
			
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/minValue/maxValue");
			return jsonResponse;
			
		}
		
		// Check whether minValue <= maxValue (or else return error response)
		Map<String, String> errorResponse = Utility.minValueLessThanMaxValue(minValue,maxValue);
		if(errorResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return errorResponse;

		// Parse optional parameters (Here we need to validate them too!)
		
		long multipleOf = Utility.parseMultipleOfParam(requestParams);
		if(multipleOf != ApplicationConstants.NOT_PRESENT && multipleOf <= 0) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "MultipleOf must be strictly greater than 0");
			return jsonResponse;
		}
		boolean isPrime = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_PRIME, requestParams);
		boolean isDistinct = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DISTINCT, requestParams);

		if(multipleOf != ApplicationConstants.NOT_PRESENT && isPrime) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "MultipleOf parameter and isPrime parameter cannot be both set at the same time");
			return jsonResponse;
		}
		
		/*
		 * There 'numbers' sub-category can be further divided into 6 cases
		 * depending upon the user's form input.
		 */
		if (multipleOf == ApplicationConstants.NOT_PRESENT && !isPrime && !isDistinct)
			return generateRandomNumbers(testCases, minValue, maxValue);
		else if (multipleOf == ApplicationConstants.NOT_PRESENT && !isPrime && isDistinct)
			return generateDistinctRandomNumbers(testCases, minValue, maxValue);
		else if (isPrime && !isDistinct)
			return generateRandomPrimeNumbers(testCases, minValue, maxValue);
		else if (isPrime && isDistinct)
			return generateDistinctRandomPrimeNumbers(testCases, minValue, maxValue);
		else if (multipleOf != ApplicationConstants.NOT_PRESENT && !isDistinct)
			return generateMultipleOfNumbers(testCases, minValue, maxValue, multipleOf);
		else if (multipleOf != ApplicationConstants.NOT_PRESENT && isDistinct)
			return generateDistinctMultipleOfNumbers(testCases, minValue, maxValue, multipleOf);

		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, "Internal Error occurred");

		return jsonResponse;
	}

	// For character sub-category
	@Override
	public Map<String, String> processCharacterRequest(Map<String, Object> requestParams) {
		
		log.info("Characters subcategory has been selected");
		
		Map<String, String> jsonResponse = new HashMap<>();

		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
			ApplicationConstants.TEST_CASES,
			ApplicationConstants.MIN_VALUE,
			ApplicationConstants.MAX_VALUE,
			ApplicationConstants.CHARACTER_CASE
		};
		
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
				
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
		
				
		// Retrieve mandatory parameters from the request
		long testCases;
		try {
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			if(testCases < 0)
				throw new NumberFormatException();
		} catch(NumberFormatException e) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases");
			return jsonResponse;
		}
		
		/*
		 * In the request, minValue and maxValue are English letters.
		 * We parse them into numbers within the range [0,25]
		 * */
		int minValue, maxValue;
		char ch;
		String minValueParam = requestParams.get(ApplicationConstants.MIN_VALUE).toString();
		if(minValueParam.equals("")) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Min value parameter cannot be empty");
			return jsonResponse;
		}
		ch = minValueParam.charAt(0);
		if(Character.isUpperCase(ch))
			minValue = ch - 'A';
		else if(Character.isLowerCase(ch))
			minValue = ch - 'a';
		else {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Min value must be a character within the range [a-z] or [A-Z]");
			return jsonResponse;
		}
		
		String maxValueParam = requestParams.get(ApplicationConstants.MAX_VALUE).toString();
		if(maxValueParam.equals("")) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Max value parameter cannot be empty");
			return jsonResponse;
		}
		ch = maxValueParam.charAt(0);
		if(Character.isUpperCase(ch))
			maxValue = ch - 'A';
		else if(Character.isLowerCase(ch))
			maxValue = ch - 'a';
		else {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Max value must be a character within the range [a-z] or [A-Z]");
			return jsonResponse;
		}
		
		// Check whether minValue <= maxValue (or else return error response)
		Map<String, String> errorResponse = Utility.minValueLessThanMaxValue(minValue,maxValue);
		if(errorResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return errorResponse;
		
		String characterCase = requestParams.get(ApplicationConstants.CHARACTER_CASE).toString();
		
		// Retrieve optional parameters
		boolean isDistinct = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DISTINCT, requestParams);

		/*
		 * The below function handles all cases which may arise depending upon the user's form input.
		 * Unlike processNumberRequest() which calls several other routines to accomplish its task,
		 * processCharacterRequest() does everything using the below routine itself.
		 * */
		return generateRandomCharacters(testCases, minValue, maxValue, characterCase, isDistinct);
	}

	// For string sub-category
	@Override
	public Map<String, String> processStringRequest(Map<String, Object> requestParams) {
		
		log.info("Strings subcategory has been selected");
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
			ApplicationConstants.TEST_CASES,
			ApplicationConstants.MIN_VALUE,
			ApplicationConstants.MAX_VALUE,
			ApplicationConstants.MIN_STRING_LENGTH,
			ApplicationConstants.MAX_STRING_LENGTH,
			ApplicationConstants.CHARACTER_CASE,
			ApplicationConstants.WHITE_SPACE_CHARACTER
		};
				
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
						
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;

		// Retrieve mandatory parameters from the request
		long testCases, minLength, maxLength;
		try {
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			minLength = Long.parseLong(requestParams.get(ApplicationConstants.MIN_STRING_LENGTH).toString());
			maxLength = Long.parseLong(requestParams.get(ApplicationConstants.MAX_STRING_LENGTH).toString());
			if(testCases < 0 || minLength <= 0 || maxLength <= 0 || minLength > maxLength)
				throw new NumberFormatException();
		} catch(NumberFormatException e) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/minStringLength/maxStringLength");
			return jsonResponse;
		}
		
		String characterCase = requestParams.get(ApplicationConstants.CHARACTER_CASE).toString();
		
		/*
		 * In the request, minValue and maxValue are English letters.
		 * We parse them into numbers within the range [0,25]
		 * */
		int minValue, maxValue;
		char ch;
		String minValueParam = requestParams.get(ApplicationConstants.MIN_VALUE).toString();
		if(minValueParam.equals("")) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Min value parameter cannot be empty");
			return jsonResponse;
		}
		ch = minValueParam.charAt(0);
		if(Character.isUpperCase(ch))
			minValue = ch - 'A';
		else if(Character.isLowerCase(ch))
			minValue = ch - 'a';
		else {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Min value must be a character within the range [a-z] or [A-Z]");
			return jsonResponse;
		}
		
		String maxValueParam = requestParams.get(ApplicationConstants.MAX_VALUE).toString();
		if(maxValueParam.equals("")) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Max value parameter cannot be empty");
			return jsonResponse;
		}
		ch = maxValueParam.charAt(0);
		if(Character.isUpperCase(ch))
			maxValue = ch - 'A';
		else if(Character.isLowerCase(ch))
			maxValue = ch - 'a';
		else {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Max value must be a character within the range [a-z] or [A-Z]");
			return jsonResponse;
		}
		
		// Check whether minValue <= maxValue (or else return error response)
		Map<String, String> errorResponse = Utility.minValueLessThanMaxValue(minValue,maxValue);
		if(errorResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return errorResponse;
		
		boolean isPalindrome = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_PALINDROME, requestParams);
		boolean printLength = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.PRINT_LENGTH, requestParams);
		boolean isSorted = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.SORTED, requestParams);
		
		if(isPalindrome && isSorted) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "isSorted and isPalindrome, both cannot be true at the same time");
			return jsonResponse;
		}
		
		/*
		 * In the request, whiteSpaceCharacter is selected by the user.
		 * We parse them into the appropriate character: '\n' or ' '
		 * */
		char whiteSpaceCharacter;
		String whiteSpace = requestParams.get(ApplicationConstants.WHITE_SPACE_CHARACTER).toString();
		if(whiteSpace.equals(ApplicationConstants.NEW_LINE_CHARACTER))
			whiteSpaceCharacter = '\n';
		else if(whiteSpace.equals(ApplicationConstants.SPACE_CHARACTER))
			whiteSpaceCharacter = ' ';
		else
			whiteSpaceCharacter = '\0';
		
		/*
		 * The below function handles all cases which may arise depending upon the user's form input.
		 * Unlike processNumberRequest() which calls several other routines to accomplish its task,
		 * processStringRequest() does everything using the below routine itself.
		 * */
		return generateRandomStrings(testCases, minValue, maxValue, characterCase,
				minLength, maxLength, isPalindrome, printLength, whiteSpaceCharacter, isSorted);
	}

	
	
	
	
	// The below functions are utility functions specific to numbers sub-category
	
	// This function is used to generate random numbers given testCases,
	// minValue and maxValue
	private Map<String, String> generateRandomNumbers(long testCases, long minValue, long maxValue) {
		log.info("Random Numbers is being executed");
		String testData = testCases + "\n";
		for (long i = 0; i < testCases; ++i) {
			testData += Long.valueOf(generator.getRandomNumber(minValue, maxValue)).toString() + "\n";
		}
		Map<String, String> jsonResponse = new HashMap<>();
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

	// This function is used to generate distinct random numbers given
	// testCases, minValue and maxValue
	private Map<String, String> generateDistinctRandomNumbers(long testCases, long minValue, long maxValue) {
		log.info("Distinct Random Numbers is being executed");
		Map<String, String> jsonResponse = new HashMap<>();

		/*
		 * If the number of testCases required are more than the range of
		 * [minValue,maxValue], then we cannot generate DISTINCT prime numbers.
		 * Hence we need to return failure status with appropriate message
		 */
		if (testCases > maxValue - minValue + 1) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION,
					"Distinct random numbers cannot be generated within" + " the given range and testcases");
			return jsonResponse;
		}

		/*
		 * Since we have to generate distinct numbers, we need some mechanism to
		 * keep track of previously generated numbers. Here we use 'Set'
		 * collection is used to keep track of previously generated numbers.
		 */
		String testData = testCases + "\n";
		Set<Long> set = new HashSet<Long>();
		for (long i = 0; i < testCases; ++i) {
			long number = generator.getRandomNumber(minValue, maxValue);
			if (set.contains(number)) {
				i--;
				continue;
			} else
				set.add(number);
			testData += Long.valueOf(number).toString() + "\n";
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

	// This function is used to generate random numbers which are multiple of a
	// given number
	private Map<String, String> generateMultipleOfNumbers(long testCases, long minValue, long maxValue,
			long multipleOf) {
		log.info("Multiple Of Numbers is being executed");
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		// Check if multiples exist within the provided range
		if(!Utility.multiplesExist(minValue,maxValue,multipleOf)) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "No multiples of " + multipleOf + " exist within the range: [" + minValue + "," + maxValue + "]");
			return jsonResponse;
		}
		
		String testData = testCases + "\n";
		for (long i = 0; i < testCases; ++i) {
			long number;
			while(true) {
				number = generator.getRandomNumber(minValue, maxValue);
				if(number % multipleOf == 0)
					break;
			}
			testData += Long.valueOf(number).toString()
					+ "\n";
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

	// This function is used to generate random numbers which are multiple of a
	// given number and are DISTINCT
	private Map<String, String> generateDistinctMultipleOfNumbers(long testCases, long minValue, long maxValue,
			long multipleOf) {
		log.info("Distinct Multiple Of Numbers is being executed");
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		// Check if multiples exist within the provided range
		if(!Utility.multiplesExist(minValue,maxValue,multipleOf)) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "No multiples of " + multipleOf + " exist within the range: [" + minValue + "," + maxValue + "]");
			return jsonResponse;
		}
		
		// Count the number of distinct multiples possible
		if(Utility.getMultiplesCount(minValue,maxValue,multipleOf) < testCases) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct numbers which are multiple of " + multipleOf
					+ " cannot be generated within the given range and testcases");
			return jsonResponse;
		}

		/*
		 * Since we have to generate distinct numbers, we need some mechanism to
		 * keep track of previously generated numbers. Here we use 'Set'
		 * collection is used to keep track of previously generated numbers.
		 */
		Set<Long> set = new HashSet<Long>();
		String testData = testCases + "\n";
		for (long i = 0; i < testCases; ++i) {
			long number;
			while(true) {
				number = generator.getRandomNumber(minValue, maxValue);
				if(number % multipleOf == 0)
					break;
			}
			if (set.contains(number)) {
				i--;
				continue;
			} else
				set.add(number);
			testData += Long.valueOf(number).toString() + "\n";
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

	// This function is used to generate random PRIME numbers given testCases,
	// minValue and maxValue
	private Map<String, String> generateRandomPrimeNumbers(long testCases, long minValue, long maxValue) {
		log.info("Random Prime Numbers is being executed");
		/*
		 * primeArray contains a list of prime numbers which are in the range
		 * [minValue,maxValue] See the implementation of
		 * generatePrimeNumbersWithinRange() to understand how it is generated
		 */
		ArrayList<Long> primeArray = Utility.generatePrimeNumbersWithinRange(minValue, maxValue);
		long lower = 0;
		long upper = primeArray.size() - 1;
		String testData = testCases + "\n";
		for (long i = 0; i < testCases; ++i) {
			/*
			 * In order to generate random prime numbers, we simple generate a
			 * random index into the primeArray and access the element present
			 * over there.
			 */
			long index = generator.getRandomNumber(lower, upper);
			testData += Long.valueOf(primeArray.get((int) index)).toString() + "\n";
		}
		Map<String, String> jsonResponse = new HashMap<>();
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

	// This function is used to generate DISTINCT random PRIME numbers given
	// testCases, minValue and maxValue
	private Map<String, String> generateDistinctRandomPrimeNumbers(long testCases, long minValue, long maxValue) {
		log.info("Distinct Random Prime Numbers is being executed");
		/*
		 * primeArray contains a list of prime numbers which are in the range
		 * [minValue,maxValue] See the implementation of
		 * generatePrimeNumbersWithinRange() to understand how it is generated
		 */
		ArrayList<Long> primeArray = Utility.generatePrimeNumbersWithinRange(minValue, maxValue);
		Map<String, String> jsonResponse = new HashMap<>();
		long lower = 0;
		long upper = primeArray.size() - 1;

		/*
		 * If the number of testCases required are more than the range of
		 * [minValue,maxValue], then we cannot generate DISTINCT random PRIME
		 * numbers. Hence we need to return failure status with appropriate
		 * message
		 */
		if (testCases > primeArray.size()) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION,
					"Distinct primes cannot be generated within" + " the given range and testcases");
			return jsonResponse;
		}

		String testData = testCases + "\n";
		Set<Long> set = new HashSet<Long>();
		for (long i = 0; i < testCases; ++i) {
			/*
			 * In order to generate random prime numbers, we simple generate a
			 * random index into the primeArray and access the element present
			 * over there.
			 */
			long index = generator.getRandomNumber(lower, upper);
			long number = Long.valueOf(primeArray.get((int) index));
			if (set.contains(number)) {
				i--;
				continue;
			} else
				set.add(number);
			testData += Long.valueOf(number).toString() + "\n";
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}

	
	
	
	// The below utility functions are specific to characters sub-category
	
	
	// This function generates random characters, given testCases, range, characterCase and isDistinct
	private Map<String, String> generateRandomCharacters(long testCases, int minValue, int maxValue,
			String characterCase, boolean isDistinct) {
		log.info("Random Characters is being executed");
		Map<String, String> jsonResponse = new HashMap<>();
		String testData = testCases + "\n";
		
		/*
		 * Since we have to generate distinct characters if isDistinct is true,
		 * we need some mechanism to keep track of previously generated characters.
		 * Here we use 'Set' collection is used to keep track of previously generated
		 * characters.
		 */
		Set<Character> set = new HashSet<Character>();
		
		if(isDistinct) {
			
			/*
			 * If the number of testCases required are more than the range of
			 * [minValue,maxValue], then we cannot generate DISTINCT characters
			 * with the specified case. Hence we need to return failure status with
			 * appropriate message. We perform these checks below.
			 */
			boolean result1 = (characterCase.equals(ApplicationConstants.LOWER_CASE)
					&& (testCases > (maxValue - minValue + 1)));
			boolean result2 = (characterCase.equals(ApplicationConstants.UPPER_CASE)
					&& (testCases > (maxValue - minValue + 1)));
			boolean result3 = (characterCase.equals(ApplicationConstants.MIXED_CASE)
					&& (testCases > (2 * (maxValue - minValue + 1))));
			System.out.println(result1 + " " + result2 + " " + result3);
			if(result1 || result2 || result3) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION,
						"Distinct characters with the given case (lower,upper, or mixed)"
						+ " and testCases cannot be generated");
				return jsonResponse;
			}
		}
		
		// Start generating random characters upto the given testCases
		for(long i = 0;i < testCases;++i) {
			
			// 'index' is used index over into the arrays present in ApplicationConstants
			int index = (int)generator.getRandomNumber(minValue, maxValue);
			/*
			 * 'ch' is used to hold the character which is extracted from the array present
			 * in ApplicationConstants
			 * */
			char ch;
			
			// Determine the characterCase and generate the random character appropriately
			if(characterCase.equals(ApplicationConstants.LOWER_CASE))	
				ch = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[index];
			else if(characterCase.equals(ApplicationConstants.UPPER_CASE))
				ch = ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS[index];
			else if(characterCase.equals(ApplicationConstants.MIXED_CASE)) {
				int upperOrLower = (int)generator.getRandomNumber(0, 1);
				if(upperOrLower == 0)
					ch = ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS[index];
				else
					ch = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[index];
			} else {
				// If the character case doesn't match lower, upper or mixed, then return an error response
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Invalid character case has been sent"
						+ " from the request. Please send a valid one.");
				return jsonResponse;
			}
			
			if(isDistinct) {
				// If isDistinct is true, then check whether the character 'ch' has already been generated or not
				if(set.contains(ch)) {
					// If yes, regenerate again
					i--;
					continue;
				}
				else
					testData += ch + "\n"; // Add it into the testData
				set.add(ch);
			}
			else
				testData += ch + "\n";
			
		}
		
		// Return successful response along with testData
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}
	
	
	
	// The below utility functions are specific to Strings sub-category
	
	// This function generates random Strings with the specified arguments
	private Map<String, String> generateRandomStrings(long testCases, int minValue, int maxValue, String characterCase,
			long minLength, long maxLength, boolean isPalindrome, boolean printLength, char whiteSpaceCharacter, boolean isSorted) {
		log.info("Random Strings is being executed");
		Map<String, String> jsonResponse = new HashMap<>();
		String testData = testCases + "\n";
		
		// Start generating random strings up-to the given testCases
		for(long i = 0;i < testCases;++i) {
			
			String randomString = "";
			long stringLength = generator.getRandomNumber(minLength, maxLength);
			
			// If user chooses to print String length we print it (According to the whiteSpaceCharacter specified)
			if(printLength)
				testData += "" + stringLength + whiteSpaceCharacter;
			
			long j = 0;
			
			/*
			 * If the user chooses to generate palindromic strings, then we generate a randomString of length
			 * which is half of the given length. Let's call this type of string 'randomString'
			 * Later on, we reverse this string, let's call it 'reversedString'. We then append those 2 together
			 * to get a palindromic string.
			 * When the input length of the string is odd, we need to add another character in between 'randomString'
			 * and 'reversedString'. For implementation, see the end of this method.
			 * */
			long count = stringLength;
			if(isPalindrome)
				count /= 2;
			
			// The below loop keeps generating random characters 'count' number-of-times
			while(j < count) {
				
				// 'index' is used index over into the arrays present in ApplicationConstants
				int index = (int)generator.getRandomNumber(minValue, maxValue);
				/*
				 * 'ch' is used to hold the character which is extracted from the array present
				 * in ApplicationConstants
				 * */
				char ch;
				
				// Determine the characterCase and generate the random character appropriately
				if(characterCase.equals(ApplicationConstants.LOWER_CASE))	
					ch = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[index];
				else if(characterCase.equals(ApplicationConstants.UPPER_CASE))
					ch = ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS[index];
				else if(characterCase.equals(ApplicationConstants.MIXED_CASE)) {
					int upperOrLower = (int)generator.getRandomNumber(0, 1);
					if(upperOrLower == 0)
						ch = ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS[index];
					else
						ch = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[index];
				} else {
					// If the character case doesn't match lower, upper or mixed, then return an error response
					jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
					jsonResponse.put(ApplicationConstants.DESCRIPTION, "Invalid character case has been sent"
							+ " from the request. Please send a valid one.");
					return jsonResponse;
				}
				
				randomString += ch;
				j++;
				
			}
			
			// If the user chooses to generate palindromic strings follow the below procedure
			if(isPalindrome) {
				String reversedString = new StringBuilder(randomString).reverse().toString();
				if(stringLength % 2 != 0) {
					int index = (int)generator.getRandomNumber(minValue, maxValue);
					char ch = '\0';
					if(characterCase.equals(ApplicationConstants.LOWER_CASE))	
						ch = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[index];
					else if(characterCase.equals(ApplicationConstants.UPPER_CASE))
						ch = ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS[index];
					else if(characterCase.equals(ApplicationConstants.MIXED_CASE)) {
						int upperOrLower = (int)generator.getRandomNumber(0, 1);
						if(upperOrLower == 0)
							ch = ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS[index];
						else
							ch = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[index];
					}
					randomString += ch + reversedString;	
				}
				else
					randomString += reversedString;
			}
			
			// Sort the array (Note: isSorted and isPalindrome both cannot be true at the same time in requestParams)
			if(isSorted) {
				char array[] = randomString.toCharArray();
				Arrays.sort(array);
				randomString = new String(array);
			}
			
			// After generating a randomString, append it to our testData
			testData += randomString + "\n";
			
		}
		
		// Return successful response along with testData
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}
	
}