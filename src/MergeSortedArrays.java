import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
 * nnevolko
 */

public class MergeSortedArrays {

	public ArrayList<Integer> arrayA;
	public ArrayList<Integer> arrayB;
	public Integer totalSize;

	public MergeSortedArrays(List<Integer> listA, List<Integer> listB) {
		arrayA = new ArrayList<Integer>();
		arrayB = new ArrayList<Integer>();
		this.arrayA.addAll(listA);
		this.arrayB.addAll(listB);
		totalSize = listA.size() + listB.size();
		for (int i = listA.size(); i < totalSize; i++) {
			arrayA.add(i, -1);
		}
	}

	public void printA() {
		System.out.println(arrayA.toString());
	}

	public void printB() {
		System.out.println(arrayB.toString());
	}

	public void merge() {

		int k = arrayA.size() - 1;
		while (arrayA.get(k) == -1) {
			k--;
		}
		int oldARight = k;

		// if array B elements start greater than array A elelemnts // copy over and done
		/*
		 * if (arrayB.get(0) > arrayA.get(arrayA.size() - 1)) { arrayA.addAll(arrayB); return; }
		 */

		int arrayBEnd = arrayB.size() - 1;
		System.out.println("Old A right" + oldARight);

		int correctPosition = arrayA.size() - 1;
		System.out.println("Correct position: " + correctPosition);
		for (int z = arrayBEnd; z >= 0; z--) {
			// passed number is the larger number
			Integer elementToCompare = arrayB.get(z);
			System.out.println("\nlooking at : " + elementToCompare);

			int newMaxIndex = findMaxInA(oldARight, elementToCompare, correctPosition);

			while (newMaxIndex != -1) {
				// continue moving till we find a smaller number
				moveAElement(newMaxIndex, correctPosition);
				correctPosition--;
				newMaxIndex = findMaxInA(oldARight, elementToCompare, correctPosition);
			}

			if (newMaxIndex == -1) {
				addBElement(elementToCompare, correctPosition);
				correctPosition--;
			}
			this.printA();

		}

	}

	public void moveAElement(int newMaxIndex, int correctIndex) {
		Integer elementToMove = arrayA.get(newMaxIndex);
		arrayA.set(correctIndex, elementToMove);
		arrayA.set(newMaxIndex, -1);
		System.out.println("Moving A Element: " + elementToMove + ", to : " + correctIndex);

	}

	public void addBElement(Integer element, int rightFill) {
		arrayA.set(rightFill, element);
		System.out.println("\nAdding b element " + element + ", position: " + rightFill);
	}

	// return -1 if not found
	public int findMaxInA(int oldRight, Integer element, int rightEndIndex) {
		int result = -1;
		if (oldRight > rightEndIndex) {
			oldRight = rightEndIndex;
		}
		for (int i = oldRight; i >= 0; i--) {
			if (arrayA.get(i) > element) {
				result = i;
				break;
			}
		}

		System.out.println("New index is: " + result + ", looking for : " + element);
		return result;
	}

}
