import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {

	int[][] matrix;

	public RotateMatrix(int dimension) {
		matrix = new int[dimension][dimension];
	}

	public void initialize() {
		int counter = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = counter++;
			}
		}
	}

	public void printMatrix() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "|");
			}
			System.out.print("\n");
		}

		System.out.print("\n");
	}

	public void rorateNinetyDegrees() {

		for (int i = 0; i < matrix.length / 2; i++) {
			List<Integer> saveList = null;
			if (i == 0) {
				// safe left column
				saveList = new ArrayList<Integer>();
				for (int j = matrix.length - 1; j >= 0; j--) {
					saveList.add(matrix[j][0]);
				}
				// move top to left column
				// colIndex becomes rowIndex flipped
				int leftCornerIndex = matrix.length - 1;
				for (int topIndex = 0; topIndex < matrix.length; topIndex++) {
					matrix[leftCornerIndex][i] = matrix[i][topIndex];
					leftCornerIndex--;

				}
				// move right column to top
				// colIndex -> rowIndex
				int rightCorner = matrix.length - 1;
				for (int k = 0; k < matrix.length; k++) {
					matrix[i][k] = matrix[k][rightCorner];
				}
				// move bottom to right
				// rowIndex rotates to colIndex flipped
				int rightCornerIndex = 0;
				int bottomRow = matrix.length - 1;
				rightCorner = matrix.length - 1;
				for (int k = matrix.length - 1; k >= 0; k--) {
					matrix[rightCornerIndex][rightCorner] = matrix[bottomRow][k];
					rightCornerIndex++;
				}

				bottomRow = matrix.length - 1;
				leftCornerIndex = matrix.length - 1;
				for (int bottomIndex = 0; bottomIndex < matrix.length; bottomIndex++) {
					matrix[bottomRow][bottomIndex] = saveList.get(leftCornerIndex--);
				}

			}

		}

	}

	public void rorateNinetyDegrees2() {

		int endBoundary = matrix.length;

		for (int startBoundary = 0; startBoundary < matrix.length / 2; startBoundary++) {
			List<Integer> saveList = null;

			// safe left column
			saveList = new ArrayList<Integer>();
			for (int j = endBoundary - 1; j >= startBoundary; j--) {
				saveList.add(matrix[j][startBoundary]);
			}
			// move top to left column
			// colIndex becomes rowIndex flipped
			int leftCornerIndex = endBoundary - 1;
			for (int topIndex = startBoundary; topIndex < endBoundary; topIndex++) {
				matrix[leftCornerIndex][startBoundary] = matrix[startBoundary][topIndex];
				leftCornerIndex--;

			}
			// move right column to top
			// colIndex -> rowIndex
			int rightCorner = endBoundary - 1;
			for (int k = startBoundary; k < endBoundary; k++) {
				matrix[startBoundary][k] = matrix[k][rightCorner];
			}
			// move bottom to right
			// rowIndex rotates to colIndex flipped
			int rightCornerIndex = startBoundary;
			int bottomRow = endBoundary - 1;
			rightCorner = endBoundary - 1;
			for (int k = endBoundary - 1; k >= startBoundary; k--) {
				matrix[rightCornerIndex][rightCorner] = matrix[bottomRow][k];
				rightCornerIndex++;
			}

			bottomRow = endBoundary - 1;
			leftCornerIndex = saveList.size()-1;
			for (int bottomIndex = startBoundary; bottomIndex < endBoundary; bottomIndex++) {
				matrix[bottomRow][bottomIndex] = saveList.get(leftCornerIndex--);
			}

			endBoundary = endBoundary - 1;

		}

	}

}
