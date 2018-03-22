/**
 * 
 */
package com.vraj.playground.hrank.products.sudoku;

/**
 * Container of sudoku and some meta info which relates to various interim
 * states of sudoku.
 * 
 * @author vrajori
 *
 */
public class SudokuState {

	private Sudoku sudoku;

	private int row;

	private int col;

	private int usedVal;

	public SudokuState(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public SudokuState row(int row) {
		this.row = row;
		return this;
	}

	public SudokuState col(int col) {
		this.col = col;
		return this;
	}

	public SudokuState usedVal(int usedVal) {
		this.usedVal = usedVal;
		return this;
	}

	public Sudoku getSudoku() {
		return sudoku;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getUsedVal() {
		return usedVal;
	}
}
