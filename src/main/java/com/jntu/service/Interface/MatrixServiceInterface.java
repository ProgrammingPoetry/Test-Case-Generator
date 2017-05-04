package com.jntu.service.Interface;

import com.jntu.model.MatrixOfCharacters;
import com.jntu.model.MatrixOfNumbers;
import com.jntu.model.PathMatrix;

// This is the service which we use for handling the business logic pertaining to "Matrix" category
public interface MatrixServiceInterface {

	Object getFileContent(MatrixOfNumbers input);

	Object getFileContent(MatrixOfCharacters input);

	Object getFileContent(PathMatrix input);

}
