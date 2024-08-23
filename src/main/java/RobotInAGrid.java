package main.java;

import java.util.Random;
import java.util.Stack;

/*
 * nnevolko
 */

public class RobotInAGrid {

	int rows;
	int columns;
	
	final int INFINITY = 99;

	int[][] matrix;

	public RobotInAGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		matrix = new int[rows][columns];
	}

	public void initialize() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = INFINITY;
			}
		}

		Random r = new Random();
		int rowLow = 0;
		int rowHigh = rows;
		int colLow = 0;
		int colHigh = columns;

		int maxUnavailable = 2;
		if (rows* columns >25);{
			maxUnavailable = rows*columns/5;
		}
		
		for (int num = 0; num < maxUnavailable; num++) {
			int rowIndex = r.nextInt(rowHigh - 1);
			int colIndex = r.nextInt(colHigh - 1);
			matrix[rowIndex][colIndex] = -1;
		}

	}

	public void printMatrix() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + "|");
			}
			System.out.print("\n");
		}
		System.out.println("-----------------");
	}

	public void computeDistance() {
		matrix[0][0] = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				boolean movedRight = checkAvailable(i - 1, j);
				boolean movedDown = checkAvailable(i, j - 1);
				if (movedRight) {
					if (matrix[i - 1][j] < matrix[i][j]) {
						matrix[i][j] = matrix[i - 1][j] + 1;
					}
				}
				if (movedDown) {
					if (matrix[i][j - 1] < matrix[i][j]) {
						matrix[i][j] = matrix[i][j - 1] + 1;
					}
				}

			}
		}
	}

	boolean checkAvailable(int i, int j) {
		if (i < 0) {
			return false;
		}
		if (j < 0) {
			return false;
		}
		if (i == rows) {
			return false;
		}
		if (j == columns) {
			return false;
		}
		if (matrix[i][j] == -1) {
			return false;
		}
		return true;
	}

	public void callPath() {

		int distance = matrix[rows-1][columns-1];
		Stack<Point> path = new Stack<Point>();
		path.push(new Point(rows-1, columns-1));
		if (distance != 99){
		findPath(distance, distance, rows - 1, columns - 1, path);
		for (Point p: path){
			System.out.print(p);
		}
		} else {
			System.out.print("No Path available!");
		}
	}

	public void findPath(int newDistance, int originalDistance, int rowIndex, int colIndex, Stack<Point> path) {

		if (newDistance == 0) {
			path.push(new Point(rowIndex, colIndex));
			return;
		} 
		
		boolean found = false;
		if (checkAvailable(rowIndex-1, colIndex) && !isInfinity(rowIndex-1, colIndex)) {
			if (matrix[rowIndex-1][colIndex]< matrix[rowIndex][colIndex]) {
				path.push(new Point(rowIndex-1, colIndex));
				System.out.println("new distance: " + matrix[rowIndex-1][colIndex] +" (" + (rowIndex-1) +","+ colIndex + ")");
				findPath(matrix[rowIndex-1][colIndex], originalDistance, rowIndex-1, colIndex, path);
				found = true;
			} 
		} 
		else if (checkAvailable(rowIndex, colIndex-1) && !isInfinity(rowIndex, colIndex-1)) {
			if (matrix[rowIndex][colIndex-1] < matrix[rowIndex][colIndex]) {
				path.push(new Point(rowIndex, colIndex-1));
				System.out.println("new distance: " + matrix[rowIndex][colIndex-1] +" (" + rowIndex +","+ (colIndex-1) + ")");
				findPath(matrix[rowIndex][colIndex-1], originalDistance, rowIndex, (colIndex-1), path);
				found = true;
			}
		}
	}

	
	public boolean isInfinity(int rowIndex, int colIndex){
		return  matrix[rowIndex][colIndex] == INFINITY;
	}
}
