package com.jntu.random.interfaces;

import java.util.List;

import com.jntu.service.StringSO;

public interface RandomStringGeneratorInterface {
	
	String getRandomString(String refString,int length);

	List<String> getArrayOfStrings(StringSO stringSO);

	List<String> getArrayOfPalindromicStrings(StringSO stringSO);
}
