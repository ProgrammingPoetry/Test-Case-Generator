package com.jntu.random;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

// This class currently uses the library methods to generate random number
// It will be replaced by our own version of randomNumberGenerator later
@Component
public class NaiveRandomImpl implements RandomNumberGenerator {

	@Override
	public long getRandomNumber(long lower, long upper) {
		long randomNum = ThreadLocalRandom.current().nextLong(lower, upper + 1);
		return randomNum;
	}	
	
}
