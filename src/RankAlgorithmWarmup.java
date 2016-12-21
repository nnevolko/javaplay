import java.util.ArrayList;
import java.util.List;

/*
 * nnevolko
 */

public class RankAlgorithmWarmup {

	public void calculate(int[] numbers, int size) {

		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;

		for (int num : numbers) {
			if (num > 0) {
				positiveCount++;
			} else if (num < 0) {
				negativeCount++;
			} else {
				zeroCount++;
			}
		}
		float positiveFraction;
		float negativeFraction;
		float zeroFraction;
		if (size != 0) {
			positiveFraction = positiveCount / (float) size;
			negativeFraction = negativeCount / (float) size;
			zeroFraction = zeroCount / (float) size;

			System.out.println(positiveFraction);
			System.out.println(negativeFraction);
			System.out.println(zeroFraction);
		}
	}

	public void testCircularArray1() {

		/*
		 * 3 2 3 1 2 3 0 1 2
		 */

		int n = 3;// number of elements in the array
		int k = 2; // number of rotations
		int q = 3; // number of queries

		int[] rotatedArray = new int[n];

		rotatedArray[0] = 1;
		rotatedArray[1] = 2;
		rotatedArray[2] = 3;

		// query positions
		int m1 = 0;
		int m2 = 1;
		int m3 = 2;

		int[] originalArray = new int[n];

		int j = 0;
		for (int i = k; i < n; i++) {
			originalArray[j] = rotatedArray[i];
			j++;

		}
		for (int i = 0; i < k; i++) {
			originalArray[j] = rotatedArray[i];
			j++;
		}

		for (int i : originalArray) {
			System.out.println(i);
		}
	}

	public void testCircularArray22() {

		/*
		 * 3 2 3 1 2 3 0 1 2
		 */

		int n = 3;// number of elements in the array
		int k = 2; // number of rotations
		int q = 3; // number of queries

		int[] originalArray = new int[n];

		originalArray[0] = 1;
		originalArray[1] = 2;
		originalArray[2] = 3;

		// query positions
		int m1 = 0;
		int m2 = 1;
		int m3 = 2;

		int[] rotated = new int[n];
		if (k > n) {
			k = k % n;
		}

		int j = 0;
		for (int i = n - k - 1;; i++) {
			rotated[j] = originalArray[i];
			j++;
		}

		/*
		 * for (int i = n - k; i < n; i++) { rotated[j] = originalArray[i]; j++;
		 * 
		 * } for (int i = 0; i < k; i++) { rotated[j] = originalArray[i]; j++; }
		 */

	}

	public void printCircularRotation() {

		/*
		 * 3 2 3 1 2 3 0 1 2
		 */

		int n = 3;// number of elements in the array
		int k = 2; // number of rotations
		int q = 3; // number of queries

		int[] originalArray = new int[n];

		originalArray[0] = 1;
		originalArray[1] = 2;
		originalArray[2] = 3;

		// query positions
		int m1 = 0;
		int m2 = 1;
		int m3 = 2;
		int[] mArray = new int[3];

		mArray[0] = 0;
		mArray[1] = 1;
		mArray[2] = 2;

		int newIndex = 0;
		for (int m : mArray) {
			k = k%n;
			newIndex = m - k;
			if (newIndex < 0) {
				newIndex = n + newIndex;
			}
			System.out.println(originalArray[newIndex]);
		}

	}

	public void convertStandardToMilitary(String time) {

		String hourStr = time.substring(0, 2);
		String minStr = time.substring(3, 5);
		String secStr = time.substring(6, 8);
		String partOfDay = time.substring(8, 10);

		int hour = Integer.parseInt(hourStr);
		int minute = Integer.parseInt(minStr);
		int second = Integer.parseInt(secStr);

		if (hour == 12) {
			if ((partOfDay.toLowerCase()).equals("am")) {
				hour = 0;
			}
		}

		if ((partOfDay.toLowerCase()).equals("pm")) {
			if (hour != 12) {
				hour += 12;
			}
		}

		System.out.printf("%02d:%02d:%02d\n", hour, minute, second);

	}

	public void testConvertStandardToMilitary() {

		String sampleTime1 = "12:05:30PM";
		String sampleTime2 = "07:05:45PM";
		String sampleTime3 = "07:05:45AM";
		String sampleTime5 = "12:05:30AM";
		convertStandardToMilitary(sampleTime1);
		convertStandardToMilitary(sampleTime2);
		convertStandardToMilitary(sampleTime3);
		convertStandardToMilitary(sampleTime5);

	}

	public void printStaircase(int n) {
		int blankCount = n - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < blankCount) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			blankCount--;
			System.out.print("\n");
		}
	}

	public void testStaircase() {

		printStaircase(4);
		System.out.print("\n");
		printStaircase(6);

	}

	public void testCalculate() {

		// 6
		// -4 3 -9 0 4 1

		int[] newArray = new int[6];
		newArray[0] = -4;
		newArray[1] = 3;
		newArray[2] = -9;
		newArray[3] = 0;
		newArray[4] = 4;
		newArray[5] = 5;

		calculate(newArray, newArray.length);
	}
}
