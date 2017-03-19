package com.jntu.service.Interface;

import java.util.Map;

public interface ArrayServiceInterface {

	Map<String, String> getResponse(Map<String, Object> requestParams);

	Map<String, String> processArrayOfNumbersRequest(Map<String, Object> requestParams);

	Map<String, String> processArrayOfCharactersRequest(Map<String, Object> requestParams);

	Map<String, String> processArrayOfStringsRequest(Map<String, Object> requestParams);

}
