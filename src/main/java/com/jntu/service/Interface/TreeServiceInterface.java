package com.jntu.service.Interface;

import java.util.Map;

//This is the service which we use for handling the business logic pertaining to "Tree" category
public interface TreeServiceInterface {

	/*
	 * The controller calls this method to determine the sub-category. Each
	 * sub-category are separate functions which will be called depending
	 * upon the selected category by the user
	 */
	Map<String, String> getResponse(Map<String, Object> requestParams);

	/*
	 * This method is used to process numeric tree sub-category
	 */
	Map<String, String> processNumericTreeRequest(Map<String, Object> requestParams);

	/*
	 * This method is used to process full-binary-tree sub-category
	 */
	Map<String, String> processFullBinaryTreeRequest(Map<String, Object> requestParams);

	/*
	 * This method is used to process Skew-tree sub-category
	 */
	Map<String, String> processSkewTreeRequest(Map<String, Object> requestParams);

	/*
	 * This method is used to process binary-search-tree sub-category
	 */
	Map<String, String> processBinarySearchTreeRequest(Map<String, Object> requestParams);

}
