package com.jntu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

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

	public static ArrayList<Long> sieve() {
		ArrayList<Long> list = new ArrayList<>();
		boolean[] a = new boolean[1000000];
		for(int i = 0;i < 1000000;++i)
			a[i] = true;
		a[0] = a[1] = false;
		for(int i = 2;i < 1000000;++i) {
			if(a[i]) {
				int k = 2;
				while(i * k < 1000000) {
					a[i * k] = false;
					k++;
				}
			}
		}
		for(int i = 0;i < 1000000;++i)
			if(a[i])
				list.add((long)i);
		return list;
	}
	
	public static ArrayList<Long> generatePrimeNumbersWithinRange(long minValue, long maxValue) {
		ArrayList<Long> allPrimes = sieve();
		ArrayList<Long> primesArray = new ArrayList<>();
		
		int i;
		for(i = 0;i < allPrimes.size();++i)
			if(allPrimes.get(i) >= minValue)
				break;
		for(;i < allPrimes.size();++i)
			if(allPrimes.get(i) <= maxValue)
				primesArray.add(allPrimes.get(i));
			else
				break;
		// System.out.println("All Primes array is: ");
		// printList(primesArray);
		return primesArray;
	}
	
	public static void printList(ArrayList<Long> list) {
		for(int i = 0;i < list.size();++i) {
			if(i % 10 == 0)
				System.out.println("");
			System.out.print(list.get(i) + " ");
		}
	}
	
	/*
	 * The below 3 functions are used in Union-Find Data structure.
	 * This data structure is used to generate spanning tree
	 * */
	
	public static void initializeNodes(int[] allNodes) {
		for(int i = 0;i < allNodes.length;++i)
			allNodes[i] = i;
	}
	
	public static int getRootNode(int[] allNodes, int x) {
		while(allNodes[x] != x)
			x = allNodes[x];
		
		return x;
	}
	
	public static boolean connectNodes(int x,int y,int[] allNodes) {
		int rootX = getRootNode(allNodes, x);
		int rootY = getRootNode(allNodes, y);
		
		if(rootX == rootY)
			return false;
		else {
			int addToX = ThreadLocalRandom.current().nextInt(0,2);
			if(addToX == 1)
				allNodes[rootY] = x;
			else
				allNodes[rootX] = y;
			return true;
		}
	}
	
	// The 3 functions end here
	
	// This function checks whether all the required attributes are present in the request parameters or not
	public static Map<String, String> validateRequestParameters(
			Map<String, Object> requestParams,
			String[] requiredParameterNames) {
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		for(String requiredParameterName : requiredParameterNames) {
			if(!requestParams.containsKey(requiredParameterName)) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Missing required attribute: " + requiredParameterName);
				return jsonResponse;
			}
		}
		
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, "All attributes are present");
		return jsonResponse;
	}

}
