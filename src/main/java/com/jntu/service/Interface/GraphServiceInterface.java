package com.jntu.service.Interface;

import java.util.Map;

// This is the service which we use for handling the business logic pertaining to "Graphs" category
public interface GraphServiceInterface {

	/*
	 * The controller calls this method to determine the sub-category. Each
	 * sub-category are separate functions which will be called depending
	 * upon the selected category by the user
	 */
	Map<String, String> getResponse(Map<String, Object> requestParams);

	/*
	 * This method is used to process basic-graph sub-category
	 */
	Map<String, String> processBasicGraphRequest(Map<String, Object> requestParams);
	
	/*
	 * This method is used to process n-partite-graph sub-category
	 */
	Map<String, String> processNPartiteGraphRequest(Map<String, Object> requestParams);
	
	/*
	 * This method is used to process complete-graph sub-category
	 */
	Map<String, String> processCompleteGraphRequest(Map<String, Object> requestParams);
	
}
