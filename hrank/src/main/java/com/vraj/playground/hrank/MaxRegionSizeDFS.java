/**
 * 
 */
package com.vraj.playground.hrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 * 
 * @author vrajori
 *
 */
public class MaxRegionSizeDFS {

	public static int row = 0;
	public static int col = 0;
	public static int regionSize = 0;
	public static int tempRegionSize = 0;
	public static Set<Cell> visited = new HashSet<>();

	public static class Cell {
		int row;
		int col;

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		Cell(int i, int y) {
			this.row = i;
			this.col = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "(" + row + ", " + col + ")";
		}

	}

	public void traverse(int matrix[][], Cell cell) {
		if (visited.contains(cell)) {
			return;
		}
		System.out.println("visiting: " + cell);
		visited.add(cell);

		if (matrix[cell.getRow()][cell.getCol()] == 1) {
			tempRegionSize += 1;

			List<Cell> neighbors = getUnvisitedNeighbors(matrix, cell);
			for (Cell nextCell : neighbors) {
				traverse(matrix, nextCell);
			}
		}
	}

	private List<Cell> getUnvisitedNeighbors(int[][] matrix, Cell cell) {
		List<Cell> cells = new ArrayList<>();
		// top left
		addNeighbors(new Cell(cell.getRow() - 1, cell.getCol() - 1), cells);
		// top
		addNeighbors(new Cell(cell.getRow() - 1, cell.getCol()), cells);
		// top right
		addNeighbors(new Cell(cell.getRow() - 1, cell.getCol() + 1), cells);

		// left
		addNeighbors(new Cell(cell.getRow(), cell.getCol() - 1), cells);
		// right
		addNeighbors(new Cell(cell.getRow(), cell.getCol() + 1), cells);

		// bottom left
		addNeighbors(new Cell(cell.getRow() + 1, cell.getCol() - 1), cells);
		// bottom
		addNeighbors(new Cell(cell.getRow() + 1, cell.getCol()), cells);
		// bottom right
		addNeighbors(new Cell(cell.getRow() + 1, cell.getCol() + 1), cells);

		boolean flag = false;
		for (Cell c : cells) {
			if (matrix[c.getRow()][c.getCol()] == 1) {
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("New region search");
			// region ended
			regionSize = maxOf(regionSize, tempRegionSize);
			tempRegionSize = 0;
		}

		return cells;

	}

	private int maxOf(int num1, int num2) {
		if (num1 >= num2) {
			return num1;
		} else {
			return num2;
		}
	}

	private void addNeighbors(Cell cell, List<Cell> cells) {
		if (visited.contains(cell)) {
			return;
		}
		if (cell.getCol() < 0 || cell.getRow() < 0) {
			return;
		}

		cells.add(cell);
	}

	public static void main(String[] args) {
		int matrix[][] = new int[5][4];
		matrix[0][0] = 0;
		matrix[0][1] = 0;
		matrix[0][2] = 1;
		matrix[0][3] = 1;

		matrix[1][0] = 0;
		matrix[1][1] = 0;
		matrix[1][2] = 1;
		matrix[1][3] = 0;

		matrix[2][0] = 0;
		matrix[2][1] = 1;
		matrix[2][2] = 1;
		matrix[2][3] = 0;

		matrix[3][0] = 0;
		matrix[3][1] = 1;
		matrix[3][2] = 0;
		matrix[3][3] = 0;

		matrix[4][0] = 1;
		matrix[4][1] = 1;
		matrix[4][2] = 0;
		matrix[4][3] = 0;

		MaxRegionSizeDFS dfs = new MaxRegionSizeDFS();
		dfs.traverse(matrix, new Cell(0, 0));
		System.out.println(regionSize);
	}
}
