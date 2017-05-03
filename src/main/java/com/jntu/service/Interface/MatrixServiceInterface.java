package com.jntu.service.Interface;

import com.jntu.model.MatrixOfCharacters;
import com.jntu.model.MatrixOfNumbers;
import com.jntu.model.PathMatrix;

public interface MatrixServiceInterface {

	Object getFileContent(MatrixOfNumbers input);

	Object getFileContent(MatrixOfCharacters input);

	Object getFileContent(PathMatrix input);

}
