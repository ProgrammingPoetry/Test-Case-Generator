package com.jntu.model;

import javax.validation.constraints.Min;

public class MatrixCommon extends Common {

	@Override
	public String toString() {
		return "MatrixCommon [rows=" + rows + ", columns=" + columns + ", printNoOfRowsAndColumns="
				+ printNoOfRowsAndColumns + ", " + super.toString() + "]";
	}

	@Min(value=1,message="NO OF ROWS MUST BE GREATER THAN OR EQUAL TO 1")
	private int rows = 3;

	@Min(value=1,message="NO OF COLUMNS MUST BE GREATER THAN OR EQUAL TO 1")
	private int columns = 3;

	private Boolean printNoOfRowsAndColumns = true;


	public Boolean getPrintNoOfRowsAndColumns() {
		return printNoOfRowsAndColumns;
	}

	public void setPrintNoOfRowsAndColumns(Boolean printNoOfRowsAndColumns) {
		this.printNoOfRowsAndColumns = printNoOfRowsAndColumns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	
}
