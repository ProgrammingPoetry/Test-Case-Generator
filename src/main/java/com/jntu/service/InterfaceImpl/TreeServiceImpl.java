package com.jntu.service.InterfaceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.Interface.TreeServiceInterface;
import com.jntu.util.Utility;

@Service
public class TreeServiceImpl implements TreeServiceInterface {

	// The randomNumberGenerator which is used to generate randomNumbers
	@Autowired
	RandomNumberGeneratorInterface generator;

	// Logger is used to generate logs in the console for debugging purposes
	private static Logger log = Logger.getLogger(TreeServiceImpl.class.getName());
	
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
		case ApplicationConstants.NUMERIC_TREE:
			return processNumericTreeRequest(requestParams);
		case ApplicationConstants.FULL_BINARY_TREE:
			return processFullBinaryTreeRequest(requestParams);
		case ApplicationConstants.SKEW_TREE:
			return processSkewTreeRequest(requestParams);
		case ApplicationConstants.BINARY_SEARCH_TREE:
			return processBinarySearchTreeRequest(requestParams);
		case ApplicationConstants.BALANCED_BINARY_SEARCH_TREE:
			return processBalancedBinarySearchTreeRequest(requestParams);
		default:
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Category: " + category + " is INVALID");
		}
		return jsonResponse;
	}

	@Override
	public Map<String, String> processNumericTreeRequest(Map<String, Object> requestParams) {
		
		log.info("Numeric tree subcategory has been selected");

		Map<String, String> jsonResponse = new HashMap<>();

		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
				ApplicationConstants.TEST_CASES,
				ApplicationConstants.NODES,
				ApplicationConstants.INDEXED_FROM,
				ApplicationConstants.IS_WEIGHTED,
				ApplicationConstants.MIN_WEIGHT,
				ApplicationConstants.MAX_WEIGHT,
				ApplicationConstants.IS_DISTINCT
		};
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
		
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
		
		// Retrieve mandatory parameters from the request

		long testCases;
		long minWeight = ApplicationConstants.NOT_PRESENT, maxWeight = ApplicationConstants.NOT_PRESENT;
		int nodes, indexedFrom;
		boolean isDistinct = false;
		
		boolean isWeighted = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_WEIGHTED, requestParams);
		
		try {
			
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			nodes = Integer.parseInt(requestParams.get(ApplicationConstants.NODES).toString());
			indexedFrom = Integer.parseInt(requestParams.get(ApplicationConstants.INDEXED_FROM).toString());
			if(testCases < 0 || nodes <= 0 || (indexedFrom != 0 && indexedFrom != 1))
				throw new NumberFormatException();
			if(isWeighted) {	
				minWeight = Long.parseLong(requestParams.get(ApplicationConstants.MIN_WEIGHT).toString());
				maxWeight = Long.parseLong(requestParams.get(ApplicationConstants.MAX_WEIGHT).toString());
				if(minWeight > maxWeight)
					throw new NumberFormatException();
				isDistinct = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DISTINCT, requestParams);
			}
		
		} catch(NumberFormatException e) {
			
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/nodes/indexedFrom/minWeight/maxWeight/isDistinct");
			return jsonResponse;
			
		}

		return generateRandomNumericTree(testCases, nodes, indexedFrom, isWeighted, minWeight, maxWeight, isDistinct);
	}

	@Override
	public Map<String, String> processFullBinaryTreeRequest(Map<String, Object> requestParams) {
		
		log.info("Full binary tree subcategory has been selected");
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
			ApplicationConstants.TEST_CASES,
			ApplicationConstants.NUMBER_OF_LEVELS,
			ApplicationConstants.INDEXED_FROM,
			ApplicationConstants.IS_WEIGHTED,
			ApplicationConstants.MIN_WEIGHT,
			ApplicationConstants.MAX_WEIGHT,
			ApplicationConstants.IS_DISTINCT
		};
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
				
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
				
		// Retrieve mandatory parameters from the request

		long testCases;
		long minWeight = ApplicationConstants.NOT_PRESENT, maxWeight = ApplicationConstants.NOT_PRESENT;
		int numberOfLevels, indexedFrom;
		boolean isDistinct = false;
		
		boolean isWeighted = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_WEIGHTED, requestParams);
		
		try {
			
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			numberOfLevels = Integer.parseInt(requestParams.get(ApplicationConstants.NUMBER_OF_LEVELS).toString());
			indexedFrom = Integer.parseInt(requestParams.get(ApplicationConstants.INDEXED_FROM).toString());
			if(testCases < 0 || numberOfLevels <= 0 || (indexedFrom != 0 && indexedFrom != 1))
				throw new NumberFormatException();
			if(isWeighted) {	
				minWeight = Long.parseLong(requestParams.get(ApplicationConstants.MIN_WEIGHT).toString());
				maxWeight = Long.parseLong(requestParams.get(ApplicationConstants.MAX_WEIGHT).toString());
				if(minWeight > maxWeight)
					throw new NumberFormatException();
				isDistinct = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DISTINCT, requestParams);
			}
		
		} catch(NumberFormatException e) {
			
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/numberOfLevels/indexedFrom/minWeight/maxWeight/isDistinct");
			return jsonResponse;
			
		}

		return generateRandomFullBinaryTree(testCases, numberOfLevels, indexedFrom, isWeighted, minWeight, maxWeight, isDistinct);
	}

	@Override
	public Map<String, String> processSkewTreeRequest(Map<String, Object> requestParams) {
		
		log.info("Skew tree subcategory has been selected");
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
			ApplicationConstants.TEST_CASES,
			ApplicationConstants.NUMBER_OF_LEVELS,
			ApplicationConstants.INDEXED_FROM,
			ApplicationConstants.IS_WEIGHTED,
			ApplicationConstants.MIN_WEIGHT,
			ApplicationConstants.MAX_WEIGHT,
			ApplicationConstants.IS_DISTINCT
		};
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
				
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
				
		// Retrieve mandatory parameters from the request

		long testCases;
		long minWeight = ApplicationConstants.NOT_PRESENT, maxWeight = ApplicationConstants.NOT_PRESENT;
		int numberOfLevels, indexedFrom;
		boolean isDistinct = false;
		
		boolean isWeighted = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_WEIGHTED, requestParams);
		
		try {
			
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			numberOfLevels = Integer.parseInt(requestParams.get(ApplicationConstants.NUMBER_OF_LEVELS).toString());
			indexedFrom = Integer.parseInt(requestParams.get(ApplicationConstants.INDEXED_FROM).toString());
			if(testCases < 0 || numberOfLevels <= 0 || (indexedFrom != 0 && indexedFrom != 1))
				throw new NumberFormatException();
			if(isWeighted) {	
				minWeight = Long.parseLong(requestParams.get(ApplicationConstants.MIN_WEIGHT).toString());
				maxWeight = Long.parseLong(requestParams.get(ApplicationConstants.MAX_WEIGHT).toString());
				if(minWeight > maxWeight)
					throw new NumberFormatException();
				isDistinct = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DISTINCT, requestParams);
			}
		
		} catch(NumberFormatException e) {
			
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse testcases/numberOfLevels/indexedFrom/minWeight/maxWeight/isDistinct");
			return jsonResponse;
			
		}

		return generateRandomSkewTree(testCases, numberOfLevels, indexedFrom, isWeighted, minWeight, maxWeight, isDistinct);
	}

	@Override
	public Map<String, String> processBinarySearchTreeRequest(Map<String, Object> requestParams) {

		log.info("Binary search tree subcategory has been selected");
		
		return null;
	}

	@Override
	public Map<String, String> processBalancedBinarySearchTreeRequest(Map<String, Object> requestParams) {

		log.info("Balanced binary search tree subcategory has been selected");
		
		return null;
	}

	private Map<String, String> generateRandomNumericTree(long testCases, int nodes, int indexedFrom,
			boolean isWeighted, long minWeight, long maxWeight, boolean isDistinct) {
		
		log.info("Generate random numeric tree is being executed");
		
		Map<String,String> jsonResponse = new HashMap<>();
		String testData = testCases + "\n";
		
		// 'lower' and 'upper' is used for generating random node numbers within the specified limits
		int lower = indexedFrom;
		int upper = (indexedFrom == 0 ? nodes - 1 : nodes);
		
		// Start generating testData (We use Union-Find data structure to generate a spanning tree)
		for(long i = 0;i < testCases;++i) {
			
			// Before generating the tree, we need to print the number of nodes in the testData
			testData += nodes + "\n";
			
			/*
			 * allNotConnected variable is used to check whether all the nodes in the
			 * tree are connected are not
			 * */
			boolean allNotConnected = true;
			
			// Max possible edges in a spanning tree with 'n' nodes is ('n' - 1)
			int edgeCount = 0;
			
			// Set is used to keep track of previously generated weights
			Set<Long> set = new HashSet<Long>();
			
			// This the array which we will be using in union-find data structure
			int[] allNodes = new int[nodes + 1];
			
			// Initially all the nodes are not connected
			Utility.initializeNodes(allNodes);
			
			while(allNotConnected) {
				
				// Keep generating random nodes, until the nodeValues are unequal
				int x = 0, y = 0;
				while(x == y) {
					x = (int) generator.getRandomNumber(lower, upper);
					y = (int) generator.getRandomNumber(lower, upper);
				}
				
				// Try to add an edge to node X and node Y
				boolean connectedTheNodes = Utility.connectNodes(x,y,allNodes);
				if(connectedTheNodes) {

					// If the nodes have been connected now, increment the edgeCount
					edgeCount++;
					if(isWeighted) {
						
						// Generate a random weight
						long randomWeight = -1;
						if(isDistinct) {
							
							if((nodes - 1) > (maxWeight - minWeight + 1)) {
								jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
								jsonResponse.put(ApplicationConstants.DESCRIPTION, "Cannot generate distinct weights within"
										+ " the given range!");
								return jsonResponse;
							}
							
							// Until distinct weight hasn't been generated, keep generating weights
							boolean flag = true;
							while(flag) {
								randomWeight = generator.getRandomNumber(minWeight, maxWeight);
								if(!set.contains(randomWeight))
									flag = false;
							}
							set.add(randomWeight);
						}
						else
							randomWeight = generator.getRandomNumber(minWeight, maxWeight);
						
						// Add the edge along with weight to the testData
						testData += x + " " + y + " " + randomWeight + "\n";
					}
					else
						testData += x + " " + y + "\n";
						// Add only the edge to the testData (if isWeighted is false)
				}
				// else case: If the nodes are not connected we simply repeat the loop
				
				// If edge count is equal to 'n' - 1, then break out of the loop
				if(edgeCount == nodes - 1)
					allNotConnected = false;
			}
			
		}
		
		// Return the response
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}
	
	private Map<String, String> generateRandomFullBinaryTree(long testCases, int numberOfLevels, int indexedFrom,
			boolean isWeighted, long minWeight, long maxWeight, boolean isDistinct) {
		
		log.info("Generate random full binary tree is being executed");
		
		Map<String,String> jsonResponse = new HashMap<>();
		String testData = testCases + "\n";
		
		// Calculate the number of nodes given the number of levels
		int nodes = (int) Math.pow(2, numberOfLevels) - 1;
		
		// 'lower' and 'upper' is used for generating random node numbers within the specified limits
		int lower = indexedFrom;
		int upper = (indexedFrom == 0 ? nodes - 1 : nodes);
		
		// Start generating testData
		for(long i = 0;i < testCases;++i) {
			
			// Before generating the tree, we need to print the number of nodes in the testData
			testData += nodes + "\n";
			
			Set<Long> set = new HashSet<>();
			
			/*
			 * Below is an array which holds our full binary tree.
			 * We simply generate a permutation of an array of integers within the range [lower,upper]
			 * and think of it as a full-binary-tree in array representation
			 * */
			List<Integer> a = new ArrayList<Integer>();
			for(int j = lower;j <= upper;++j)
				a.add(j);
			Collections.shuffle(a);
			
			/*
			 * Now, the left-child of node 'i' is at position 2 * i + 1
			 * and right-child is at position 2 * i + 2
			 * 
			 * We extract those nodes and put them in testData along with the weight
			 * */
			for(int j = 0;j < a.size()/2;++j) {
				
				int nodeValue = a.get(j);
				int leftNodeValue = a.get(2 * j + 1);
				int rightNodeValue = a.get(2 * j + 2);
				
				if(isWeighted) {
					long randomWeight1 = generator.getRandomNumber(minWeight, maxWeight);
					long randomWeight2 = generator.getRandomNumber(minWeight, maxWeight);
					if(isDistinct) {
						if((nodes - 1) > (maxWeight - minWeight + 1)) {
							jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
							jsonResponse.put(ApplicationConstants.DESCRIPTION, "Cannot generate distinct weights within"
									+ " the given range!");
							return jsonResponse;
						}
						while(set.contains(randomWeight1))
							randomWeight1 = generator.getRandomNumber(minWeight, maxWeight);
						while(set.contains(randomWeight2))
							randomWeight2 = generator.getRandomNumber(minWeight, maxWeight);
						set.add(randomWeight1);
						set.add(randomWeight2);
					}
					testData += nodeValue + " " + leftNodeValue + " " + randomWeight1 + "\n";
					testData += nodeValue + " " + rightNodeValue + " " + randomWeight2 + "\n";
				}
				else {
					testData += nodeValue + " " + leftNodeValue + " " + "\n";
					testData += nodeValue + " " + rightNodeValue + " " + "\n";
				}
				
			}
		}
		
		// Return the response
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}
	
	private Map<String, String> generateRandomSkewTree(long testCases, int numberOfLevels, int indexedFrom,
			boolean isWeighted, long minWeight, long maxWeight, boolean isDistinct) {
	
		log.info("Generate random skew tree is being executed");
		
		Map<String,String> jsonResponse = new HashMap<>();
		String testData = testCases + "\n";
		
		// Calculate the number of nodes given the number of levels
		int nodes = (int) Math.pow(2, numberOfLevels) - 1;
		
		// 'lower' and 'upper' is used for generating random node numbers within the specified limits
		int lower = indexedFrom;
		int upper = (indexedFrom == 0 ? nodes - 1 : nodes);
		
		// Start generating testData
		for(long i = 0;i < testCases;++i) {
			
			// Before generating the tree, we need to print the number of nodes in the testData
			testData += nodes + "\n";
			
			Set<Long> set = new HashSet<>();
			
			/*
			 * Below is an array which holds our Skew tree.
			 * We simply generate a permutation of an array of integers within the range [lower,upper]
			 * and think of it as a Skew-tree in array representation
			 * */
			List<Integer> a = new ArrayList<Integer>();
			for(int j = lower;j <= upper;++j)
				a.add(j);
			Collections.shuffle(a);
			
			/*
			 * Node 'i' is linked to node 'i+1' etc... (Skew tree)
			 * We extract those nodes and put them in testData along with the weight
			 * */
			for(int j = 0;j < a.size() - 1;++j) {
				
				int nodeValue = a.get(j);
				int anotherNodeValue = a.get(j + 1);
				
				if(isWeighted) {
					long randomWeight1 = generator.getRandomNumber(minWeight, maxWeight);
					long randomWeight2 = generator.getRandomNumber(minWeight, maxWeight);
					if(isDistinct) {
						if((nodes - 1) > (maxWeight - minWeight + 1)) {
							jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
							jsonResponse.put(ApplicationConstants.DESCRIPTION, "Cannot generate distinct weights within"
									+ " the given range!");
							return jsonResponse;
						}
						while(set.contains(randomWeight1))
							randomWeight1 = generator.getRandomNumber(minWeight, maxWeight);
						while(set.contains(randomWeight2))
							randomWeight2 = generator.getRandomNumber(minWeight, maxWeight);
						set.add(randomWeight1);
						set.add(randomWeight2);
					}
					testData += nodeValue + " " + anotherNodeValue + " " + randomWeight1 + "\n";
				}
				else
					testData += nodeValue + " " + anotherNodeValue + " " + "\n";
				
			}
		}
		
		// Return the response
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}
}
