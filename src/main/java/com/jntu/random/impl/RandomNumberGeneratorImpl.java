package com.jntu.random.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jntu.constants.ApplicationConstants;
import com.jntu.controller.ArrayController;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.util.Utility;

// This class currently uses the library methods to generate random number
// It will be replaced by our own version of randomNumberGenerator later
@Component
public class RandomNumberGeneratorImpl implements RandomNumberGeneratorInterface {
	
	private static Logger log = Logger.getLogger(ArrayController.class.getName());

	@Override
	public long getRandomNumber(long lower, long upper) {
		long randomNum = ThreadLocalRandom.current().nextLong(lower, upper + 1);
		return randomNum;
	}

	@Override
	public String[] getArrayOfNumbers(int size, long minValue, long maxValue, boolean isDistinct, boolean isPrime,
			long multipleOf, String sorted) {
		// assumed that all the validations are done at service layers
		String[] output = new String[size];
		if (multipleOf == ApplicationConstants.NOT_PRESENT && !isPrime && !isDistinct)
			output = getArrayOfAnyRandomNumbers(size, minValue, maxValue);
		else if (multipleOf == ApplicationConstants.NOT_PRESENT && !isPrime && isDistinct)
			output = getArrayOfDistinctNumbers(size, minValue, maxValue);
		else if (isPrime && !isDistinct)
			output = getArrayOfPrimes(size, minValue, maxValue);
		else if (isPrime && isDistinct)
			output = getArrayOfDistinctPrimeNumbers(size, minValue, maxValue);
		else if (multipleOf != ApplicationConstants.NOT_PRESENT && !isDistinct)
			output = getMultiplesOfNumber(size, minValue, maxValue, multipleOf);
		else if (multipleOf != ApplicationConstants.NOT_PRESENT && isDistinct)
			output = getDistinctMultiplesOfNumber(size, minValue, maxValue, multipleOf);
		if (sorted == ApplicationConstants.SORTING_ASCENDING){
			Arrays.sort(output);
			log.debug("Ascending Sorting");
		}
		else if (sorted == ApplicationConstants.SORTING_DESCENDING) {
			Arrays.sort(output);
			Collections.reverse(Arrays.asList(output));
			log.debug("Descending Sorting");
		}
		return output;
	}

	@Override
	public String[] getArrayOfPrimes(int size, long minValue, long maxValue ) {
		String[] output = new String[size];
		ArrayList<Long> primeArray = Utility.generatePrimeNumbersWithinRange(minValue, maxValue);
		long lower = 0, index;
		long upper = primeArray.size() - 1;
		for (int i = 0; i < size; i++) {
			index = getRandomNumber(lower, upper);
			output[i] = primeArray.get((int) index) + "";
		}
		return output;
	}

	@Override
	public String[] getArrayOfDistinctPrimeNumbers(int size, long minValue, long maxValue ) {
		String[] output = new String[size];
		ArrayList<Long> primeArray = Utility.generatePrimeNumbersWithinRange(minValue, maxValue);
		while (primeArray.size() > size) {
			primeArray.remove(getRandomNumber(0, primeArray.size() - 1));
		}
		Collections.shuffle(primeArray);
		for (int i = 0; i < size; i++)
			output[i] = primeArray.get(i) + "";
		return output;
	}

	@Override
	public String[] getArrayOfDistinctNumbers(int size, long minValue, long maxValue ) {
		List<String> output = null;
		if ((maxValue - minValue) <= ApplicationConstants.MAX_ARRAY_SIZE) {
			output = new ArrayList<String>((int) (maxValue - minValue + 1));
			for (long i = minValue; i <= maxValue; i++)
				output.add(i + "");
			Collections.shuffle(output);
			output = output.subList(0, size);
		} else {
			Set<String> set = new HashSet<>();
			String randomString;
			for (int i = 0; i < size; i++) {
				randomString = getRandomNumber(minValue, maxValue) + "";
				if (set.contains(randomString)) {
					i--;
					continue;
				} else
					set.add(randomString);
			}
			output = new ArrayList<String>(set);
		}
		return output.toArray(new String[output.size()]);
	}

	@Override
	public String[] getMultiplesOfNumber(int size, long minValue, long maxValue, long multipleOf ) {
		String[] output = new String[size];

		for (int i = 0; i < size; i++){
			output[i] = this.getRandomNumber((long) Math.ceil(minValue / multipleOf),
					(long) Math.floor(maxValue / multipleOf)) * multipleOf + "";
		}
		return output;
	}

	@Override
	public String[] getDistinctMultiplesOfNumber(int size, long minValue, long maxValue, long multipleOf) {
		List<String> output = null;
		long y = (long) Math.ceil(minValue / multipleOf);
		long z = (long) Math.floor(maxValue / multipleOf);
		long x = z - y;
		if (x <= ApplicationConstants.MAX_ARRAY_SIZE) {
			output = new ArrayList<String>((int) (x + 1));
			for (long i = y; i <= z; i++)
				output.add(i * multipleOf + "");
			Collections.shuffle(output);
			output = output.subList(0, size);
		} else {
			Set<String> set = new HashSet<>();
			String randomString;
			for (int i = 0; i < size; i++) {
				randomString = getRandomNumber(y, z) * multipleOf + "";
				if (set.contains(randomString)) {
					i--;
					continue;
				} else
					set.add(randomString);
			}
			output = new ArrayList<String>(set);
		}
		return output.toArray(new String[output.size()]);
	}

	@Override
	public String[] getArrayOfAnyRandomNumbers(int size, long minValue, long maxValue ) {
		String[] output = new String[size];
		for (int i = 0; i < size; i++)
			output[i] = this.getRandomNumber(minValue, maxValue) + "";
		return output;
	}

}
