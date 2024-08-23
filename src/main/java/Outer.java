public class Outer {

	// access modifier is not important here??
	static class Inner {
		static class Private {
			public String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

}
