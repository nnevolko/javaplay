package main.java;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {
	

	public void printEvenNumbers(int fromInt, int toInt) {
		
		List<Integer> evenNumbers = new ArrayList<Integer>();
		for (int i=0; i<= toInt; i++) {
			if (i%2 == 0) {
				evenNumbers.add(i);
				System.out.print(i + " ");
			}
		}
		
	}
	
}
