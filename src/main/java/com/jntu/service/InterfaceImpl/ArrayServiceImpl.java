package com.jntu.service.InterfaceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;
import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.random.interfaces.RandomStringGeneratorInterface;
import com.jntu.service.CharacterSO;
import com.jntu.service.NumberSO;
import com.jntu.service.StringSO;
import com.jntu.service.Interface.ArrayServiceInterface;

@Service
public class ArrayServiceImpl implements ArrayServiceInterface {

	@Autowired
	RandomNumberGeneratorInterface randomNumbers;

	@Autowired
	RandomCharacterGeneratorInterface randomCharacters;

	@Autowired
	RandomStringGeneratorInterface randomStrings;

	@Override
	@SuppressWarnings(value = { "unchecked", "rawtypes" })
	public Object getFileContent(ArrayOfNumbers input) {
		// TODO : TYPE RELATED CHECKS
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			List list = new ArrayList<>();
			list.add(noOfTestCases);
			data.add(list);
		}
		boolean printArraySize = input.getPrintArraySize();
		for (int i = 0; i < noOfTestCases; i++) {
			NumberSO numberSO = new NumberSO();
			numberSO.setArraySize((int) randomNumbers.getRandomNumber(input.getMinSize(), input.getMaxSize()));
			if (printArraySize) {
				List list = new ArrayList<>();
				list.add(numberSO.getArraySize());
				data.add(list);
			}
			if (input.getMultipleOf() != 0) {
				numberSO.setMinValue((long) Math.ceil(input.getMinValue() / input.getMultipleOf()));
				numberSO.setMaxValue((long) Math.floor(input.getMaxValue() / input.getMultipleOf()));
			}
			numberSO.setMultipleOf(input.getMultipleOf());
			numberSO.setSorted(input.getSorted());
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
			if ("ascending".equals(numberSO.getSorted())) {
				Collections.sort(list);
			} else if ("descending".equals(numberSO.getSorted())) {
				Collections.sort(list, Collections.reverseOrder());
			}
			data.add(list);
		}
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getFileContent(ArrayOfCharacters input) {
		// TODO : TYPE RELATED CHECKS
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			List list = new ArrayList<>();
			list.add(noOfTestCases);
			data.add(list);
		}
		boolean printArraySize = input.getPrintArraySize();
		for (int i = 0; i < noOfTestCases; i++) {
			CharacterSO characterSO = new CharacterSO();
			characterSO.setArraySize((int) randomNumbers.getRandomNumber(input.getMinSize(), input.getMaxSize()));
			if (printArraySize) {
				List list = new ArrayList<>();
				list.add(characterSO.getArraySize());
				data.add(list);
			}
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
			// TODO : below check can be removed
			if ("upper".equals(input.getCharCase())) {
				refString = refString.toUpperCase();
			} else if ("lower".equals(input.getCharCase())) {
				refString = refString.toLowerCase();
			}
			characterSO.setRefString(refString);
			characterSO.setDistinct(input.getIsDistinct());
			List<Character> list = randomCharacters.getArrayOfCharacters(characterSO);
			if ("ascending".equals(input.getSorted())) {
				Collections.sort(list);
			} else if ("descending".equals(input.getSorted())) {
				Collections.sort(list, Collections.reverseOrder());
			}
			data.add(list);
		}
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getFileContent(ArrayOfStrings input) {
		// TODO : TYPE RELATED CHECKS
		List data = new ArrayList();
		long noOfTestCases = input.getNoOfTestCases();
		if (input.getPrintNoOfTestCases()) {
			List list = new ArrayList<>();
			list.add(noOfTestCases);
			data.add(list);
		}
		boolean printArraySize = input.getPrintArraySize();
		for (int i = 0; i < noOfTestCases; i++) {
			StringSO stringSO = new StringSO();
			stringSO.setArraySize((int) randomNumbers.getRandomNumber(input.getMinSize(), input.getMaxSize()));
			if (printArraySize) {
				List list = new ArrayList<>();
				list.add(stringSO.getArraySize());
				data.add(list);
			}
			String refString = "";
			for (char c = input.getMinCharValue(); c <= input.getMaxCharValue(); c++) {
				refString += c;
				if ("mixed".equals(input.getCharCase())) {
					if (Character.isLowerCase(c)) {
						refString += Character.toUpperCase(c);
					} else {
						refString += Character.toLowerCase(c);
					}
				}
			}
			// TODO : below check can be removed
			if ("upper".equals(input.getCharCase())) {
				refString = refString.toUpperCase();
			} else if ("lower".equals(input.getCharCase())) {
				refString = refString.toLowerCase();
			}
			stringSO.setRefString(refString);
			stringSO.setMinLength(input.getMinLength());
			stringSO.setMaxLength(input.getMaxLength());
			List<String> list = null;
			if (input.getIsPalindrome()) {
				list = randomStrings.getArrayOfPalindromicStrings(stringSO);
			} else {
				list = randomStrings.getArrayOfStrings(stringSO);
			}
			if ("ascending".equals(input.getSorted())) {
				Collections.sort(list);
			} else if ("descending".equals(input.getSorted())) {
				Collections.sort(list, Collections.reverseOrder());
			}
			data.add(list);
		}
		return data;
	}

}
