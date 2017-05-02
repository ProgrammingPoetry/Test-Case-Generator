package com.jntu.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ArrayOfStrings extends ArraysCommon {

	private int minLength;

	private int maxLength;

	@NotNull(message = "MINIMUM CHAR VALUE MUST NOT BE NULL")
	private char minCharValue = 'A';

	@NotNull(message = "MAXIMUM CHAR VALUE MUST NOT BE NULL")
	private char maxCharValue = 'Z';

	@NotEmpty(message = "SORTED MUST HOLD A VALUE FROM DROP DOWN")
	private String sorted = "none";// TODO :MAKE ENUM

	@NotEmpty(message = "CASE MUST HOLD A VALUE FROM DROP DOWN")
	private String charCase = "upper";// TODO :MAKE ENUM

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

}
