package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * nnevolko
 */

public class QuickSort {

	private List<Integer> listOfItems;
	boolean isSorted = false;

	public void printList() {

		for (Integer num : listOfItems) {
			System.out.print(num + ", ");
		}
		System.out.println("\n");

	}

	public QuickSort() {
		listOfItems = new ArrayList<Integer>();
	}

	public QuickSort(List<Integer> listB) {
		listOfItems = new ArrayList<Integer>();
		listOfItems.addAll(listB);
	}

	public void add(Integer elem) {
		listOfItems.add(elem);
	}

	public void swap(int indexOne, int indexTwo) {
		Integer elem2 = listOfItems.get(indexTwo);
		listOfItems.set(indexTwo, listOfItems.get(indexOne));
		listOfItems.set(indexOne, elem2);
	}

	public void sort() {

		int n = listOfItems.size();
		// quickSort(n);
		// quickSortC(0, listOfItems.size() - 1);
		quickSort(0, listOfItems.size() - 1);
		isSorted = true;
	}

	public void quickSortC(int left, int right) {
		int index = partition(left, right);
		if (left < index - 1) {
			quickSortC(left, index - 1);
		}
		if (index < right) {
			quickSortC(index, right);
		}

	}

	public Integer partition(int left, int right) {
		int pivotIndex = (left + right) / 2;
		Integer pivot = listOfItems.get(pivotIndex);

		System.out.println("\n\nPivot index is: " + pivotIndex);
		System.out.println("Pivot is: " + pivot);

		while (left <= right) {
			while (listOfItems.get(left) < pivot) {
				left++;
			}

			while (listOfItems.get(right) > pivot) {
				right--;
			}

			if (left <= right) {
				this.printList();
				swap(left, right);
				System.out.println("lower: [" + left + ":" + listOfItems.get(left) + "], upper ["
						+ right + ":" + listOfItems.get(right) + "]");
				left++;
				right--;
				this.printList();
			}

		}
		return left;
	}

	public void quickSort(int lowIndex, int highIndex) {

		int i = lowIndex;
		int j = highIndex;
		System.out.println("lower: [" + i + ":" + listOfItems.get(i) + "], upper [" + j + ":"
				+ listOfItems.get(j) + "]");

		int pivotIndex = lowIndex + (highIndex - lowIndex) / 2;
		int pivot = listOfItems.get(pivotIndex);

		while (i <= j) {
			while (listOfItems.get(i) < pivot) {
				i++;
			}
			while (listOfItems.get(j) > pivot) {
				j--;
			}

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (lowIndex < j) {
			System.out.println("Recurse left here. ");
			quickSort(lowIndex, j);
		}
		if (i < highIndex) {
			System.out.println("Recurse right here.");
			quickSort(i, highIndex);
		}

	}
	
	
	
	
	
	
	

	public void quickSortN(int n) {
		if (n < 0) {
			return;
		}
		Integer pivotIndex = getPivot();
		System.out.println("Pivot index is: " + pivotIndex);

		if (pivotIndex > 0 && pivotIndex < listOfItems.size() - 1) {
			Integer lessElement = 0;
			Integer greaterElement = 0;
			int pivot = listOfItems.get(pivotIndex);
			System.out.println("Pivot is: " + pivot);
			int i = pivotIndex - 1;
			int j = pivotIndex + 1;
			// iterate to the start
			while (i >= 0) {
				// iterate to the end
				System.out.println("lower: [" + i + ":" + lessElement + "], upper [" + j + ":"
						+ greaterElement + "]");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (j < listOfItems.size()) {
					if (i < 0) {
						break;
					}
					lessElement = listOfItems.get(i);
					greaterElement = listOfItems.get(j);
					System.out.println("lower: [" + i + ":" + lessElement + "], upper [" + j + ":"
							+ greaterElement + "]");
					if (lessElement > pivot && greaterElement < pivot) {
						swap(i, j);
						i--;
						j++;
						this.printList();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (lessElement > pivot) {
						j++;
					} else if (greaterElement < pivot) {
						i--;
					} else {
						i--;
						j++;
					}
				}
				if (i >= 0 && j == listOfItems.size()) {
					swap(i, pivotIndex);
				}
				if (i < 0 && j == pivot + 1) {
					swap(pivotIndex, j);
				}

			}
		}
		this.printList();
		quickSortN(n--);
	}

	public Integer getPivot() {
		int rndIndex = new Random().nextInt(listOfItems.size());
		return rndIndex;
	}
}
