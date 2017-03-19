package com.jntu.random.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.jntu.random.interfaces.RandomNumberGeneratorInterface;

// This class currently uses the library methods to generate random number
// It will be replaced by our own version of randomNumberGenerator later
@Component
public class RandomNumberGeneratorImpl implements RandomNumberGeneratorInterface {

	@Override
	public long getRandomNumber(long lower, long upper) {
		long randomNum = ThreadLocalRandom.current().nextLong(lower, upper + 1);
		return randomNum;
	}

	@Override
	public long[] getArrayOfNumbers(long size, long minValue, long maxValue, boolean isDistinct, boolean isPrime,
			long multipleOf , String seperatedBy) {
		// TODO Auto-generated method stub
		return null;
	}

}
