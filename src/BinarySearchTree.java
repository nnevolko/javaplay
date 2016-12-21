public class BinarySearchTree {

	BinarySearchTreeNode root;

	enum DIRECTION{
		RIGHT, LEFT;
	}
	public void insert(int newValue) {
		BinarySearchTreeNode newNode = new BinarySearchTreeNode(newValue);
		BinarySearchTreeNode current = root;
		BinarySearchTreeNode parent = root;
		if (parent == null) {
			root = newNode;
			return;
		}

		while (true) {
			parent = current;
			if (newValue < current.getValue()) {
				System.out.print(current.getValue() +"|");
				current = current.getLeft();				
				if (current == null) {
					parent.setLeft(newNode);
					return;
				}
			} else {
				System.out.print(current.getValue() +"|");
				current = current.getRight();
				if (current == null) {
					parent.setRight(newNode);
					return;
				}
			}
		}

	}

	public BinarySearchTreeNode find(int keyValue) {

		BinarySearchTreeNode current = root;
		if (current == null){
			return null;
		}
		while (keyValue != current.getValue()) {
			System.out.print(current.getValue() +"|");
			if (keyValue < current.getValue()) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
			if (current == null) {
				return null;
			}
		}
		System.out.println("\n");

		return current;
	}

	public BinarySearchTreeNode delete(int keyValue) {

		BinarySearchTreeNode current = root;
		BinarySearchTreeNode parent = root;

		while (true) {
			parent = current;
			if (keyValue < current.getValue()) {
				current = current.getLeft();
				if (current == null) {
					return null;
				}
				if (keyValue == current.getValue()) {
					System.out.print(keyValue);
					if (isLeaf(current)) {
						parent.setLeft(null);
						return current;
					} else if (hasLeftChildOnly(current)) {
						parent.setLeft(current.getLeft());
						return current;
					} else if (hasRightChildOnly(current)) {
						parent.setRight(current.getRight());
						return current;
					} else {
						DIRECTION direction = DIRECTION.LEFT;
						return removeNodeAndPromote(parent, current, direction);	
					}
				}
			} else {
				current = current.getRight();
				if (current == null) {
					return null;
				}
				if (keyValue == current.getValue()) {
					System.out.print(keyValue);
					if (isLeaf(current)) {
						parent.setRight(null);
						return current;
					} else if (hasLeftChildOnly(current)) {
						parent.setLeft(current.getLeft());
						return current;
					} else if (hasRightChildOnly(current)) {
						parent.setRight(current.getRight());
						return current;
					} else {
						DIRECTION direction = DIRECTION.RIGHT;
						return removeNodeAndPromote(parent, current, direction);	
					}
				}
			}

		}
	}

	public boolean isLeaf(BinarySearchTreeNode current) {
		boolean result = false;
		if (current.getLeft() == null && current.getRight() == null) {
			result = true;
		}
		return result;
	}

	public boolean hasRightChildOnly(BinarySearchTreeNode current) {
		return current.getLeft() == null && current.getRight() != null;
	}

	public boolean hasLeftChildOnly(BinarySearchTreeNode current) {
		return current.getRight() == null && current.getLeft() != null;
	}
	
	public BinarySearchTreeNode removeNodeAndPromote(BinarySearchTreeNode parent, BinarySearchTreeNode current, DIRECTION direction){
		
		if (direction == DIRECTION.LEFT){	
			// right node will now be placed instead of the current node.
			parent.setLeft(current.getRight());
		} else {
			parent.setRight(current.getRight());
		}
		
		//save a reference to the left sub tree
		BinarySearchTreeNode leftSubTree = current.getLeft();
		// traverse right sub tree to find the smallest node.
		BinarySearchTreeNode newParent = current.getRight();
		while (true){
			newParent = current;
			current = current.getLeft();
			if (current == null){
				newParent.setLeft(leftSubTree);
				break;
			}
			
		}
		current.setLeft(null);
		current.setRight(null);
		return current;		
	}

}
