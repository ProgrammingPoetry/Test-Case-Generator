package com.jntu.service;

public class CharacterSO {

	@Override
	public String toString() {
		return "CharacterSO [arraySize=" + arraySize + ", refString=" + refString + ", isDistinct=" + isDistinct + "]";
	}

	private int arraySize;
	
	private String refString;
	
	private boolean isDistinct;

	public boolean isDistinct() {
		return isDistinct;
	}

	public void setDistinct(boolean isDistinct) {
		this.isDistinct = isDistinct;
	}

	public String getRefString() {
		return refString;
	}

	public void setRefString(String refString) {
		this.refString = refString;
	}

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

}
