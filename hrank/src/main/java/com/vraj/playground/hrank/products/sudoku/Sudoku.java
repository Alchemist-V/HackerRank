/**
 * 
 */
package com.vraj.playground.hrank.products.sudoku;

import java.util.Objects;

/**
 * Class to encapsulate sudoku object that is to be passed to biz layer for
 * solving.
 * 
 * @author vrajori
 *
 */
public class Sudoku {

	private final int sudoku[][];

	public static class Builder {
		private final int sudoku[][];

		Builder() {
			sudoku = new int[SudokuDimension.LENGTH.getVal()][SudokuDimension.WIDTH.getVal()];
		}

		public Builder registerVal(int x, int y, int val) {
			validateIndex(x);
			validateIndex(y);
			validateValue(val);
			this.sudoku[x][y] = val;
			return this;
		}

		private void validateIndex(int index) {
			Objects.requireNonNull(index);
			if (index < 0 || index > 8) {
				String ex = "Sudoku index needs to be in range ( 0, "
						+ String.valueOf(SudokuDimension.LENGTH.getVal() - 1) + "), you provided: " + index;
				throw new IllegalArgumentException(ex);
			}
		}

		private void validateValue(int value) {
			Objects.requireNonNull(value);
			if (value < 1 || value > 9) {
				String ex = "Sudoku value needs to be in range ( 1, " + String.valueOf(SudokuDimension.LENGTH.getVal())
						+ "), you provided: " + value;
				throw new IllegalArgumentException(ex);
			}
		}

		public Sudoku build() {
			return new Sudoku(this);
		}
	}

	Sudoku(Builder builder) {
		this.sudoku = builder.sudoku;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SudokuDimension.LENGTH.getVal(); i++) {
			for (int j = 0; j < SudokuDimension.WIDTH.getVal(); j++) {
				sb.append(sudoku[i][j]);
				if (j % 3 == 2) {
					sb.append("  ");
				}
			}
			sb.append("\n");
			if (i % 3 == 2) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	public int getValAt(int x, int y) {
		return sudoku[x][y];
	}

	public void setValAt(int x, int y, int val) {
		sudoku[x][y] = val;
	}
}
