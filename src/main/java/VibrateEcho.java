package main.java;


abstract class Vibrate{
	
	static String s ="-";
	
	Vibrate(){
		s+="v";
	}
}

class Echo extends Vibrate{
	
	Echo(){
		this(7);
		s+="e";
	}
	Echo(int x){
		s+="e2";
	}
}


public class VibrateEcho extends Vibrate{
	
	public static void test () {
		System.out.print("made " + s +  " ");		
		//block -ve2e made -ve2e[v] ... last v only if you don't run this out of main.. then  		
	}
	static{
		Echo e = new Echo();
		System.out.print( "block " + s + " ");
		
	}
	
}




