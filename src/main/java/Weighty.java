class Big {
	void doStuff(int x) {
	}
}

class Heavy extends Big {
	 void doStuff(byte b) { } //6
	// protected void doStuff(int x) throws Exception { } //7
}

public class Weighty extends Heavy {

	void doStuff(int x) { } //10
	 //String doStuff(int x) { return "hi"; } //11
	// public int doStuff(int x) { return 7; } //12
	 private int doStuff(char c) throws Error { return 1; } //13
}

/*

106 Chapter 3: Practice Exam 1
Which method(s), if uncommented independently, compile? (Choose all that apply.)
A. Line 6
B. Line 7
C. Line 10
D. Line 11
E. Line 12
F. Line 13

*/