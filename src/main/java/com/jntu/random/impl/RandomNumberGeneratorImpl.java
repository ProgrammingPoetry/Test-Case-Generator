package com.jntu.random.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.jntu.constants.ApplicationConstants;
import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.NumberSO;
import com.jntu.util.Utility;

// This class currently uses the library methods to generate random number
// It will be replaced by our own version of randomNumberGenerator later
//TODO : REVISE ALL TYPE RELATED FIXES AND MAKE IT MORE GENERIC
@Component
public class RandomNumberGeneratorImpl implements RandomNumberGeneratorInterface {

	@Override
	public long getRandomNumber(long lower, long upper) {
		long randomNum = ThreadLocalRandom.current().nextLong(lower, upper + 1);
		return randomNum;
	}

	@Override
	public <T> List<? extends Number> getArrayOfDistinctPrimeNumbers(NumberSO<T> numberSO) {
		List<Long> result = Utility.generatePrimeNumbersWithinRange((Long) numberSO.getMinValue(),
				(Long) numberSO.getMaxValue());
		Collections.shuffle(result);
		result = result.subList(0, numberSO.getArraySize());
		return result;
	}

	@Override
	public <T> List<? extends Number> getArrayOfPrimes(NumberSO<T> numberSO) {
		//TODO : OPTIMIZATIONS
		List<Long> primeArray = Utility.generatePrimeNumbersWithinRange((Long) numberSO.getMinValue(),
				(Long) numberSO.getMaxValue());
		ArrayList<Long> result = new ArrayList<>();
		long lower = 0, index;
		long upper = primeArray.size() - 1;
		for (int i = 0; i < numberSO.getArraySize(); i++) {
			index = this.getRandomNumber(lower, upper);
			result.add(primeArray.get((int) index));
		}
		return result;
	}

	@Override
	public <T> List<? extends Number> getArrayOfDistinctNumbers(NumberSO<T> numberSO) {
		//TODO : OPTIMIZATIONS
		int size = numberSO.getArraySize();
		List<Long> result = null;
		long minValue = (Long) numberSO.getMinValue();
		long maxValue = (Long) numberSO.getMaxValue();
		if ((maxValue - minValue) <= ApplicationConstants.MAX_ARRAY_SIZE) {
			result = new ArrayList<Long>((int) (maxValue - minValue + 1));
			for (long i = minValue; i <= maxValue; i++)
				result.add(i);
			Collections.shuffle(result);
			result = result.subList(0, size);
		} else {
			result = new ArrayList<>(size);
			long randomNumber;
			for (int i = 0; i < size; i++) {
				randomNumber = this.getRandomNumber(minValue, maxValue);
				if (result.contains(randomNumber)) {
					i--;
					continue;
				} else {
					result.add(randomNumber);
				}
			}
		}
		return result;
	}

	@Override
	public <T> List<? extends Number> getArrayOfAnyRandomNumbers(NumberSO<T> numberSO) {
		int size = numberSO.getArraySize();
		List<Long> result = new ArrayList<Long>(size);
		long randomNumber;
		long multipleOf = (Long) numberSO.getMultipleOf();
		for (int i = 0; i < size; i++) {
			randomNumber = this.getRandomNumber((Long) numberSO.getMinValue(), (Long) numberSO.getMaxValue());
			result.add(randomNumber * multipleOf);
		}
		return result;
	}

}
