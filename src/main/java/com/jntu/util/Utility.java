package com.jntu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.jntu.constants.ApplicationConstants;
import com.jntu.model.BSTNode;
import com.jntu.random.impl.RandomNumberGeneratorImpl;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;

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

	// The randomNumberGenerator which is used to generate randomNumbers

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
				log.info("MultipleOf parameter parsing failed. It is specified as: " + multipleOfParam
						+ " Currently assuming that it is not present and proceeding ahead with generating test data.");
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

	// Simple function to check whether minValue <= maxValue (success, or else
	// failure)
	public static Map<String, String> minValueLessThanMaxValue(long minValue, long maxValue) {
		Map<String, String> jsonResponse = new HashMap<>();
		if (minValue > maxValue) {
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			jsonResponse.put(ApplicationConstants.DESCRIPTION,
					"Error: minValue must be less than or equal to maxValue");
		} else
			jsonResponse.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		return jsonResponse;
	}

	// A function to check whether multiples of the number 'multipleOf' exists
	// in the range [minValue,maxValue]
	public static boolean multiplesExist(long minValue, long maxValue, long multipleOf) {
		// Assumes minValue < maxValue
		if (minValue % multipleOf == 0 || maxValue % multipleOf == 0)
			return true;
		double lowerLimit = minValue / (multipleOf * 1.0);
		double upperLimit = maxValue / (multipleOf * 1.0);
		boolean result = (upperLimit - lowerLimit) >= 1.0;
		// System.out.println("Lower limit is: " + lowerLimit + " Upper limit
		// is: " + upperLimit + " Result: " + result);
		return result;
	}

	// This function returns the number of multiples of 'multipleOf' present in the range [minValue,maxValue]
	public static long getMultiplesCount(long minValue, long maxValue, long multipleOf) {
		// Assumes minValue < maxValue
		double lowerLimit = minValue / (multipleOf * 1.0);
		double upperLimit = maxValue / (multipleOf * 1.0);
		long result = (long) (upperLimit - lowerLimit);
		boolean minValueIsAMultiple = (minValue % multipleOf == 0);
		boolean maxValueIsAMultiple = (maxValue % multipleOf == 0);
		if (minValueIsAMultiple || maxValueIsAMultiple)
			result++;
		return result;
	}

	// This function generates a random binary search tree (balanced and unbalanced)
	public static int[] generateRandomBinarySearchTree(int nodes, boolean isBalanced) {
		
		// Access the random number generator
		RandomNumberGeneratorInterface generator = new RandomNumberGeneratorImpl();
		
		BSTNode root = null;
		
		// This Set is used to keep track of nodes generated (In order to make sure there are no duplicate nodes)
		Set<Integer> set = new HashSet<>();
		
		// Generate random nodes and start inserting
		for (int i = 0; i < nodes; ++i) {
			int data;
			do {
				data = (int) generator.getRandomNumber(0, nodes - 1);
			} while (set.contains(data));
			set.add(data);
			// Insert appropriately based on whether the tree is balanced/unbalanced
			if (!isBalanced)
				root = insertIntoBST(root, data);
			else
				root = balancedInsertIntoBST(root, data);
		}
		
		// The BST which we generate should be converted into an array
		
		// Calculate the array size
		int maxArraySizeInWorstCase = (int) Math.pow(2, nodes);
		int exponent = (int) Math.floor(Math.log10(nodes * 1.0) / Math.log10(2.0)) + 1;
		int maxArraySizeInWorstCaseIfBalanced = (int) Math.pow(2, exponent) - 1;
		
		int[] arrayForm;
		
		// If the tree is unbalanced, then in the worst case there can be
		// 'maxArraySizeInWorstCase' nodes possible
		// Else, if the tree is balanced then number of nodes are
		// 'maxArraySizeInWorstCaseIfBalanced'
		if (!isBalanced)
			arrayForm = new int[maxArraySizeInWorstCase];
		else
			arrayForm = new int[maxArraySizeInWorstCaseIfBalanced];
		
		// Fill the array with empty bst nodes
		Arrays.fill(arrayForm, ApplicationConstants.BST_NODE_EMPTY);
		
		// convert the BST into an array and return
		return BSTNode.toArray(root, 0, arrayForm);
	}

	// This method is used for debugging purposes (to traverse the tree in inorder fashion)
	@SuppressWarnings("unused")
	private static void inorderTraversal(BSTNode root) {
		if (root != null) {
			inorderTraversal(root.getLeftNode());
			System.out.println("Inorder: " + root.getData() + " Balance: " + root.getBalance());
			inorderTraversal(root.getRightNode());
		}
	}

	// This function inserts the data into the balanced tree pointed to by 'root'
	private static BSTNode balancedInsertIntoBST(BSTNode root, int data) {
		if (root == null)
			return new BSTNode(data);
		if (data < root.getData()) {
			BSTNode leftNode = root.getLeftNode();
			leftNode = balancedInsertIntoBST(leftNode, data);
			root.setLeftNode(leftNode);
		} else {
			BSTNode rightNode = root.getRightNode();
			rightNode = balancedInsertIntoBST(rightNode, data);
			root.setRightNode(rightNode);
		}

		// After inserting the new node, update the balance
		root.updateBalance();

		// If the balance property of the AVL tree is violated, rotate
		// appropriately as follows
		int balance = root.getBalance();
		if (balance == 2) {

			BSTNode rootLeft = root.getLeftNode();
			if (root.getLeftNode().getRightNode() != null) {
				// LR case
				BSTNode rootLeftRight = rootLeft.getRightNode();
				rootLeft.setRightNode(rootLeftRight.getLeftNode());
				root.setLeftNode(rootLeftRight.getRightNode());
				rootLeftRight.setLeftNode(rootLeft);
				rootLeftRight.setRightNode(root);
				rootLeft.updateBalance();
				root.updateBalance();
				rootLeftRight.updateBalance();
				root = rootLeftRight;
			} else if (root.getLeftNode().getLeftNode() != null) {
				// RR case
				root.setLeftNode(rootLeft.getRightNode());
				rootLeft.setRightNode(root);
				root.updateBalance();
				rootLeft.updateBalance();
				root = rootLeft;
			}

		} else if (balance == -2) {

			BSTNode rootRight = root.getRightNode();
			if (root.getRightNode().getLeftNode() != null) {
				// RL case
				BSTNode rootRightLeft = rootRight.getLeftNode();
				rootRight.setLeftNode(rootRightLeft.getRightNode());
				root.setRightNode(rootRightLeft.getLeftNode());
				rootRightLeft.setRightNode(rootRight);
				rootRightLeft.setLeftNode(root);
				rootRight.updateBalance();
				root.updateBalance();
				rootRightLeft.updateBalance();
				root = rootRightLeft;
			} else if (root.getRightNode().getRightNode() != null) {
				// LL case
				root.setRightNode(rootRight.getLeftNode());
				rootRight.setLeftNode(root);
				root.updateBalance();
				rootRight.updateBalance();
				root = rootRight;
			}

		}

		return root;
	}

	// This function inserts the data into the tree pointed to by 'root'
	private static BSTNode insertIntoBST(BSTNode root, int data) {
		if (root == null)
			return new BSTNode(data);
		if (data < root.getData()) {
			BSTNode leftNode = root.getLeftNode();
			leftNode = insertIntoBST(leftNode, data);
			root.setLeftNode(leftNode);
		} else {
			BSTNode rightNode = root.getRightNode();
			rightNode = insertIntoBST(rightNode, data);
			root.setRightNode(rightNode);
		}
		return root;
	}

	public static String mixedCase(String input) {
		StringBuilder result = new StringBuilder(input);
		int index = 0;
		for (char character : input.toCharArray()) {
			if (Character.isLetter(character)) {
				if (ThreadLocalRandom.current().nextBoolean()) {
					if (Character.isLowerCase(character))
						character = Character.toUpperCase(character);
					else
						character = Character.toLowerCase(character);
				}
			}
			result.setCharAt(index, character);
			index++;
		}

		return result.toString();
	}

	public static <T>List<List<T>> listToMultipleLists( final List<T> list, final int iParts )
	{
	    final List<List<T>> lsParts = new ArrayList<List<T>>();
	    final int iChunkSize = list.size() / iParts;
	    int iLeftOver = list.size() % iParts;
	    int iTake = iChunkSize;

	    for( int i = 0, iT = list.size(); i < iT; i += iTake )
	    {
	        if( iLeftOver > 0 )
	        {
	            iLeftOver--;

	            iTake = iChunkSize + 1;
	        }
	        else
	        {
	            iTake = iChunkSize;
	        }

	        lsParts.add( new ArrayList<T>( list.subList( i, Math.min( iT, i + iTake ) ) ) );
	    }

	    return lsParts;
	}

}
