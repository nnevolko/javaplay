	/*
	 * nnevolko
	 */

public class PowerOf2 {

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

	//http://stackoverflow.com/questions/1801718/why-can-outer-java-classes-access-inner-class-private-members
		
	public void testNumber(Integer num) {

	//	Object o = new PowerOf2.Inner().new Private();
		Object o = new Inner().new Private();
		String result = ((PowerOf2.Inner.Private) o).powerof2(num);			
		System.out.println( num + " is " + result);
	}

}
