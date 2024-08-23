package main.java;

import java.util.ArrayList;
import java.util.List;

public class MinMaxSum {

	/*
	 * Print two space-separated long integers denoting the respective minimum and
	 * maximum values that can be calculated by summing exactly four of the five
	 * integers. (The output can be greater than a 32 bit integer.)
	 * 
	 */
	public void miniMaxSum(List<Integer> arr) {
		// Write your code here
		long max;
		long min;
		long sum;
		List<Long> sumsList = new ArrayList<Long>();

		// calculate size()-1 numbers in a list
		for (int index1 = 0; index1 < arr.size(); index1++) {
			sum = 0;
			min = 0;

			for (int index2 = 0; index2 < arr.size(); index2++) {
				// skip one of the elements
				if (index2 != index1) {
					long element = arr.get(index2);
					sum += element;
				}
			}
			sumsList.add(sum);
		}

		max = sumsList.get(0);
		min = sumsList.get(0);
		for (Long number : sumsList) {
			if (number.longValue() > max) {
				max = number;
			}
			if (number.longValue() < min) {
				min = number;
			}
		}
		
		System.out.println(min + " " + max);

	}

}
