package com.jntu.service.InterfaceImpl;

import java.util.ArrayList;
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

	@Override
	public Map<String, String> processNumberRequest(Map<String, Object> requestParams) {

		log.info("Numbers subcategory has been selected");

		Map<String, String> jsonResponse = new HashMap<>();

		// Retrieve all the values from the request parameters

		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
		long maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());

		long multipleOf;
		String multipleOfParam = requestParams.get(ApplicationConstants.MULTIPLE_OF).toString();
		if (!multipleOfParam.equals(""))
			multipleOf = Long.parseLong(multipleOfParam);
		else
			multipleOf = ApplicationConstants.NOT_PRESENT;

		boolean isPrime = Boolean.valueOf(requestParams.get(ApplicationConstants.IS_PRIME).toString());
		boolean isDistinct = Boolean.valueOf(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());

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

	@Override
	public Map<String, String> processCharacterRequest(Map<String, Object> requestParams) {
		log.info("Characters subcategory has been selected");
		
		// Retrieve all the values from the request parameters

		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		
		/*
		 * In the request, minValue and maxValue are English letters.
		 * We parse them into numbers within the range [0,25]
		 * */
		int minValue, maxValue;
		char ch;
		ch = requestParams.get(ApplicationConstants.MIN_VALUE).toString().charAt(0);
		if(Character.isUpperCase(ch))
			minValue = ch - 'A';
		else
			minValue = ch - 'a';
		ch = requestParams.get(ApplicationConstants.MAX_VALUE).toString().charAt(0);
		if(Character.isUpperCase(ch))
			maxValue = ch - 'A';
		else
			maxValue = ch - 'a';
		
		String characterCase = requestParams.get(ApplicationConstants.CHARACTER_CASE).toString();
		boolean isDistinct = Boolean.valueOf(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());

		/*
		 * The below function handles all cases which may arise depending upon the user's form input.
		 * Unlike processNumberRequest() which calls several other routines to accomplish its task,
		 * processCharacterRequest() does everything using the below routine itself.
		 * */
		return generateRandomCharacters(testCases, minValue, maxValue, characterCase, isDistinct);
	}

	@Override
	public Map<String, String> processStringRequest(Map<String, Object> requestParams) {
		
		return null;
	}
	
	// This function is used to generate random numbers given testCases,
	// minValue and maxValue
	private Map<String, String> generateRandomNumbers(long testCases, long minValue, long maxValue) {
		log.info("Random Numbers is being executed");
		String testData = testCases + "\n";
		for (long i = 0; i < testCases; ++i) {
			testData += Long.valueOf(generator.getRandomNumber(minValue, maxValue)).toString() + "\n";
		}
		System.out.println("Done!");
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
		long newMinValue = minValue / multipleOf;
		long newMaxValue = maxValue / multipleOf;
		String testData = testCases + "\n";
		for (long i = 0; i < testCases; ++i) {
			testData += Long.valueOf(generator.getRandomNumber(newMinValue, newMaxValue) * multipleOf).toString()
					+ "\n";
		}
		Map<String, String> jsonResponse = new HashMap<>();
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
		long newMinValue = minValue / multipleOf;
		long newMaxValue = maxValue / multipleOf;

		/*
		 * If the number of testCases required are more than the range of
		 * [minValue,maxValue], then we cannot generate DISTINCT numbers which
		 * are multiple of a given number. Hence we need to return failure
		 * status with appropriate message
		 */
		Map<String, String> jsonResponse = new HashMap<>();
		if (testCases > newMaxValue - newMinValue + 1) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct numbers which are multiple of" + multipleOf
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
			long number = generator.getRandomNumber(newMinValue, newMaxValue) * multipleOf;
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
			
			if((characterCase.equals(ApplicationConstants.LOWER_CASE)
					&& (testCases > ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS.length))
				|| (characterCase.equals(ApplicationConstants.UPPER_CASE)
						&& (testCases > ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS.length))
				|| (characterCase.equals(ApplicationConstants.MIXED_CASE)
						&& (testCases > (ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS.length
								+ ApplicationConstants.UPPER_CASE_CHARACTER_LITERALS.length)))) {
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
	
}