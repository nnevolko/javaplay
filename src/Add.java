public class Add {
	/*
	 * nnevolko
	 */

	public void add(Integer... integers) {
		if (integers.length < 2) {
			return;
		}
		Integer sum = 0;
		StringBuffer outputSoFar = new StringBuffer();
		int counter = 0;
		for (Integer var : integers) {
			if (counter > 0) {
				outputSoFar.append("+");
			}
			outputSoFar.append(var);
			counter++;
			sum += var;
		}
		System.out.println(outputSoFar.toString() + "=" + sum);
	}

	public void checkAdd() {
		add(1);
		add(2, 3, 4, 5);
		add(3, 4);
	}
}
