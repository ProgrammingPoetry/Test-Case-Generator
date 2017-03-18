package com.jntu.util;

import java.util.ArrayList;

/*
 * This class contains all the utility functions which we will be using in our application
 * Note: If you need a function immediately for testing purposes (example printing an array etc)
 * then write that function here. Do not populate the service-layer or controller-layer with
 * unnecessary functions. Write them here as static functions and access them wherever you require
 * using the format: Utility.<myFunction>()
 * 		where: myFunction is user defined function
 * */

public class Utility {

	public static ArrayList<Long> sieve() {
		ArrayList<Long> list = new ArrayList<>();
		boolean[] a = new boolean[1000000];
		for(int i = 0;i < 1000000;++i)
			a[i] = true;
		a[0] = a[1] = false;
		for(int i = 2;i < 1000000;++i) {
			if(a[i]) {
				int k = 2;
				while(i * k < 1000000) {
					a[i * k] = false;
					k++;
				}
			}
		}
		for(int i = 0;i < 1000000;++i)
			if(a[i])
				list.add((long)i);
		return list;
	}
	
	public static ArrayList<Long> generatePrimeNumbersWithinRange(long minValue, long maxValue) {
		ArrayList<Long> allPrimes = sieve();
		ArrayList<Long> primesArray = new ArrayList<>();
		
		int i;
		for(i = 0;i < allPrimes.size();++i)
			if(allPrimes.get(i) >= minValue)
				break;
		for(;i < allPrimes.size();++i)
			if(allPrimes.get(i) <= maxValue)
				primesArray.add(allPrimes.get(i));
			else
				break;
		// System.out.println("All Primes array is: ");
		// printList(primesArray);
		return primesArray;
	}
	
	public static void printList(ArrayList<Long> list) {
		for(int i = 0;i < list.size();++i) {
			if(i % 10 == 0)
				System.out.println("");
			System.out.print(list.get(i) + " ");
		}
	}

}
