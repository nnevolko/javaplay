import java.io.*;

public class MacPro extends Laptop {

	// Given that FileNotFoundException extends IOException, and given:
	public void testMacPro() {
		new MacPro().crunch();
	}

	// insert code here
	@Override
	//A, D
	//void crunch() throws RuntimeException{}
	//void crunch() throws FileNotFoundException{} ?? WHY not this one. research
	void crunch(){} 
	
	/*
	 * Which method(s), inserted independently at line 7, compile? (Choose all that apply.)
	 *  A. void crunch(){} 
	 * B. void crunch() throws Exception{} 
	 * C. void crunch(int x) throws Exception{}
	 *  D. void crunch() throws RuntimeException{} 
	 *  E. void crunch() throws FileNotFoundException{}
	 */
}

class Laptop {
	void crunch() throws IOException {
	}
}
