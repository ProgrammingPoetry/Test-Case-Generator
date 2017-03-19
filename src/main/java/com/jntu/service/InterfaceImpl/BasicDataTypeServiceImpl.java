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
		
		return null;
	}

	@Override
	public Map<String, String> processStringRequest(Map<String, Object> requestParams) {
		// TODO Auto-generated method stub
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

}