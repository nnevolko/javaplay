package main.java;

public class KantTest {

	public void testKant() {

		new Kant("Homer");
		new Kant();
	}

}

class Philosopher {

	Philosopher(String s) {
		System.out.print(s + " ");
	}
}

class Kant extends Philosopher {
/*
    Example 1: Work
	Kant() {
		this("Bart");
	}

	Kant(String s) {
		super(s);
	}
	*/
	
	 // Example 2: Work
	Kant(){
		super("Bart");
	}
	
	Kant(String s){
		super (s);
	}

	/*
	 Example 3: Does not work
	  
	 Kant(){
		super(); // default constructor was not implemented
	}
	
	Kant(String s){
		super(s);
	}
	*/
	
	/*
	 Example4: Works
	Kant(){
		super ("Bart");
	}
	
	Kant(String s){
		this(s); // recursive call will nto work
	}
	*/
	
	/* Example 5: Does not work
	Kant(){
		super ("Bert");
	}
	Kant(String s){
		this("Homer");
	}
	*/
}
