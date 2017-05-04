package com.jntu.random.interfaces;

import java.util.List;

import com.jntu.service.StringSO;

// An interface to generate random strings
public interface RandomStringGeneratorInterface {
	
	String getRandomString(String refString,int length);

	List<String> getArrayOfStrings(StringSO stringSO);

	List<String> getArrayOfPalindromicStrings(StringSO stringSO);
}
