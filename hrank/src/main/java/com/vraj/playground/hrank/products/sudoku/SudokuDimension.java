/**
 * 
 */
package com.vraj.playground.hrank.products.sudoku;

/**
 * @author vrajori
 *
 */
public enum SudokuDimension {
	LENGTH(9), WIDTH(9);

	private int value;

	private SudokuDimension(int value) {
		this.value = value;
	}

	public int getVal() {
		return this.value;
	}
}
