package com.jntu.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ArrayOfCharacters extends ArraysCommon {
	
	@NotNull(message="MINIMUM CHAR VALUE MUST NOT BE NULL")
	private char minValue='A';
	
	@NotNull(message="MAXIMUM CHAR VALUE MUST NOT BE NULL")
	private char maxValue='Z';
	
	@NotNull(message = "DISTINCT GENERATION MUST BE ENABLED OR DISABLED")
	private Boolean isDistinct = false;
	
	@NotEmpty(message = "SORTED MUST HOLD A VALUE FROM DROP DOWN")
	private String sorted = "none";// TODO :MAKE ENUM
	
	@NotEmpty(message = "CASE MUST HOLD A VALUE FROM DROP DOWN")
	private String charCase;// TODO :MAKE ENUM

	public String getCharCase() {
		return charCase;
	}

	public void setCharCase(String charCase) {
		this.charCase = charCase;
	}

	public char getMinValue() {
		return minValue;
	}

	public void setMinValue(char minValue) {
		this.minValue = minValue;
	}

	public char getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(char maxValue) {
		this.maxValue = maxValue;
	}

	public Boolean getIsDistinct() {
		return isDistinct;
	}

	public void setIsDistinct(Boolean isDistinct) {
		this.isDistinct = isDistinct;
	}

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}
}
