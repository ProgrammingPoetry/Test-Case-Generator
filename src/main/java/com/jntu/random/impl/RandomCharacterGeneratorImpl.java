package com.jntu.random.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.CharacterSO;

// This class generates random characters
@Component
public class RandomCharacterGeneratorImpl implements RandomCharacterGeneratorInterface {

	@Autowired
	RandomNumberGeneratorInterface randomNumbergenerator;

	@Override
	public List<Character> getArrayOfCharacters(CharacterSO characterSO) {
		List<Character> result = new ArrayList<>();
		if (characterSO.isDistinct()) {
			result = characterSO.getRefString().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
			Collections.shuffle(result);
			result = result.subList(0, characterSO.getArraySize());
			return result;
		}
		for (int i = 0; i < characterSO.getArraySize(); i++) {
			result.add(characterSO.getRefString()
					.charAt(ThreadLocalRandom.current().nextInt(characterSO.getRefString().length())));
		}
		return result;
	}

	@Override
	public char getRandomCharacter(char minChar, char maxChar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getRandomCharacter(String refString) {
		return refString.charAt(ThreadLocalRandom.current().nextInt(refString.length()));
	}

}
