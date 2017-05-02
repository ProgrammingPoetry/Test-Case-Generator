package com.jntu.random.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.random.interfaces.RandomStringGeneratorInterface;
import com.jntu.service.StringSO;

@Component
public class RandomStringGeneratorImpl implements RandomStringGeneratorInterface {

	@Autowired
	RandomCharacterGeneratorInterface randomCharGenerator;

	@Autowired
	RandomNumberGeneratorInterface randomNumberGenerator;

	@Override
	public List<String> getArrayOfStrings(StringSO stringSO) {
		List<String> result = new ArrayList<>();
		int length;
		for (int i = 0; i < stringSO.getArraySize(); i++) {
			length = ThreadLocalRandom.current().nextInt(stringSO.getMinLength(), stringSO.getMaxLength() + 1);
			result.add(this.getRandomString(stringSO.getRefString(), length));
		}
		return result;
	}

	@Override
	public List<String> getArrayOfPalindromicStrings(StringSO stringSO) {
		List<String> result = new ArrayList<>();
		int length;
		StringBuilder arrayData, arrayData1;
		for (int i = 0; i < stringSO.getArraySize(); i++) {
			length = ThreadLocalRandom.current().nextInt(stringSO.getMinLength(), stringSO.getMaxLength() + 1);
			arrayData = new StringBuilder(this.getRandomString(stringSO.getRefString(), length / 2));
			arrayData1 = new StringBuilder(arrayData).reverse();
			if (length % 2 == 1) {
				arrayData.append(randomCharGenerator.getRandomCharacter(stringSO.getRefString())+"");
			}
			arrayData.append(arrayData1);
			result.add(arrayData.toString());
		}
		return result;
	}

	@Override
	public String getRandomString(String refString, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = refString.charAt(ThreadLocalRandom.current().nextInt(refString.length()));
		}
		return new String(text);
	}

}
