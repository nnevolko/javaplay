/*
 * nnevolko
 */
public class BinarySearchTreeNode {

	private int value;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	

	public BinarySearchTreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" [value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
	

}
