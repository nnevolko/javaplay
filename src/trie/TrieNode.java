package trie;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrieNode {

	private Character letter;
	private boolean isLeafNode;
	Map<Character, TrieNode> children = new HashMap<>();

	public TrieNode(Character letter) {
		this.letter = letter;
		isLeafNode = false;
	}

	public TrieNode(Character letter, boolean isLeafNode) {
		this.letter = letter;
		this.isLeafNode = isLeafNode;
	}

	public boolean containsKey(char c) {
		return children.containsKey(c);
	}

	public TrieNode get(char c) {
		return children.get(c);
	}

	public TrieNode put(char c, boolean isLeafNode) {
		TrieNode newNode = new TrieNode(c, isLeafNode);
		children.put(c, newNode);
		return newNode;
	}

	public Character getLetter() {
		return letter;
	}

	public boolean isLeafNode() {
		return isLeafNode;
	}

	public void setLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public Collection<TrieNode> getChildrenValues() {
		return children.values();
	}

	public Set<Character> getChildrenKeys() {
		return children.keySet();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letter == null) ? 0 : letter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrieNode other = (TrieNode) obj;
		if (letter == null) {
			if (other.letter != null)
				return false;
		} else if (!letter.equals(other.letter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TrieNode [letter=");
		builder.append(letter);
		builder.append(", isLeafNode=");
		builder.append(isLeafNode);
		builder.append("]");
		return builder.toString();
	}

}
