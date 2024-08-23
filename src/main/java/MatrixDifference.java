package main.java;

import java.util.Random;
/*
 * nnevolko
 */

public class MatrixDifference {

	public void calculateDiagonalDifference() {

		Random rand = new Random();
		int n = rand.nextInt(10) + 3;
		int a[][] = new int[n][n];
		int primaryDiagonalSum = 0;
		int secondaryDiagonalSum = 0;
		int a_o = n - 1;
		int a_p = 0;

		for (int a_i = 0; a_i < n; a_i++) {
			for (int a_j = 0; a_j < n; a_j++) {
				a[a_i][a_j] = rand.nextInt(100) + 1;
				System.out.print(a[a_i][a_j] + " ");
				if (a_i == a_j) {
					primaryDiagonalSum += a[a_i][a_j];
				}
				if (a_j == a_o && a_i == a_p) {
					secondaryDiagonalSum += a[a_i][a_j];
					a_o--;
					a_p++;
				}
			}
			System.out.println();
		}

		int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
		System.out.println(difference);
	}

}
