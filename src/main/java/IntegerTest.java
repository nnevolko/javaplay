package main.java;

public class IntegerTest {

	public void testIntegerTest() {

		Integer i = new Integer(42);

		for (int j = 40; j < i; i--) {

			switch (i) {
			case 41:
				System.out.print("41 "); // where they breaks
			default:
				System.out.print("def ");
			case 42:
				System.out.print("42 ");
			}

			// compilation errors at line for loop
			// compilation at line switch statement
			// 41 42 ...
			// 42_ 41 def 42
			//
		}

	}
}
