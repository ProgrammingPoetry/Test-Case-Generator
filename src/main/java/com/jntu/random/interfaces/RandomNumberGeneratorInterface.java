package com.jntu.random.interfaces;

import java.util.List;

import com.jntu.service.NumberSO;

// This is an interface which our application uses to generate Random numbers
// Our application is coded-for-interface (not for implementation)
public interface RandomNumberGeneratorInterface {

	// This method is used to generate Random number within the range
	// [lower,upper]
	long getRandomNumber(long lower, long upper);

	<T> List<? extends Number> getArrayOfDistinctPrimeNumbers(NumberSO<T> numberSO);

	<T> List<? extends Number> getArrayOfPrimes(NumberSO<T> numberSO);

	<T> List<? extends Number> getArrayOfDistinctNumbers(NumberSO<T> numberSO);

	<T> List<? extends Number> getArrayOfAnyRandomNumbers(NumberSO<T> numberSO);
}
