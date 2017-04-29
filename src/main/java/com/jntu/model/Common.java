package com.jntu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Common {
	
	@NotNull(message="NO OF TESTCASES CAN'T BE EMPTY")
	@Min(value=1,message="NO OF TESTCASES MUST BE GREATER THAN OR EQUAL TO 1")
	private long noOfTestCases=1;
	
	@NotNull(message="PRINT NO OF TESTCASES SHOULD BE EITHER YES OR NO")
	private Boolean printNoOfTestCases=true;

	public Boolean getPrintNoOfTestCases() {
		return printNoOfTestCases;
	}

	public void setPrintNoOfTestCases(Boolean printNoOfTestCases) {
		this.printNoOfTestCases = printNoOfTestCases;
	}

	public long getNoOfTestCases() {
		return noOfTestCases;
	}

	public void setNoOfTestCases(long noOfTestCases) {
		this.noOfTestCases = noOfTestCases;
	}

}
