package main.java;

import java.util.ArrayList;
import java.util.List;

/*
 * nnevolko
 */

interface AdvancedArithmetic {
	public int divisor_sum(int n);
}

public class RankOOP implements AdvancedArithmetic {

	  public int divisor_sum(int n) {
		int sum = 0;
		List<Integer> divisors = new ArrayList<Integer>();
		if (n == 1) {
			sum = 1;
		} else if (n > 1 & n < 1001) {
			divisors.add(1);
			sum++;
			for (int i = 2; i <= n/2; i++) {
				if (n % i == 0) {
					divisors.add(i);
					sum += i;
				}
			}
			sum += n;

		}
		for (Integer divisor : divisors) {
			System.out.println(divisor + " ");
		}
		return sum;
	}

	public void testDivisorSum() {

		System.out.printf("Number %d, sum: %d \n", 6, divisor_sum(6));
		System.out.printf("Number %d, sum: %d \n", 20, divisor_sum(20));
		System.out.printf("Number %d, sum: %d \n", 97, divisor_sum(97));
	}

}
