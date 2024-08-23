package main.java;

import java.util.List;

/*
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix  is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .

Function description

Complete the  function in the editor below.

diagonalDifference takes the following parameter:

int arr[n][m]: an array of integers
Return

int: the absolute diagonal difference

 */
public class DiagonalDifference {
	
	public int calculateAbsoluteDiagonalDifference(List<List<Integer>> arr) {
		int matrixSize = arr.size();
		
		//get a row
		int differenceDiagonalLeftTopDown = 0;
		int differenceDiagonalLeftBottomUp = 0;
		
		int offsetLeft = 0;
		int offsetRight = matrixSize-1;
		
		for (int index=0; index<matrixSize; index++) {
				List<Integer> arrIntegers= arr.get(index);
				differenceDiagonalLeftTopDown += arrIntegers.get(offsetLeft);
				differenceDiagonalLeftBottomUp += arrIntegers.get(offsetRight);
				offsetLeft++;
				offsetRight--;				
		}
		
		int absoluteDifference = Math.abs(differenceDiagonalLeftTopDown - differenceDiagonalLeftBottomUp);
		return absoluteDifference;
		
	}

}
