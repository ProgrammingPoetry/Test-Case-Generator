package com.jntu.random.interfaces;

public interface RandomCharacterGeneratorInterface {

	String[] getArrayOfCharacters(long size, char minValue, char maxValue, boolean isDistinct, String charCase,
			boolean specialCharactersAllowed, boolean printSize,String sorted, String seperatedBy);
	
	String[] getCharArrayFromIntArray(String[] input,String charCase);
}
