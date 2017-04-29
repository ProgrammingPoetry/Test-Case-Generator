package com.jntu.random.interfaces;

import java.util.List;

import com.jntu.service.CharacterSO;

public interface RandomCharacterGeneratorInterface {

	String[] getArrayOfCharacters(long size, char minValue, char maxValue, boolean isDistinct, String charCase,
			boolean specialCharactersAllowed, boolean printSize,String sorted, String seperatedBy);
	
	String[] getCharArrayFromIntArray(String[] input,String charCase);
	
	char getRandomCharacter(char minChar,char maxChar);
	
	List<Character> getArrayOfCharacters(CharacterSO characterSO);
}
