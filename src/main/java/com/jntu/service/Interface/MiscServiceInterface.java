package com.jntu.service.Interface;

import java.util.Map;

// This is the service which we use for handling the business logic pertaining to "Miscellaneous" category
public interface MiscServiceInterface {

	/*
	 * The controller calls this method to determine the sub-category. Each
	 * sub-category are separate functions which will be called depending
	 * upon the selected category by the user
	 */
	Map<String, String> getResponse(Map<String, Object> requestParams);
	
	/*
	 * This method is used to process fibonacci sub-category
	 */
	Map<String, String> processFibonacciRequest(Map<String, Object> requestParams);

}
