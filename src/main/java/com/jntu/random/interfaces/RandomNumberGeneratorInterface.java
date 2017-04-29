package com.jntu.random.interfaces;

import java.util.ArrayList;

import com.jntu.service.NumberSO;

// This is an interface which our application uses to generate Random numbers
// Our application is coded-for-interface (not for implementation)
public interface RandomNumberGeneratorInterface {

	// This method is used to generate Random number within the range
	// [lower,upper]
	long getRandomNumber(long lower, long upper);

	String[] getArrayOfNumbers(int size, long minValue, long maxValue, boolean isDistinct, boolean isPrime,
			long multipleOf, String sorted);

	String[] getArrayOfPrimes(int size, long minValue, long maxValue);

	String[] getArrayOfDistinctPrimeNumbers(int size, long minValue, long maxValue);

	String[] getArrayOfDistinctNumbers(int size, long minValue, long maxValue);

	String[] getMultiplesOfNumber(int size, long minValue, long maxValue, long multipleOf);

	String[] getDistinctMultiplesOfNumber(int size, long minValue, long maxValue, long multipleOf);

	String[] getArrayOfAnyRandomNumbers(int size, long minValue, long maxValue);


	<T> ArrayList getArrayOfDistinctPrimeNumbers(NumberSO<T> numberSO);

	<T> ArrayList getArrayOfPrimes(NumberSO<T> numberSO);

	<T> ArrayList getArrayOfDistinctNumbers(NumberSO<T> numberSO);

	<T> ArrayList getArrayOfAnyRandomNumbers(NumberSO<T> numberSO);
}
