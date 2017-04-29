package com.jntu.random.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.jntu.constants.ApplicationConstants;
import org.springframework.stereotype.Component;

import com.jntu.random.interfaces.RandomCharacterGeneratorInterface;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.CharacterSO;

@Component
public class RandomCharacterGeneratorImpl implements RandomCharacterGeneratorInterface {

	@Autowired
	RandomNumberGeneratorInterface randomNumbergenerator;

	@Override
	public String[] getArrayOfCharacters(long size, char minValue, char maxValue, boolean isDistinct, String charCase,
			boolean specialCharactersAllowed, boolean printSize, String sorted, String seperatedBy) {
		String[] output = new String[(int) size];
		int low = (int) minValue - (int) 'a';
		int up = (int) maxValue - (int) 'a';
		if (isDistinct == true) {
			// output=randomNumbergenerator.getArrayOfDistinctNumbers((int)size,
			// low, up);

		} else {
			// output=randomNumbergenerator.getArrayOfAnyRandomNumbers((int)size,
			// low, up);
		}
		output = this.getCharArrayFromIntArray(output, charCase);
		return output;
	}

	@Override
	public String[] getCharArrayFromIntArray(String[] input, String charCase) {

		for (int i = 0; i < input.length; i++) {
			input[i] = ApplicationConstants.LOWER_CASE_CHARACTER_LITERALS[Integer.parseInt(input[i])] + "";
			if (charCase.equals(ApplicationConstants.UPPER_CASE))
				input[i] = input[i].toUpperCase();
		}
		return input;
	}

	@Override
	public char getRandomCharacter(char minChar, char maxChar) {
		// TODO validate minchar and maxchar range
		return 0;
	}

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

}
