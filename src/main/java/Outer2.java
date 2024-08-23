package main.java;

public class Outer2 {

	static class Inner {

		public class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}

	}// end of Inner

}
