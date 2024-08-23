package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestPlusMinus {

	
	@Test	
	public void plusMinusTest(){
	
		int[] intArray0 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
		int[] intArray = new int[] {1,1, 0, -1, -1};
	

        Integer[] arr = Arrays.stream( intArray ).boxed().toArray( Integer[]::new );
        List<Integer> intList = Arrays.asList(arr);
        
   /* List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());*/
   // PlusMinus pm = new PlusMinus();
    //pm.plusMinus(arr);
    
	}
}
