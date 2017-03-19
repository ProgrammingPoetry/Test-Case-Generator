package com.jntu.random.interfaces;

// This is an interface which our application uses to generate Random numbers
// Our application is coded-for-interface (not for implementation)
public interface RandomNumberGeneratorInterface {

	// This method is used to generate Random number within the range
	// [lower,upper]
	long getRandomNumber(long lower, long upper);

	long[] getArrayOfNumbers(long size, long minValue, long maxValue, boolean isDistinct, boolean isPrime,
			long multipleOf , String seperatedBy);


}
