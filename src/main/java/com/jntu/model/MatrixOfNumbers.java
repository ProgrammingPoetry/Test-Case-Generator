package com.jntu.model;

import java.util.ArrayList;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import com.jntu.util.Utility;

public class MatrixOfNumbers extends MatrixCommon {

	@Override
	public String toString() {
		return "MatrixOfNumbers [minValue=" + minValue + ", maxValue=" + maxValue + ", multipleOf=" + multipleOf
				+ ", isPrime=" + isPrime + ", isDistinct=" + isDistinct + ", " + super.toString() + "]";
	}

	@NotNull(message = "MINIMUM VALUE MUST NOT BE NULL")
	private long minValue = 1;

	@NotNull(message = "MAXIMUM VALUE MUST NOT BE NULL")
	private long maxValue = 10;

	@NotNull(message = "MULTIPLE OF MUST NOT BE NULL")
	private long multipleOf = 1;

	@NotNull(message = "PRIME GENERATION MUST BE ENABLED OR DISABLED")
	private Boolean isPrime = false;

	@NotNull(message = "DISTINCT GENERATION MUST BE ENABLED OR DISABLED")
	private Boolean isDistinct = false;

	public long getMinValue() {
		return minValue;
	}

	public void setMinValue(long minValue) {
		this.minValue = minValue;
	}

	public long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}

	public long getMultipleOf() {
		return multipleOf;
	}

	public void setMultipleOf(long multipleOf) {
		this.multipleOf = multipleOf;
	}

	public Boolean getIsPrime() {
		return isPrime;
	}

	public void setIsPrime(Boolean isPrime) {
		this.isPrime = isPrime;
	}

	public Boolean getIsDistinct() {
		return isDistinct;
	}

	public void setIsDistinct(Boolean isDistinct) {
		this.isDistinct = isDistinct;
	}

	@AssertTrue(message = "MAXVALUE MUST BE GREATER OR EQUAL TO MINVALUE")
	public boolean isValueCheckSatisfied() {
		return this.minValue <= this.maxValue;
	}

	@AssertTrue(message = "IF PRIME IS ENABLED MULTIPLE OF MUST BE EQUAL TO 1")
	public boolean isMultipleOfSatisfied() {
		if (this.isPrime && this.multipleOf != 1) {
			return false;
		}
		return true;
	}

	@AssertTrue(message = "THERE ARE NO PRIMES IN GIVEN RANGE. EITHER INCREASE RANGE OR UNCHECK PRIME")
	public boolean isValueRangeValidIfPrimeIsChecked() {
		if (!this.isPrime) {
			return true;
		}
		// TODO : change this way of checking
		ArrayList<Long> primesList = Utility.generatePrimeNumbersWithinRange(this.minValue, this.maxValue);
		if (primesList.size() > 0) {
			return true;
		}
		return false;
	}

	@AssertTrue(message = "GIVEN MATRIX DIMENSIONS CAN NOT HAVE ENOUGH DISTINCT PRIMES")
	public boolean isValueRangeValidIfPrimeAndDistinctAreChecked() {
		if (!this.isPrime) {
			return true;
		}
		if (!this.isDistinct) {
			return true;
		}
		// TODO : change this way of checking
		ArrayList<Long> primesList = Utility.generatePrimeNumbersWithinRange(this.minValue, this.maxValue);
		int noOfPrimes = primesList.size();
		int maxSize = this.getColumns() * this.getRows();
		if (noOfPrimes >= maxSize) {
			return true;
		}
		return false;
	}

	@AssertTrue(message = "GIVEN MATRIX DIMENSIONS CAN NOT HAVE ENOUGH DISTINCT NUMBERS")
	public boolean isRangeValidIfDistinctIsChecked() {
		if (!this.isDistinct)
			return true;
		return (this.getColumns() * this.getRows()) <= (this.maxValue - this.minValue + 1);
	}

	@AssertTrue(message = "GIVEN MATRIX DIMENSIONS CAN NOT HAVE ENOUGH DISTINCT NUMBERS FOR GIVEN MULTIPLE OF")
	public boolean isRangeValidIfDistinctIsCheckedForGivenMultipleOf() {
		if (this.multipleOf == 1) {
			return true;
		}
		return (this.getColumns() * this.getRows()) <= (this.maxValue - this.minValue + 1) / this.multipleOf;
	}

}
