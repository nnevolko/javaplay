package main.java;


public class BoggyTest {
	
	static int mine = 7;
	static Integer i = 57;
	
	public void testBoggyTest(){
		
		int x = go(mine);
		
		System.out.print( mine + " " + x + " ");
		
		int z =  x + mine; 
		int i2 = i;
		i2 = go(i);
		System.out.print( z + " " + i2 + " ");
	
	}
	
	public int go(int x){
		return ++x;
	}

}
