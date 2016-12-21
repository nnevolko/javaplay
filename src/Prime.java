import java.io.InputStreamReader;
/*
 * nnevolko
 */

public class Prime {

	public void checkPrime(Integer... vars) {

		StringBuffer primeString = new StringBuffer();
		int counter = 0;
		for (Integer var : vars) {
			int sqroot = (int) Math.sqrt(var);
			boolean isPrime = true;
			for (int i = 2; i <= sqroot; i++) {
				if (var % i == 0) {
					isPrime = false;
				}
			}
			if (var == 1) {
				isPrime = false;
			}
			if (isPrime) {
				if (counter > 0) {
					primeString.append(" ");
				}
				primeString.append(var);
				counter++;
			}			
		}
		if (primeString.toString().isEmpty()) {
			System.out.println("");
		} else {
			System.out.println(primeString.toString());
		}

	}

	public void primeTest() {

		/*
		 * 1 2 3 4 5
		 * 
		 * ob.checkPrime(n1); ob.checkPrime(n1,n2); ob.checkPrime(n1,n2,n3);
		 * ob.checkPrime(n1,n2,n3,n4,n5);
		 */

		checkPrime(1);
		checkPrime(1, 2);
		checkPrime(1, 2, 3);
		checkPrime(1, 2, 3, 4, 5);

	}

}
