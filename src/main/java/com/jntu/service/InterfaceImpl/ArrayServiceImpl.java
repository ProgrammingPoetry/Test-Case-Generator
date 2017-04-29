package com.jntu.service.InterfaceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.controller.ArrayController;
import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;
import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.random.interfaces.RandomStringGeneratorInterface;
import com.jntu.service.NumberSO;
import com.jntu.service.Interface.ArrayServiceInterface;

@Service
public class ArrayServiceImpl implements ArrayServiceInterface {

	@Autowired
	RandomNumberGeneratorInterface randomNumbers;

	@Autowired
	RandomCharacterGeneratorInterface randomCharacters;

	@Autowired
	RandomStringGeneratorInterface randomStrings;

	private static Logger log = Logger.getLogger(ArrayController.class.getName());

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
		// TODO validations

		// REQUIRED KEYS
		String[] keys = { ApplicationConstants.WHITE_SPACE_CHARACTER, ApplicationConstants.TEST_CASES,
				ApplicationConstants.MIN_SIZE, ApplicationConstants.MAX_SIZE, ApplicationConstants.IS_DISTINCT,
				ApplicationConstants.PRINT_SIZE, ApplicationConstants.SORTED, ApplicationConstants.SPACE_CHARACTER,
				ApplicationConstants.MIN_VALUE, ApplicationConstants.MAX_VALUE, ApplicationConstants.IS_PRIME,
				ApplicationConstants.MULTIPLE_OF };
		// FIXING NULL POINTER EXCEPTIONS
		for (String key : keys) {
			if (!requestParams.containsKey(key)) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION,
						key + " is not set which would usually raise NULLPOINTEREXCEPTION");
			}
		}
		String whiteSpace = "\n";// requestParams.get(ApplicationConstants.WHITE_SPACE_CHARACTER).toString();
		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minSize = Long.parseLong(requestParams.get(ApplicationConstants.MIN_SIZE).toString());
		long maxSize = Long.parseLong(requestParams.get(ApplicationConstants.MAX_SIZE).toString());
		boolean isDistinct = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());
		boolean printSize = Boolean.parseBoolean(requestParams.get(ApplicationConstants.PRINT_SIZE).toString());
		String sorted = requestParams.get(ApplicationConstants.SORTED).toString();
		String seperatedBy = " ";// requestParams.get(ApplicationConstants.SPACE_CHARACTER).toString();
		String data = testCases + whiteSpace;
		long size;
		long minValue = Long.parseLong(requestParams.get(ApplicationConstants.MIN_VALUE).toString());
		long maxValue = Long.parseLong(requestParams.get(ApplicationConstants.MAX_VALUE).toString());
		boolean isPrime = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_PRIME).toString());
		long multipleOf = 1;// Long.parseLong(requestParams.get(ApplicationConstants.MULTIPLE_OF).toString());
		for (long i = 0; i < testCases; i++) {
			size = randomNumbers.getRandomNumber(minSize, maxSize);
			// TODO size validation
			if (printSize)
				data += size + whiteSpace;
			String[] singleTestCase = randomNumbers.getArrayOfNumbers((int) size, minValue, maxValue, isDistinct,
					isPrime, multipleOf, sorted);
			log.debug("TESTCASE : " + (i + 1) + " : " + Arrays.toString(singleTestCase));
			data += Arrays.toString(singleTestCase).replaceAll(",", seperatedBy).replace("[", "").replace("]", "")
					+ whiteSpace;
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
		String whiteSpace = "\n";// requestParams.get(ApplicationConstants.WHITE_SPACE_CHARACTER).toString();
		long testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
		long minSize = Long.parseLong(requestParams.get(ApplicationConstants.MIN_SIZE).toString());
		long maxSize = Long.parseLong(requestParams.get(ApplicationConstants.MAX_SIZE).toString());
		boolean isDistinct = Boolean.parseBoolean(requestParams.get(ApplicationConstants.IS_DISTINCT).toString());
		boolean printSize = Boolean.parseBoolean(requestParams.get(ApplicationConstants.PRINT_SIZE).toString());
		String sorted = requestParams.get(ApplicationConstants.SORTED).toString();
		String seperatedBy = " ";
		requestParams.get(ApplicationConstants.SPACE_CHARACTER).toString();
		String data = testCases + whiteSpace;
		long size;
		char minCharValue = requestParams.get(ApplicationConstants.MIN_VALUE).toString().charAt(0);
		char maxCharValue = requestParams.get(ApplicationConstants.MAX_VALUE).toString().charAt(0);
		boolean specialCharactersAllowed = Boolean
				.parseBoolean(requestParams.get(ApplicationConstants.SPECIAL_CHARACTERS_ALLOWED).toString());
		String charCase = requestParams.get(ApplicationConstants.CHARACTER_CASE).toString();
		for (long i = 0; i < testCases; i++) {
			size = randomNumbers.getRandomNumber(minSize, maxSize);
			if (printSize)
				data += size + whiteSpace;
			if (minCharValue >= 'A' && minCharValue <= 'Z')
				minCharValue = (char) ('a' + minCharValue - 'A');
			if (maxCharValue >= 'A' && maxCharValue <= 'Z')
				maxCharValue = (char) ('a' + maxCharValue - 'A');
			String[] singleTestCase = randomCharacters.getArrayOfCharacters(size, minCharValue, maxCharValue,
					isDistinct, charCase, specialCharactersAllowed, printSize, sorted, seperatedBy);
			data += Arrays.toString(singleTestCase).replaceAll(",", seperatedBy).replace("[", "").replace("]", "")
					+ whiteSpace;
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
			if (printLength)
				data += size + whiteSpace;
			String[] singleTestCase = randomStrings.getArrayOfStrings(size, minStringCharValue, maxStringCharValue,
					minSize, maxSize, specialCharactersAllowedString, stringCase, isPalindrome, printLength,
					individuallySorted, sorted, seperatedBy);
			data += Arrays.toString(singleTestCase).replaceAll(",", seperatedBy).replace("[", "").replace("]", "")
					+ whiteSpace;
		}
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, data);
		return jsonResponse;
	}

	@Override
	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public Object getFileContent(ArrayOfNumbers input) {
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			data.add(noOfTestCases);
		}
		boolean printArraySize = input.getPrintArraySize();
		for (int i = 0; i < noOfTestCases; i++) {
			NumberSO numberSO = new NumberSO();
			numberSO.setArraySize((int) randomNumbers.getRandomNumber(input.getMinSize(), input.getMaxSize()));
			if (printArraySize) {
				data.add(numberSO.getArraySize());
			}
			if (input.getMultipleOf() != 0) {
				numberSO.setMinValue((long) Math.ceil(input.getMinValue() / input.getMultipleOf()));
				numberSO.setMaxValue((long) Math.floor(input.getMaxValue() / input.getMultipleOf()));
			}
			numberSO.setMultipleOf(input.getMultipleOf());
			numberSO.setSorted(input.getSorted());
			ArrayList list = null;
			if (input.getIsPrime() && input.getIsDistinct()) {
				list = randomNumbers.getArrayOfDistinctPrimeNumbers(numberSO);
			} else if (input.getIsPrime()) {
				list = randomNumbers.getArrayOfPrimes(numberSO);
			} else if (input.getIsDistinct()) {
				list = randomNumbers.getArrayOfDistinctNumbers(numberSO);
			} else {
				list = randomNumbers.getArrayOfAnyRandomNumbers(numberSO);
			}
			if ("ascending".equals(numberSO.getSorted())) {
				Collections.sort(list);
			} else if ("descending".equals(numberSO.getSorted())) {
				Collections.sort(list, Collections.reverseOrder());
			}
			data.add(list);
		}
		return data;
	}

	@Override
	public Object getFileContent(ArrayOfCharacters input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getFileContent(ArrayOfStrings input) {
		// TODO Auto-generated method stub
		return null;
	}

}
