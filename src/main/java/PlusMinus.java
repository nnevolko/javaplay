package main.java;

import java.util.ArrayList;
import java.util.List;

public class PlusMinus {

	/*
	 * 
	 * Print the following lines, each to decimals:
	 * 
	 * proportion of positive values proportion of negative values proportion of
	 * zeros
	 */
	public void plusMinus(List<Integer> arr) {

		List<Integer> positives = new ArrayList<Integer>();
		List<Integer> negatives = new ArrayList<Integer>();
		int zeroCounter = 0;

		for (Integer e : arr) {
			if (e > 0) {
				positives.add(e);
			} else if (e < 0) {
				negatives.add(e);
			} else {
				zeroCounter++;
			}
		}

		
		int totalNumbers = arr.size();
		double[] resultArray = new double[3];
	
		
		resultArray[0] = positives.size()/(double)totalNumbers;
		resultArray[1] = negatives.size()/(double)totalNumbers;
		resultArray[2] = zeroCounter/(double)totalNumbers;

		for (double num : resultArray) {
			System.out.println(String.format("%.6f", num));
		}
	}

}
