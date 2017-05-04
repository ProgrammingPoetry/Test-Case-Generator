package com.jntu.service.Interface;

import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;

// This is the service which we use for handling the business logic pertaining to "Arrays" category
public interface ArrayServiceInterface {

	Object getFileContent(ArrayOfNumbers input);

	Object getFileContent(ArrayOfCharacters input);

	Object getFileContent(ArrayOfStrings input);

}
