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

	// Constants which denote the sub-categories in our application (Such as:
	// Numbers, Characters etc)
	public static final String NUMBERS = "numbers";
	public static final String CHARACTERS = "characters";
	public static final String STRINGS = "strings";

	// Other constants
	public static final long NOT_PRESENT = -1L;
}
