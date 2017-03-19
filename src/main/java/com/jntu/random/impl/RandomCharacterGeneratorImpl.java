package com.jntu.random.impl;

import org.springframework.stereotype.Component;

import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;

@Component
public class RandomCharacterGeneratorImpl implements RandomCharacterGeneratorInterface {

	@Override
	public String[] getArrayOfCharacters(long size, char minValue, char maxValue, boolean isDistinct, String charCase,
			boolean specialCharactersAllowed, boolean printSize,String sorted, String seperatedBy) {
		// TODO Auto-generated method stub
		return null;
	}

}
