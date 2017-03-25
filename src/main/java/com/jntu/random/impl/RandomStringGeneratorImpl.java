package com.jntu.random.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.random.interfaces.RandomStringGeneratorInterface;

@Component
public class RandomStringGeneratorImpl implements RandomStringGeneratorInterface {

	//TODO a lot of fixes , optimization ,isDistinct and whitespace issues
	@Autowired
	RandomCharacterGeneratorInterface randomCharGenerator;

	@Autowired
	RandomNumberGeneratorInterface randomNumberGenerator;

	@Override
	public String[] getArrayOfStrings(long size, char minChar, char maxChar, long minSize, long maxSize,
			boolean specialCharactersAllowed, String stringCase, boolean isPalindrome, boolean printLength,
			String individuallySorted, String sorted, String seperatedBy) {
		String[] output = new String[(int) size];
		if (isPalindrome == true) {
			output = getArrayOfPalindromes(size, minChar, maxChar, minSize, maxSize, specialCharactersAllowed,
					printLength, individuallySorted, seperatedBy);
		} else {
			output = getArrayOfAnyStrings(size, minChar, maxChar, minSize, maxSize, specialCharactersAllowed,
					printLength, individuallySorted, seperatedBy);
		}
		return output;
	}

	@Override
	public String[] getArrayOfAnyStrings(long size, char minChar, char maxChar, long minSize, long maxSize,
			boolean specialCharactersAllowed, boolean printLength, String individuallySorted, String seperatedBy) {
		String[] output = new String[(int) size];
		int stringSize;

		for (int i = 0; i < size; i++) {
			stringSize = (int) randomNumberGenerator.getRandomNumber(minSize, maxSize);
			output[i] = Arrays
					.toString(randomCharGenerator.getArrayOfCharacters(stringSize, minChar, maxChar, false,
							ApplicationConstants.LOWER_CASE, specialCharactersAllowed, false, individuallySorted, ""))
					.replaceAll(",", "").replace("[", "").replace("]", "").replace(" ","");
		}
		
		return output;
	}

	@Override
	public String[] getArrayOfPalindromes(long size, char minChar, char maxChar, long minSize, long maxSize,
			boolean specialCharactersAllowed, boolean printLength, String individuallySorted, String seperatedBy) {
		String[] output = new String[(int) size];
		int stringSize;
		int low = (int)minChar -(int)'a';
		int up = (int)maxChar - (int)'a';
		for (int i = 0; i < size; i++) {
			stringSize = (int) randomNumberGenerator.getRandomNumber(minSize, maxSize);
			String temp=Arrays
					.toString(randomCharGenerator.getArrayOfCharacters(stringSize/2, minChar, maxChar, false,
							ApplicationConstants.LOWER_CASE, specialCharactersAllowed, false, individuallySorted, ""))
					.replaceAll(",", "").replace("[", "").replace("]", "").replaceAll(" ","");
			StringBuilder temp_ =new StringBuilder(temp);
			int x=(int) randomNumberGenerator.getRandomNumber(0,1);
			String middle="";
			if(x==1){
				middle+=(char)(minChar+randomNumberGenerator.getRandomNumber((long)low,(long)up))+"";
			}
			output[i] = temp+middle+temp_.reverse() +seperatedBy;
		}
		return output;
	}

}
