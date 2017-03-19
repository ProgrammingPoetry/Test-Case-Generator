package com.jntu.service.Interface;

import java.util.Map;

//This is the service which we use for handling the business logic pertaining to "Basic-Data-Type" category
public interface BasicDataTypeServiceInterface {

	/*
	 * The controller calls this method to determine the sub-category. Each
	 * sub-category (numbers,characters and strings) are separate functions
	 * which will be called depending upon the selected category by the user
	 */
	Map<String, String> getResponse(Map<String, Object> requestParams);

	/*
	 * This method is used to process numbers sub-category
	 */
	Map<String, String> processNumberRequest(Map<String, Object> requestParams);
	
	/*
	 * This method is used to process characters sub-category
	 */
	Map<String, String> processCharacterRequest(Map<String, Object> requestParams);
	
	/*
	 * This method is used to process strings sub-category
	 */
	Map<String, String> processStringRequest(Map<String, Object> requestParams);

}