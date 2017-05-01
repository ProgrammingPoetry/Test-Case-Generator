package com.jntu.constants;

// All constant-strings which will be used in our application should be documented here
// It's a bad-practise to use hardcoded strings in application.
// Whenever you want to use a string, add a variable here and then use that
// Place the variables in this class in appropriate comment-section
// Note: You can this class as a store of constant variables (these variables need not be strings)

public class ApplicationConstants {

	// Constants related to JSON response
	public static final String STATUS = "status";
	public static final String DESCRIPTION = "description";
	public static final String TIME_TAKEN = "timeTaken";
	public static final String TEST_DATA = "testData";
	public static final String SUCCESS_STATUS = "Success";
	public static final String FAILURE_STATUS = "Failure";
	public static final String SUCCESS_DESC = "Successfully completed the operation";

	// Constants related to JSON request
	public static final String CATEGORY = "category";
	public static final String TEST_CASES = "testCases";
	public static final String MIN_VALUE = "minValue";
	public static final String MAX_VALUE = "maxValue";
	public static final String MULTIPLE_OF = "multipleOf";
	public static final String IS_PRIME = "prime";
	public static final String IS_DISTINCT = "distinct";
	public static final String MIN_SIZE = "minSize";
	public static final String MAX_SIZE = "maxSize";
	public static final String CHARACTER_CASE = "case";
	public static final String UPPER_CASE = "upper";
	public static final String LOWER_CASE = "lower";
	public static final String MIXED_CASE = "mixed";
	public static final String PRINT_SIZE = "printSize";
	public static final String SPECIAL_CHARACTERS_ALLOWED ="specialCharactersAllowed";
	public static final String SORTED = "sorted";
	public static final String INDIVIDUALLY_SORTED = "individuallySorted";
	public static final String MIN_CHAR_VALUE = "minCharValue";
	public static final String MAX_CHAR_VALUE = "maxCharValue";
	public static final String PRINT_LENGTH ="printLength";
	public static final String IS_PALINDROME = "isPalindrome";
	public static final String MIN_STRING_LENGTH = "minStringLength";
	public static final String MAX_STRING_LENGTH = "maxStringLength";
	public static final String PRINT_STRING_LENGTH = "printStringLength";
	public static final String WHITE_SPACE_CHARACTER = "whiteSpaceCharacter";
	public static final String NEW_LINE_CHARACTER = "newLine";
	public static final String SPACE_CHARACTER = "space";
	public static final String SORTING_ASCENDING = "sortingAscending";
	public static final String SORTING_DESCENDING = "sortingDescending";
	public static final String SORTING_NONE = "sortingNone";
	public static final String IS_SORTED = "sorted";
	public static final String NODES = "nodes";
	public static final String IS_WEIGHTED = "weighted";
	public static final String INDEXED_FROM = "indexedFrom";
	public static final String MIN_WEIGHT = "minWeight";
	public static final String MAX_WEIGHT = "maxWeight";
	public static final String DISTINCT_WEIGHT = "distinctWeight";
	public static final String DISTINCT_VALUE = "distinctValue";
	public static final String IS_BALANCED = "isBalanced";
	public static final String NUMBER_OF_LEVELS = "numberOfLevels";
	
	// Constants which denote the sub-categories in our application (Such as:
	// Numbers, Characters etc)
	public static final String NUMBERS = "numbers";
	public static final String CHARACTERS = "characters";
	public static final String STRINGS = "strings";
	public static final String NUMERIC_TREE = "numericTree";
	public static final String FULL_BINARY_TREE = "fullBinaryTree";
	public static final String SKEW_TREE = "skewTree";
	public static final String BINARY_SEARCH_TREE = "binarySearchTree";	
	public static final String FIBONACCI_SERIES = "fibonacci";

	// Other constants are below (which do not fall into any specific category)

	/*
	 * The below variable serves as an Indicator (as a flag variable) for
	 * multipleOf request Parameter.
	 */
	public static final long NOT_PRESENT = -1L;

	/*
	 * The below 2 character arrays hold the list of characters in English
	 * alphabet. Other functions generate a random index, and that index is used
	 * select appropriate character from the below arrays
	 */
	public static final char[] LOWER_CASE_CHARACTER_LITERALS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static final char[] UPPER_CASE_CHARACTER_LITERALS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	public static final  int MAX_ARRAY_SIZE = 1000000;
	
	public static final int BST_NODE_EMPTY = -1;
	
}
