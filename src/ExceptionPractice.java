/*
 * nnevolko
 */

public class ExceptionPractice {

	public void testGetProduct() {

		try {
			int result = getProduct(2, 4);
		} catch (PracticeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// has to be within try/catch block or declared that method throws exception
	public int getProduct(int a, int b) throws PracticeException {

		if (a < 0) {
			throw new PracticeException("custom message");
		}
		return a * b;
	}

	// unchecked exception don't need to try/catch or delcare that method throws it
	public int getProduct2(int a, int b) {

		if (a < 0) {
			throw new RuntimeException();
		}
		return a * b;
	}

	// catch parsing exception, divide by zero exception, overwrite one of the exceptions.
	public void testDifferent(String xInput, String yInput) {
		try {
			int x = Integer.parseInt(xInput);
			int y = Integer.parseInt(yInput);
			System.out.println(x / y);

		} catch (java.lang.NumberFormatException e) {
			System.out.println("java.util.InputMismatchException");
		} catch (java.lang.ArithmeticException ae) {
			System.out.println(ae);
		}

	}

	class MyCalculator {
		
		public int power(int n, int p) throws Exception {
			int result = 0;
			if (n < 0 || p < 0) {
				throw new java.lang.Exception("n and p should be non-negative");
			}
			result = (int) Math.pow(n, p);
			return result;
		}
		
	}

	public void testPower(int n, int p) {

		MyCalculator my_calculator = new MyCalculator();
		try {
			System.out.println(my_calculator.power(n, p));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
