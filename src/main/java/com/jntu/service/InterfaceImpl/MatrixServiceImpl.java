package com.jntu.service.InterfaceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.model.MatrixOfCharacters;
import com.jntu.model.MatrixOfNumbers;
import com.jntu.model.PathMatrix;
import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.CharacterSO;
import com.jntu.service.NumberSO;
import com.jntu.service.Interface.MatrixServiceInterface;
import com.jntu.util.Utility;

@Service
public class MatrixServiceImpl implements MatrixServiceInterface {

	@Autowired
	RandomNumberGeneratorInterface randomNumbers;

	@Autowired
	RandomCharacterGeneratorInterface randomCharacters;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getFileContent(MatrixOfNumbers input) {
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			List list = new ArrayList<>();
			list.add(noOfTestCases);
			data.add(list);
		}
		for (int i = 0; i < noOfTestCases; i++) {
			if (input.getPrintNoOfRowsAndColumns()) {
				int[] rowsAndColumns = { input.getRows(), input.getColumns() };
				data.add(rowsAndColumns);
			}
			NumberSO numberSO = new NumberSO();
			numberSO.setArraySize(input.getRows() * input.getColumns());
			numberSO.setMaxValue(input.getMaxValue());
			numberSO.setMinValue(input.getMinValue());
			numberSO.setMultipleOf(input.getMultipleOf());
			numberSO.setSorted("none");
			List list = null;
			if (input.getIsPrime() && input.getIsDistinct()) {
				list = randomNumbers.getArrayOfDistinctPrimeNumbers(numberSO);
			} else if (input.getIsPrime()) {
				list = randomNumbers.getArrayOfPrimes(numberSO);
			} else if (input.getIsDistinct()) {
				list = randomNumbers.getArrayOfDistinctNumbers(numberSO);
			} else {
				list = randomNumbers.getArrayOfAnyRandomNumbers(numberSO);
			}
			data.add(Utility.listToMultipleLists(list, input.getRows()));
		}

		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getFileContent(MatrixOfCharacters input) {
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			List list = new ArrayList<>();
			list.add(noOfTestCases);
			data.add(list);
		}
		for (int i = 0; i < noOfTestCases; i++) {
			if (input.getPrintNoOfRowsAndColumns()) {
				int[] rowsAndColumns = { input.getRows(), input.getColumns() };
				data.add(rowsAndColumns);
			}
			CharacterSO characterSO = new CharacterSO();
			characterSO.setArraySize(input.getRows() * input.getColumns());
			String refString = "";
			for (char c = input.getMinValue(); c <= input.getMaxValue(); c++) {
				refString += c;
				if ("mixed".equals(input.getCharCase())) {
					if (Character.isLowerCase(c)) {
						refString += Character.toUpperCase(c);
					} else {
						refString += Character.toLowerCase(c);
					}
				}
			}
			if ("upper".equals(input.getCharCase())) {
				refString = refString.toUpperCase();
			} else if ("lower".equals(input.getCharCase())) {
				refString = refString.toLowerCase();
			}
			characterSO.setRefString(refString);
			characterSO.setDistinct(input.getIsDistinct());
			List<Character> list = randomCharacters.getArrayOfCharacters(characterSO);
			data.add(Utility.listToMultipleLists(list, input.getRows()));
		}
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getFileContent(PathMatrix input) {
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			data.add(new ArrayList<>().add(noOfTestCases));
		}
		for (int i = 0; i < noOfTestCases; i++) {
			if (input.getPrintNoOfRowsAndColumns()) {
				int[] rowsAndColumns = { input.getRows(), input.getColumns() };
				data.add(rowsAndColumns);
			}
			// TODO Auto-generated method stub
		}
		return data;
	}

}
