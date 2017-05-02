package com.jntu.service.Interface;

import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;

public interface ArrayServiceInterface {

	Object getFileContent(ArrayOfNumbers input);

	Object getFileContent(ArrayOfCharacters input);

	Object getFileContent(ArrayOfStrings input);

}
