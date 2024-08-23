package test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.java.PlusMinus;

public class TestPlusMinus {

	@Test
	public void plusMinusTest() {
		
		PlusMinus pm = new PlusMinus();

		List<Integer> intList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);		
		List<String> results1 = pm.plusMinus(intList1);
		//System.out.println(results1.toString()); [1.000000, 0.000000, 0.000000]
		assertTrue(results1.size()==3);
		assertTrue(results1.get(0).equals("1.000000"));
		assertTrue(results1.get(1).equals("0.000000"));
		assertTrue(results1.get(2).equals("0.000000"));
		
		List<Integer> intList2 = Arrays.asList(1, 1, 0, -1, -1);
		List<String> results2 = pm.plusMinus(intList2);
		//System.out.println(results.toString()); [0.400000, 0.400000, 0.200000]
		assertTrue(results2.size()==3);
		assertTrue(results2.get(0).equals("0.400000"));
		assertTrue(results2.get(1).equals("0.400000"));
		assertTrue(results2.get(2).equals("0.200000"));
		
	}
}
