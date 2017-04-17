package com.jntu.random.interfaces;

public interface RandomStringGeneratorInterface {

	String[] getArrayOfStrings(long size, char minChar, char maxChar, long minSize, long maxSize,
			boolean specialCharactersAllowed, String stringCase, boolean isPalindrome, boolean printLength,
			String individuallySorted, String sorted, String seperatedBy);

	String[] getArrayOfPalindromes(long size, char minChar, char maxChar, long minSize,long maxSize,
			boolean specialCharactersAllowed, boolean printLength, String individuallySorted, String seperatedBy);

	String[] getArrayOfAnyStrings(long size, char minChar, char maxChar, long minSize,long maxSize, boolean specialCharactersAllowed,
			boolean printLength, String individuallySorted, String seperatedBy);
}
