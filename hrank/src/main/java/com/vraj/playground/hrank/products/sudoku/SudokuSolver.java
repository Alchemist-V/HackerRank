package com.vraj.playground.hrank.products.sudoku;

import java.util.Stack;

/**
 * Solver class for solving given {@link Sudoku} instance.
 * 
 * @author vrajori
 *
 */
public class SudokuSolver {

	/**
	 * Solves passed sudoku instance.
	 * 
	 * @return
	 */
	public boolean solve(Sudoku sudoku) {

		for (int i = 0; i < SudokuDimension.LENGTH.getVal(); i++) {
			for (int j = 0; j < SudokuDimension.WIDTH.getVal(); j++) {
				if (sudoku.getValAt(i, j) != 0) {
					continue;
				}
				// need to fill this value
				for (int k = 1; k <= 9; k++) {
					sudoku.setValAt(i, j, k);
					System.out.println("Testing " + k + ", at (" + i + ", " + j + ")");
					if (isValidEntry(sudoku, i, j, k)) {
						System.out.println("Potential match " + k + ", at (" + i + ", " + j + ")");
						if (solve(sudoku)) {
							return true;
						}
					}

					sudoku.setValAt(i, j, 0);
				}
				return false;
			}
		}
		return true;

	}

	/**
	 * Validates sudoku any particular state.
	 * 
	 * @param sudoku
	 * @param x
	 * @param y
	 * @param val
	 * @return
	 */
	private boolean isValidEntry(Sudoku sudoku, int x, int y, int val) {
		return (validateSquare(sudoku, x, y, val) && validateRow(sudoku, x, y, val))
				&& validateColumn(sudoku, x, y, val);
	}

	private boolean validateSquare(Sudoku sudoku, int x, int y, int val) {
		boolean flag = true;
		if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
			flag = validateLocalSquare(sudoku, 0, 2, 0, 2, val);
		} else if ((x >= 0 && x <= 2) && (y >= 3 && y <= 5)) {
			flag = validateLocalSquare(sudoku, 0, 2, 3, 5, val);
		} else if ((x >= 0 && x <= 2) && (y >= 6 && y <= 8)) {
			flag = validateLocalSquare(sudoku, 0, 2, 6, 8, val);
		} else if ((x >= 3 && x <= 5) && (y >= 0 && y <= 2)) {
			flag = validateLocalSquare(sudoku, 3, 5, 0, 2, val);
		} else if ((x >= 3 && x <= 5) && (y >= 3 && y <= 5)) {
			flag = validateLocalSquare(sudoku, 3, 5, 3, 5, val);
		} else if ((x >= 3 && x <= 5) && (y >= 6 && y <= 8)) {
			flag = validateLocalSquare(sudoku, 3, 5, 6, 8, val);
		} else if ((x >= 6 && x <= 8) && (y >= 0 && y <= 2)) {
			flag = validateLocalSquare(sudoku, 6, 8, 0, 2, val);
		} else if ((x >= 6 && x <= 8) && (y >= 3 && y <= 5)) {
			flag = validateLocalSquare(sudoku, 6, 8, 3, 5, val);
		} else if ((x >= 6 && x <= 8) && (y >= 6 && y <= 8)) {
			flag = validateLocalSquare(sudoku, 6, 8, 6, 8, val);
		}

		return flag;
	}

	private boolean validateLocalSquare(Sudoku sudoku, int startX, int endX, int startY, int endY, int val) {
		int count = 0;
		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if (sudoku.getValAt(i, j) == val) {
					count++;
				}
			}
		}
		return count == 1;
	}

	private boolean validateRow(Sudoku sudoku, int x, int y, int val) {
		int count = 0;
		for (int i = 0; i < SudokuDimension.WIDTH.getVal(); i++) {
			if (sudoku.getValAt(x, i) == val) {
				count++;
			}
		}
		return count == 1;
	}

	private boolean validateColumn(Sudoku sudoku, int x, int y, int val) {
		int count = 0;
		for (int i = 0; i < SudokuDimension.LENGTH.getVal(); i++) {
			if (sudoku.getValAt(i, y) == val) {
				count++;
			}
		}
		return count == 1;
	}

	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku.Builder().registerVal(0, 0, 5).registerVal(0, 1, 3).registerVal(0, 4, 7)
				.registerVal(1, 0, 6).registerVal(1, 3, 1).registerVal(1, 4, 9).registerVal(1, 5, 5)
				.registerVal(2, 1, 9).registerVal(2, 2, 8).registerVal(2, 7, 6).registerVal(3, 0, 8)
				.registerVal(3, 4, 6).registerVal(3, 8, 3).registerVal(4, 0, 4).registerVal(4, 3, 8)
				.registerVal(4, 5, 3).registerVal(4, 8, 1).registerVal(5, 0, 7).registerVal(5, 4, 2)
				.registerVal(5, 8, 6).registerVal(6, 1, 6).registerVal(6, 6, 2).registerVal(6, 7, 8)
				.registerVal(7, 3, 4).registerVal(7, 4, 1).registerVal(7, 5, 9).registerVal(7, 8, 5)
				.registerVal(8, 4, 8).registerVal(8, 7, 7).registerVal(8, 8, 9).build();

		System.out.println(sudoku.toString());

		SudokuSolver solver = new SudokuSolver();
		solver.solve(sudoku);

		System.out.println(sudoku.toString());
	}

}
