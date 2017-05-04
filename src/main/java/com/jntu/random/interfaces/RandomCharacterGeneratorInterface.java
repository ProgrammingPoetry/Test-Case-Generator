package com.jntu.random.interfaces;

import java.util.List;

import com.jntu.service.CharacterSO;

// An interface for generating random characters
public interface RandomCharacterGeneratorInterface {
	
	char getRandomCharacter(char minChar,char maxChar);
	
	char getRandomCharacter(String refString);
	
	List<Character> getArrayOfCharacters(CharacterSO characterSO);
}
