package com.jntu.service.InterfaceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		
		Map<String, String> jsonResponse = new HashMap<>();

		// Validate the request parameters by checking the mandatory attributes
		String[] requiredParameterNames = {
				ApplicationConstants.TEST_CASES,
				ApplicationConstants.NODES,
				ApplicationConstants.EDGES,
				ApplicationConstants.INDEXED_FROM,
				ApplicationConstants.IS_WEIGHTED,
				ApplicationConstants.MIN_WEIGHT,
				ApplicationConstants.MAX_WEIGHT,
				ApplicationConstants.IS_DISTINCT,
				ApplicationConstants.IS_DIRECTED,
				ApplicationConstants.MULTIPLE_EDGES,
				ApplicationConstants.IS_PATH_PROBLEM,
				ApplicationConstants.SOURCE_NODE,
				ApplicationConstants.DEST_NODE
		};
		
		Map<String, String> validateResponse = Utility.validateRequestParameters(requestParams, requiredParameterNames);
		
		// If the request parameters do not contain the mandatory attributes, return error response
		if(validateResponse.get(ApplicationConstants.STATUS).equals(ApplicationConstants.FAILURE_STATUS))
			return validateResponse;
		
		// Retrieve mandatory parameters from the request
		
		long testCases, nodes, edges;
		long minWeight = ApplicationConstants.NOT_PRESENT, maxWeight = ApplicationConstants.NOT_PRESENT;
		long sourceNode = ApplicationConstants.NOT_PRESENT, destNode = ApplicationConstants.NOT_PRESENT;
		
		int indexedFrom = 0;
		
		boolean isDirected = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_DIRECTED, requestParams);
		boolean multipleEdges = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.MULTIPLE_EDGES, requestParams);
		boolean isPathProblem = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_PATH_PROBLEM, requestParams);
		boolean isWeighted = Utility.parseBooleanValueFromRequestParam(ApplicationConstants.IS_WEIGHTED, requestParams);
		boolean isDistinct = false;
		
		try {			
			testCases = Long.parseLong(requestParams.get(ApplicationConstants.TEST_CASES).toString());
			indexedFrom = Integer.parseInt(requestParams.get(ApplicationConstants.INDEXED_FROM).toString());
			nodes = Long.parseLong(requestParams.get(ApplicationConstants.NODES).toString());
			edges = Long.parseLong(requestParams.get(ApplicationConstants.EDGES).toString());
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
			if(nodes <= 0 || edges < 0) {
				jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
				jsonResponse.put(ApplicationConstants.DESCRIPTION, "Nodes must be greater than zero and Edges must be greater than or equal to zero");
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
					long maxEdges = edges;
					
					if(distinctWeights < maxEdges) {
						jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
						jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct weights cannot be generated within the given limits");
						return jsonResponse;
					}
				}
			}
		} catch(NumberFormatException e) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION, "Couldn't parse the request parameters");
			return jsonResponse;
		}

		if(!isPathProblem)
			return generateBasicGraph(testCases,nodes,edges,isWeighted,minWeight,maxWeight,isDistinct,indexedFrom,isDirected,multipleEdges);
		else
			return generateBasicGraphWithPathProblem(testCases,nodes,edges,isWeighted,minWeight,maxWeight,isDistinct,indexedFrom,isDirected,multipleEdges,sourceNode,destNode);
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
		
		Set<Long> set = new HashSet<>();
		
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
						if(isDistinct) {
							// Until distinct weight hasn't been generated, keep generating weights
							boolean flag = true;
							while(flag) {
								weight = generator.getRandomNumber(minWeight, maxWeight);
								if(!set.contains(weight))
									flag = false;
							}
							set.add(weight);
						}
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
	
	private Map<String, String> generateBasicGraph(long testCases, long nodes, long edges, boolean isWeighted,
			long minWeight, long maxWeight, boolean isDistinct, int indexedFrom, boolean isDirected,
			boolean multipleEdges) {
		
		Map<String, String> jsonResponse = new HashMap<>();
		
		String testData = testCases + "\n";
		
		long lower = indexedFrom;
		long upper = (indexedFrom == 0) ? nodes - 1 : nodes;
		
		long distinctWeights = maxWeight - minWeight + 1;
		
		for(long i = 0;i < testCases;++i) {
			
			// This table is used to store the edges which have been generated
			// This is done in order to keep track of edges generated
			// (So that we don't generate the same edges again when the user selects multipleEdges)
			int[][] table = new int[10000][2];
			int length = 0;
			
			for(int k = 0;k < 10000;++k)
				for(int j = 0;j < 2;++j)
					table[k][j] = (int) ApplicationConstants.NOT_PRESENT;
			
			// This set is used to store the weights
			Set<Long> set = new HashSet<>();
			
			testData += nodes + " " + edges;
			if(edges != 0)
				testData += "\n";
			long remainingEdges = edges;
			
			while(remainingEdges != 0) {
				long node1, node2;
				do {
					node1 = generator.getRandomNumber(lower, upper);
					node2 = generator.getRandomNumber(lower, upper);
				} while(node1 == node2);
				if(multipleEdges) {
					// if multiple edges are allowed
					// irrespective of whether the graph is directed or not, generate edges and add it to testData
					testData += node1 + " " + node2;
					remainingEdges--;
					if(isWeighted) {
						long randomWeight = generator.getRandomNumber(minWeight, maxWeight);
						if(!isDistinct)
							testData += " " + randomWeight;
						else {
							
							if(edges > distinctWeights) {
								jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
								jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct weights cannot be generated within the given limits");
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
							testData += " " + randomWeight;
						}
					}
				}
				else {
					// if multiple edges are not allowed (i.e. between 2 nodes there cannot be multiple direct edges)
					if(!isDirected) {
						// For an undirected graph
						
						// Check whether the edges can be generated
						long maxEdgesForUndirectedGraphWithoutMultipleEdges = nodes * (nodes - 1) / 2;
						if(maxEdgesForUndirectedGraphWithoutMultipleEdges < edges) {
							jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
							jsonResponse.put(ApplicationConstants.DESCRIPTION, "An undirected graph cannot be generated "
									+ "(without multiple edges) with the given number of edges. Try increasing the number of edges");
							return jsonResponse;
						}
						
						int j;
						for(j = 0;j < length;++j) {
							if((node1 == table[j][0] && node2 == table[j][1])
								|| (node2 == table[j][0] && node1 == table[j][1]))
								break;
						}
						if(j < length)
							continue;
						else {
							testData += node1 + " " + node2;
							table[length][0] = (int) node1;
							table[length][1] = (int) node2;
							length++;
							table[length][0] = (int) node2;
							table[length][1] = (int) node1;
							length++;
							remainingEdges--;
							
							if(isWeighted) {
								long randomWeight = generator.getRandomNumber(minWeight, maxWeight);
								if(!isDistinct)
									testData += " " + randomWeight;
								else {
									
									if(edges > distinctWeights) {
										jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
										jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct weights cannot be generated within the given limits");
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
									testData += " " + randomWeight;
								}
							}
						}
					}
					else {
						// For Directed Graph
						
						// Check whether the edges can be generated
						long maxEdgesForDirectedGraphWithoutMultipleEdges = nodes * (nodes - 1);
						if(maxEdgesForDirectedGraphWithoutMultipleEdges < edges) {
							jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
							jsonResponse.put(ApplicationConstants.DESCRIPTION, "A directed graph cannot be generated (with "
									+ "multiple edges) with the given number of edges. Try increasing the number of edges");
							return jsonResponse;
						}
						
						int j;
						for(j = 0;j < length;++j) {
							if(node1 == table[j][0] && node2 == table[j][1])
								break;
						}
						if(j < length)
							continue;
						else {
							testData += node1 + " " + node2;
							table[length][0] = (int) node1;
							table[length][1] = (int) node2;
							length++;
							remainingEdges--;
							
							if(isWeighted) {
								long randomWeight = generator.getRandomNumber(minWeight, maxWeight);
								if(!isDistinct)
									testData += " " + randomWeight;
								else {
									
									if(edges > distinctWeights) {
										jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
										jsonResponse.put(ApplicationConstants.DESCRIPTION, "Distinct weights cannot be generated within the given limits");
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
									testData += " " + randomWeight;
								}
							}
						}
					}
				}
				testData += "\n";
			}
			if(edges == 0)
				testData += "\n";
		}
		
		// Return the response
		jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		jsonResponse.put(ApplicationConstants.DESCRIPTION, ApplicationConstants.SUCCESS_DESC);
		jsonResponse.put(ApplicationConstants.TEST_DATA, testData);
		return jsonResponse;
	}
	
	private Map<String, String> generateBasicGraphWithPathProblem(long testCases, long nodes, long edges,
			boolean isWeighted, long minWeight, long maxWeight, boolean isDistinct, int indexedFrom, boolean isDirected,
			boolean multipleEdges, long sourceNode, long destNode) {

		return null;
	}

}
