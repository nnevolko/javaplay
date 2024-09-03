package main.java;

import java.util.List;
import java.util.ArrayList;
/**
 * input array can be of various size but the elements are 0<e<100
 * return frequency array of elements within the range.
 */

public class CountSort {

	public static List<Integer> countingSort(List<Integer> arr) {
		List<Integer> frequencyList = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			frequencyList.add(0);
		}
		for (Integer e : arr) {
			int value = frequencyList.get(e);
			frequencyList.set(e.intValue(), value + 1);
		}

		return frequencyList;
	}

}
