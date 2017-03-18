package com.jntu.random;

// This is an interface which our application uses to generate Random numbers
// Our application is coded-for-interface (not for implementation)
public interface RandomNumberGenerator {

	// This method is used to generate Random number within the range
	// [lower,upper]
	long getRandomNumber(long lower, long upper);

}
