package com.jntu.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ArraysCommon extends Common {

	@NotNull(message = "PRINT ARRAY SIZE MUST BE EITHER TRUE OR FALSE")
	private Boolean printArraySize=true;

	@NotNull(message = "MINIMUM SIZE OF ARRAY NEEDS A VALUE")
	@Min(value = 1, message = "MINIMUM SIZE OF AN ARRAY MUST BE GREATER THAN OR EQUAL TO 1")
	private int minSize=1;

	@NotNull(message = "MAXIMUM SIZE OF ARRAY NEEDS A VALUE")
	private int maxSize=5;

	public int getMinSize() {
		return minSize;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public Boolean getPrintArraySize() {
		return printArraySize;
	}

	public void setPrintArraySize(Boolean printArraySize) {
		this.printArraySize = printArraySize;
	}
	
	@AssertTrue(message="MAXIMUM SIZE OF ARRAY MUST BE GREATER OR EQUAL TO MINIMUM SIZE OF ARRAY")
	public boolean isSizeCheckSatisfied(){
		return this.minSize<=this.maxSize;	
	}

}
