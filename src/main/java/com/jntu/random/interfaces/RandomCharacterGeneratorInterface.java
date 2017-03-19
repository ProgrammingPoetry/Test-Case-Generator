package com.jntu.random.interfaces;

public interface RandomCharacterGeneratorInterface {

	char[] getArrayOfCharacters(long size, char minValue, char maxValue, boolean isDistinct, String charCase,
			boolean specialCharactersAllowed, boolean printSize,String sorted, String seperatedBy);
}
