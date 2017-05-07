package com.jntu.service;

public class NumberSO<T> {
	
	@Override
	public String toString() {
		return "NumberSO [arraySize=" + arraySize + ", minValue=" + minValue + ", maxValue=" + maxValue
				+ ", multipleOf=" + multipleOf + ", sorted=" + sorted + "]";
	}

	private int arraySize;
	
	private T minValue;
	
	private T maxValue;
	
	private T multipleOf;
	
	private String sorted;

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public T getMinValue() {
		return minValue;
	}

	public void setMinValue(T minValue) {
		this.minValue = minValue;
	}

	public T getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(T maxValue) {
		this.maxValue = maxValue;
	}

	public T getMultipleOf() {
		return multipleOf;
	}

	public void setMultipleOf(T multipleOf) {
		this.multipleOf = multipleOf;
	}
}
