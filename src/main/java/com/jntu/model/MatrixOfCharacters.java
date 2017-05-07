package com.jntu.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MatrixOfCharacters extends MatrixCommon {

	@Override
	public String toString() {
		return "MatrixOfCharacters [minValue=" + minValue + ", maxValue=" + maxValue + ", isDistinct=" + isDistinct
				+ ", charCase=" + charCase + ", " + super.toString() + "]";
	}

	@NotNull(message = "MINIMUM CHAR VALUE MUST NOT BE NULL")
	private char minValue = 'A';

	@NotNull(message = "MAXIMUM CHAR VALUE MUST NOT BE NULL")
	private char maxValue = 'Z';

	@NotNull(message = "DISTINCT GENERATION MUST BE ENABLED OR DISABLED")
	private Boolean isDistinct = false;

	@NotEmpty(message = "CASE MUST HOLD A VALUE FROM DROP DOWN")
	private String charCase = "upper";// TODO :MAKE ENUM

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

	public String getCharCase() {
		return charCase;
	}

	public void setCharCase(String charCase) {
		this.charCase = charCase;
	}

	@AssertTrue(message = "MAXIMUM CHAR VALUE MUST BE GREATER OR EQUAL TO MINIMUM CHAR VALUE")
	public boolean isValueCheckSatisfied() {
		return this.minValue <= this.maxValue;

	}

	@AssertTrue(message = "MENTIONED CASE AND VALUES DO NOT MATCH")
	public boolean isValueAndCaseCheckSatisfied() {
		if ("lower".equals(this.charCase)
				&& (Character.isUpperCase(this.minValue) || Character.isUpperCase(this.maxValue))) {
			return false;
		}
		if ("upper".equals(this.charCase)
				&& (Character.isLowerCase(this.minValue) || Character.isLowerCase(this.maxValue))) {
			return false;
		}
		return true;
	}

	@AssertTrue(message = "BOTH MIN VALUE AND MAX VALUE MUST BE OF SAME CASE")
	public boolean isMinValueAndMaxValueSameCase() {
		return (Character.isUpperCase(this.minValue) == Character.isUpperCase(this.maxValue));
	}

	@AssertTrue(message = "ENTERED VALUES MUST BE ALPHABETS")
	public boolean isAlphabet() {
		return (Character.isLetter(this.minValue) && Character.isLetter(this.maxValue));
	}

	@AssertTrue(message = "GIVEN MATRIX DIMENSIONS CAN NOT HAVE ENOUGH DISTINCT NUMBERS")
	public boolean isRangeValidIfDistinctIsChecked() {
		if (!this.isDistinct)
			return true;
		return (this.getColumns() * this.getRows()) <= (this.maxValue - this.minValue + 1);
	}
}
