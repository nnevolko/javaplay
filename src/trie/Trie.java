package trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Trie {

	TrieNode root;

	public Trie() {
		// special root node, use name '*'
		root = new TrieNode(null, false);
	}

	public void insert(String word) {
		insert(root, word, 0);
	}

	private void insert(TrieNode currentNode, String word, int currentIndex) {
		if (currentIndex >= word.length()) {
			return;
		}
		// System.out.println(word + " " + word.charAt(currentIndex) + " " +
		// currentNode.isLeafNode());

		if (currentNode.containsKey(word.charAt(currentIndex))) {
			TrieNode newParent = currentNode.get(word.charAt(currentIndex));
			if (currentIndex == word.length() - 1) {
				newParent.setLeafNode(true); // no longer a leaf node
			}
			insert(newParent, word, ++currentIndex);
		} else {
			boolean isLeafNode = false;
			if (currentIndex == word.length() - 1) {
				isLeafNode = true;
			}
			TrieNode newParent = currentNode.put(word.charAt(currentIndex), isLeafNode);
			insert(newParent, word, ++currentIndex);
		}

	}

	public Collection<String> findWordsByPrefix(String prefix) {
		List<String> wordsStartWithPrefix = new ArrayList<>();

		TrieNode prefixNode = locatePrefixNode(root, 0, prefix);
		if (prefixNode == null) {
			System.out.println("No such prefix"); // throw exception here
			return wordsStartWithPrefix;
		}
		List<String> prefixedWords = new ArrayList<>();
		findAllWordsFor(prefixNode, new Stack<Character>(), prefixedWords);

		for (String prefixedWord : prefixedWords) {
			wordsStartWithPrefix.add(prefix + prefixedWord.substring(1));

		}

		return wordsStartWithPrefix;
	}

	private TrieNode locatePrefixNode(TrieNode currentNode, int currentIndex, String prefix) {
		if (currentIndex == prefix.length()) {
			return currentNode;
		}
		Set<Character> letters = currentNode.getChildrenKeys();
		if (letters.contains(prefix.charAt(currentIndex))) {
			TrieNode existingNode = currentNode.get(prefix.charAt(currentIndex));
		//	System.out.println(existingNode.getLetter());
			return locatePrefixNode(existingNode, ++currentIndex, prefix);
		}
		return null;
	}

	private void findAllWordsFor(TrieNode currentNode, Stack<Character> letterStack,
			List<String> words) {

		// check if root, dont' want to push
		if (currentNode.getLetter() != null) {
			letterStack.push(currentNode.getLetter());
		}
		if (currentNode.isLeafNode()) {
			String newWord = "";
			for (Character c : letterStack) {
				newWord += c;
			}
			words.add(newWord);
		}
		// System.out.println(currentNode.getLetter() + " " + currentNode.isLeafNode());
		for (TrieNode neighbor : currentNode.getChildrenValues()) {
			findAllWordsFor(neighbor, letterStack, words);
		}
		if (currentNode.getLetter() != null) {
			letterStack.pop();
		}
	}

	/*
	 * public void findWordsByPrefix(TrieNode currentNode, int currentIndex, List<String> words,
	 * String prefix) {
	 * 
	 * if (currentIndex == prefix.length()) { if (currentNode.isLeafNode()) { words.add(prefix);
	 * String newWord = prefix;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // if this is root if (currentNode.getLetter() == null) { Set<Character> letters =
	 * currentNode.getChildrenKeys(); if (letters.contains(prefix.charAt(currentIndex))) { TrieNode
	 * existingNode = currentNode.get(prefix.charAt(currentIndex)); findWordsByPrefix(existingNode,
	 * currentIndex++, words, prefix); } else { return; } }
	 * 
	 * }
	 */

	public void printWords() {
		System.out.println("Printing Words");
		print(root, new Stack<Character>());
	}

	// Print list of words stored in a Trie
	private void print(TrieNode currentNode, Stack<Character> letterStack) {
		// check if root, dont' want to push
		if (currentNode.getLetter() != null) {
			letterStack.push(currentNode.getLetter());
		}
		if (currentNode.isLeafNode()) {
			System.out.println(letterStack.toString());
		}
		// System.out.println(currentNode.getLetter() + " " + currentNode.isLeafNode());
		for (TrieNode neighbor : currentNode.getChildrenValues()) {
			print(neighbor, letterStack);
		}
		if (currentNode.getLetter() != null) {
			letterStack.pop();
		}
	}

	public void delete(String word) {

	}

}
