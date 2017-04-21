package com.jntu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.jntu.constants.ApplicationConstants;

/*
 * This class contains all the utility functions which we will be using in our application
 * Note: If you need a function immediately for testing purposes (example printing an array etc)
 * then write that function here. Do not populate the service-layer or controller-layer with
 * unnecessary functions. Write them here as static functions and access them wherever you require
 * using the format: Utility.<myFunction>()
 * 		where: myFunction is user defined function
 * */

public class Utility {

	// Logger is used to generate logs in the console for debugging purposes
	private static Logger log = Logger.getLogger(Utility.class.getName());
	
	public static ArrayList<Long> sieve() {
		ArrayList<Long> list = new ArrayList<>();
		boolean[] a = new boolean[1000000];
		for (int i = 0; i < 1000000; ++i)
			a[i] = true;
		a[0] = a[1] = false;
		for (int i = 2; i < 1000000; ++i) {
			if (a[i]) {
				int k = 2;
				while (i * k < 1000000) {
					a[i * k] = false;
					k++;
				}
			}
		}
		for (int i = 0; i < 1000000; ++i)
			if (a[i])
				list.add((long) i);
		return list;
	}

	public static ArrayList<Long> generatePrimeNumbersWithinRange(long minValue, long maxValue) {
		ArrayList<Long> allPrimes = sieve();
		ArrayList<Long> primesArray = new ArrayList<>();

		int i;
		for (i = 0; i < allPrimes.size(); ++i)
			if (allPrimes.get(i) >= minValue)
				break;
		for (; i < allPrimes.size(); ++i)
			if (allPrimes.get(i) <= maxValue)
				primesArray.add(allPrimes.get(i));
			else
				break;
		// System.out.println("All Primes array is: ");
		// printList(primesArray);
		return primesArray;
	}

	public static void printList(ArrayList<Long> list) {
		for (int i = 0; i < list.size(); ++i) {
			if (i % 10 == 0)
				System.out.println("");
			System.out.print(list.get(i) + " ");
		}
	}

	/*
	 * The below 3 functions are used in Union-Find Data structure. This data
	 * structure is used to generate spanning tree
	 */

	public static void initializeNodes(int[] allNodes) {
		for (int i = 0; i < allNodes.length; ++i)
			allNodes[i] = i;
	}

	public static int getRootNode(int[] allNodes, int x) {
		while (allNodes[x] != x)
			x = allNodes[x];

		return x;
	}

	public static boolean connectNodes(int x, int y, int[] allNodes) {
		int rootX = getRootNode(allNodes, x);
		int rootY = getRootNode(allNodes, y);

		if (rootX == rootY)
			return false;
		else {
			int addToX = ThreadLocalRandom.current().nextInt(0, 2);
			if (addToX == 1)
				allNodes[rootY] = x;
			else
				allNodes[rootX] = y;
			return true;
		}
	}

	// The 3 functions end here

	// This function checks whether all the required attributes are present in
	// the request parameters or not
	public static Map<String, String> validateRequestParameters(Map<String, Object> requestParams,
			String[] requiredParameterNames) {

		Map<String, String> jsonResponse = new HashMap<>();

		for (String requiredParameterName : requiredParameterNames) {
			if (!requestParams.containsKey(requiredParameterName)) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION,
						"Missing required attribute: " + requiredParameterName);
				return jsonResponse;
			}
		}

		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, "All attributes are present");
		return jsonResponse;
	}

	// This function parses multipleOf parameter
	public static long parseMultipleOfParam(Map<String, Object> requestParams) {
		long multipleOf;
		if (!requestParams.containsKey(ApplicationConstants.MULTIPLE_OF))
			multipleOf = ApplicationConstants.NOT_PRESENT;
		else {
			String multipleOfParam = requestParams.get(ApplicationConstants.MULTIPLE_OF).toString();
			try {
				if (!multipleOfParam.equals(""))
					multipleOf = Long.parseLong(multipleOfParam);
				else
					multipleOf = ApplicationConstants.NOT_PRESENT;
			} catch (NumberFormatException e) {
				log.info("MultipleOf parameter parsing failed. It is specified as: " + multipleOfParam + 
						" Currently assuming that it is not present and proceeding ahead with generating test data.");
				multipleOf = ApplicationConstants.NOT_PRESENT;
			}
		}
		return multipleOf;
	}

	// This function is used to parse boolean value from the request parameters
	// (default value is false)
	public static boolean parseBooleanValueFromRequestParam(String parameterName, Map<String, Object> requestParams) {
		boolean booleanParameter;
		if (!requestParams.containsKey(parameterName))
			booleanParameter = false; // By default it is false
		else
			booleanParameter = Boolean.valueOf(requestParams.get(parameterName).toString());
		return booleanParameter;
	}

	// Simple function to check whether minValue <= maxValue (success, or else failure)
	public static Map<String, String> minValueLessThanMaxValue(long minValue, long maxValue) {
		Map<String, String> jsonResponse = new HashMap<>();
		if(minValue > maxValue) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Error: minValue must be less than or equal to maxValue");
		}
		else
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		return jsonResponse;
	}

	// A function to check whether multiples of the number 'multipleOf' exists in the range [minValue,maxValue]
	public static boolean multiplesExist(long minValue, long maxValue, long multipleOf) {
		// Assumes minValue < maxValue
		if(minValue % multipleOf == 0 || maxValue % multipleOf == 0)
			return true;
		double lowerLimit = minValue / (multipleOf * 1.0);
		double upperLimit = maxValue / (multipleOf * 1.0);
		boolean result = (upperLimit - lowerLimit) >= 1.0;
		// System.out.println("Lower limit is: " + lowerLimit + " Upper limit is: " + upperLimit + " Result: " + result);
		return result;
	}

	public static long getMultiplesCount(long minValue, long maxValue, long multipleOf) {
		// Assumes minValue < maxValue
		double lowerLimit = minValue / (multipleOf * 1.0);
		double upperLimit = maxValue / (multipleOf * 1.0);
		long result = (long)(upperLimit - lowerLimit);
		boolean minValueIsAMultiple = (minValue % multipleOf == 0);
		boolean maxValueIsAMultiple = (maxValue % multipleOf == 0);
		if(minValueIsAMultiple || maxValueIsAMultiple)
			result++;
		return result;
	}

}
