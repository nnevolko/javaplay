public class MinimalTree {

	public void process() {

		int[] sortedArray = { 3, 5, 7, 9, 11, 24, 33, 41, 52, 63, 71, 82, 93, 101 };
		BinarySearchTreeNode newTree = new BinarySearchTreeNode(sortedArray[0]);

		for (int i = 1; i < sortedArray.length; i++) {
			insertNode(sortedArray[i], newTree);
		}

	}

	public void insertNode(int newValue, BinarySearchTreeNode tree) {
		if (tree != null) {
			if (newValue < tree.getValue()) {
				BinarySearchTreeNode leftNode = tree.getLeft();
				if (leftNode != null && newValue < leftNode.getValue()) {
					insertNode(newValue, tree.getLeft());
				} else {
					BinarySearchTreeNode newLeftNode = new BinarySearchTreeNode(newValue);
					if (tree.getLeft() != null) {
						newLeftNode.setLeft(tree.getLeft());
					}
					tree.setLeft(newLeftNode);
					return;
				}
			} else {
				BinarySearchTreeNode rightNode = tree.getRight();
				if (rightNode != null && newValue > rightNode.getValue()) {
					insertNode(newValue, tree.getRight());
				} else {
					BinarySearchTreeNode newRightNode = new BinarySearchTreeNode(newValue);
					if (tree.getRight() != null) {
						newRightNode.setRight(tree.getRight());
					}
					tree.setRight(newRightNode);
					return;
				}

			}

		}
	}

}
