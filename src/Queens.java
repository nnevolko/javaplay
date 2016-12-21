public class Queens {

	private Integer[][] board = new Integer[8][8];

	/*
	 * int rows = matrix.length; int cols = matrix[0].length; // assuming rows
	 * >= 1
	 */
	public boolean isSafe(int x, int y) {
		// check horizontal
		for (int j = 0; j < board[x].length; j++) {
			if (board[x][j] == 1) {
				return false;
			}
		}
		// check vertical
		for (int k = 0; k < board.length; k++) {
			if (board[x][k] == 1) {
				return false;
			}
		}
		// check diagonal
		for (int b = x, c = y; b >= 0 && c >= 0; b--, c--) {
			if (board[b][c] == 1) {
				return false;
			}
		}
		for (int b = x, c = y; b < board.length && c < board[x].length; b++, c++) {
			if (board[b][c] == 1) {
				return false;
			}
		}
		return true;
	}

	public void initializeMatrix() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
	}

	public void printMatrix() {
		for (int i = 0; i < board.length; i++) {
			System.out.print("|");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.print("\n");
		}
	}

	public void playQueens(int numberOfQueens) {

		initializeMatrix();
		if (numberOfQueens > 0) {
			boolean result = calculateQueens(0, 0, 0, 4);
			if (result) {
				printMatrix();
			}
		}

	}

	public boolean calculateQueens(int row, int col, int numberOfQueensPlaced, int numberOfQueens) {
		if (numberOfQueensPlaced == numberOfQueens) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			if (isSafe(i, col)) {
				board[i][col] = 1;
				if (calculateQueens(i, col + 1, numberOfQueensPlaced + 1, numberOfQueens)) {
					return true;
				}
				// backtrack
				board[i][col] = 0;
			}
		}
		return false;
	}

}
