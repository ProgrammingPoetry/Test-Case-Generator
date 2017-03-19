package com.jntu.random.interfaces;

public interface RandomStringGeneratorInterface {

	String getArrayOfStrings(long size, char minChar, char maxChar, boolean specialCharactersAllowed, String stringCase,
			boolean isPalindrome, boolean printLength, String individuallySorted, String sorted, String seperatedBy);

}
