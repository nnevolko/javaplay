public class ExceptionPractice {

	public void testGetProduct() {

		try {
			int result = getProduct(2, 4);
		} catch (NikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// has to be within try/catch block or declared that method throws exception
	public int getProduct(int a, int b) throws NikaException {

		if (a < 0) {
			throw new NikaException("custom message");
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
}