package com.jntu.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ArrayOfStrings extends ArraysCommon {

	@Override
	public String toString() {
		return "ArrayOfStrings [minLength=" + minLength + ", maxLength=" + maxLength + ", minCharValue=" + minCharValue
				+ ", maxCharValue=" + maxCharValue + ", sorted=" + sorted + ", charCase=" + charCase + ", isPalindrome="
				+ isPalindrome + ", " +super.toString() + "]";
	}

	@NotNull(message = "MINIMUM LENGTH OF THE STRING MUST NOT BE NULL")
	@Min(value = 1, message = "MINIMUM LENGTH OF THE STRING MUST BE GREATER THAN OR EQUAL TO 1")
	private int minLength = 1;

	@NotNull(message = "MIXIMUM LENGTH OF THE STRING MUST NOT BE NULL")
	@Min(value = 1, message = "MIXIMUM LENGTH OF THE STRING MUST BE GREATER THAN OR EQUAL TO 1")
	private int maxLength = 5;

	@NotNull(message = "MINIMUM CHAR VALUE MUST NOT BE NULL")
	private char minCharValue = 'A';

	@NotNull(message = "MAXIMUM CHAR VALUE MUST NOT BE NULL")
	private char maxCharValue = 'Z';

	@NotEmpty(message = "SORTED MUST HOLD A VALUE FROM DROP DOWN")
	private String sorted = "none";// TODO :MAKE ENUM

	@NotEmpty(message = "CASE MUST HOLD A VALUE FROM DROP DOWN")
	private String charCase = "upper";// TODO :MAKE ENUM

	@NotNull(message = "PALINDROME MUST NOT BE NULL")
	private Boolean isPalindrome = false;

	public Boolean getIsPalindrome() {
		return isPalindrome;
	}

	public void setIsPalindrome(Boolean isPalindrome) {
		this.isPalindrome = isPalindrome;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public char getMinCharValue() {
		return minCharValue;
	}

	public void setMinCharValue(char minCharValue) {
		this.minCharValue = minCharValue;
	}

	public char getMaxCharValue() {
		return maxCharValue;
	}

	public void setMaxCharValue(char maxCharValue) {
		this.maxCharValue = maxCharValue;
	}

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}

	public String getCharCase() {
		return charCase;
	}

	public void setCharCase(String charCase) {
		this.charCase = charCase;
	}

	@AssertTrue(message = "MAXIMUM CHAR VALUE MUST BE GREATER OR EQUAL TO MINIMUM CHAR VALUE")
	public boolean isValueCheckSatisfied() {
		return this.minCharValue <= this.maxCharValue;

	}

	@AssertTrue(message = "MAXIMUM LENGTH MUST BE GREATER OR EQUAL TO MINIMUM LENGTH")
	public boolean isLengthCheckSatisfied() {
		return this.minLength <= this.maxLength;
	}

	@AssertTrue(message = "MENTIONED CASE AND VALUES DO NOT MATCH")
	public boolean isValueAndCaseCheckSatisfied() {
		if ("lower".equals(this.charCase)
				&& (Character.isUpperCase(this.minCharValue) || Character.isUpperCase(this.maxCharValue))) {
			return false;
		}
		if ("upper".equals(this.charCase)
				&& (Character.isLowerCase(this.minCharValue) || Character.isLowerCase(this.maxCharValue))) {
			return false;
		}
		return true;
	}

	@AssertTrue(message = "BOTH MIN VALUE AND MAX VALUE MUST BE OF SAME CASE")
	public boolean isMinValueAndMaxValueSameCase() {
		return (Character.isUpperCase(this.minCharValue) == Character.isUpperCase(this.maxCharValue));
	}

	@AssertTrue(message = "ENTERED VALUES MUST BE ALPHABETS")
	public boolean isAlphabet() {
		return (Character.isLetter(this.minCharValue) && Character.isLetter(this.maxCharValue));
	}

}
