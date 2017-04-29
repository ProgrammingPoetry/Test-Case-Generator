package com.jntu.service.Interface;

import java.util.Map;

import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;

public interface ArrayServiceInterface {

	Map<String, String> processArrayOfCharactersRequest(Map<String, Object> requestParams);

	Map<String, String> processArrayOfStringsRequest(Map<String, Object> requestParams);

	Object getFileContent(ArrayOfNumbers input);

	Object getFileContent(ArrayOfCharacters input);

	Object getFileContent(ArrayOfStrings input);

}
