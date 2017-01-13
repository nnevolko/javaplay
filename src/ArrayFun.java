import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.stream.events.Characters;

public class ArrayFun {

	public String isPalindrome(String A) {

		final String result;
		// if odd check length minus one if even check half
		boolean isPalindrome = true;

		int endCounter = A.length() - 1;

		for (int i = 0; i < A.length() / 2; i++) {
			if (A.charAt(i) != A.charAt(endCounter)) {
				isPalindrome = false;
			}
			endCounter--;

		}
		if (isPalindrome) {
			result = "Yes";
		} else {
			result = "No";
		}
		return result;
	}

	public void testIsPalindrome() {

		List<String> palindromes = Arrays.asList("madam", "kayak", "anna", "random", "ankana",
				"anrrna");

		for (String temp : palindromes) {
			System.out.println(temp + ": " + isPalindrome(temp));
		}

	}
	
	public boolean isPrime(int number){
		boolean prime = true;
		for (int i =2; i<= Math.sqrt(number); i++){
			if (number % i == 0){
				prime = false;
				break;
			}
		}
		
		return prime;
		
	}

	public void testIsPrime() {

		List<Integer> integers = Arrays.asList(3, 15, 30, 45, 99, 7, 11, 25);
		for (Integer num: integers){
			System.out.println(num +" is prime: "+ isPrime(num));
		}
	}

	// two strings and are called anagrams if they consist same characters, but may be in different
	// orders.
	// So the list of anagrams of CAT is ACT, CTA and etc
	public boolean isAnagram(String word1, String word2) {
		boolean isAnagram = false;

		Map<Character, Integer> anagramLetterCountMap = new HashMap<Character, Integer>();
		if (word1.length() == word2.length()) {
			for (int i = 0; i < word1.length(); i++) {
				Character lowercaseCharacter = Character.toLowerCase(word1.charAt(i));
				if (anagramLetterCountMap.containsKey(lowercaseCharacter)) {
					int numLetters = anagramLetterCountMap.get(lowercaseCharacter);
					anagramLetterCountMap.put(lowercaseCharacter, ++numLetters);
				} else {
					anagramLetterCountMap.put(lowercaseCharacter, 1);
				}
			}

			// check if all same letters and the same number of letter exist in another word
			for (int i = 0; i < word2.length(); i++) {
				Character lowercaseCharacter2 = Character.toLowerCase(word2.charAt(i));
				if (anagramLetterCountMap.containsKey(lowercaseCharacter2)) {
					int count = anagramLetterCountMap.get(lowercaseCharacter2);
					if (count > 1) {
						count--;
						anagramLetterCountMap.put(lowercaseCharacter2, count);
					} else {
						anagramLetterCountMap.remove(lowercaseCharacter2);
					}
				} else {
					// this is not anagram, a character is missing..
					break;
				}

			}

			if (anagramLetterCountMap.size() == 0) {
				isAnagram = true;
			}

		}
		return isAnagram;
	}

	public boolean isAnagram2(String word1, String word2) {

		boolean isAnagram = false;
		char[] word1CharArray = word1.toCharArray();
		char[] word2CharArray = word2.toCharArray();

		if (word1.length() == word2.length()) {
			List<Character> word1List = new ArrayList<Character>();
			for (char c : word1CharArray) {
				word1List.add(c);
			}

			List<Character> word2List = new ArrayList<Character>();
			for (char c : word2CharArray) {
				word2List.add(c);
			}

			Collections.sort(word1List, new SortIgnoreCase());
			Collections.sort(word2List, new SortIgnoreCase());

			isAnagram = true;
			for (int i = 0; i < word1List.size(); i++) {
				if (!(word1List.get(i).equals(word2List.get(i)))) {
					Character char1Low = Character.toLowerCase(word1List.get(i));
					Character char2Low = Character.toLowerCase(word2List.get(i));
					if (char1Low != char2Low) {
						isAnagram = false;
						break;
					}
				}
			}
		}
		return isAnagram;

	}

	class SortIgnoreCase implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
			Character c1 = (Character) o1;
			Character c2 = (Character) o2;
			Character c1LowerCase = Character.toLowerCase(c1);
			Character c2LowerCase = Character.toLowerCase(c2);
			return c1LowerCase.compareTo(c2LowerCase);
		}
	}

	public void testIsAnagram() {
		boolean ret1 = isAnagram("anagram", "margana");
		System.out.println((ret1) ? "Anagrams" : "Not Anagrams");

		boolean ret2 = isAnagram("man", "mak");
		System.out.println((ret2) ? "Anagrams" : "Not Anagrams");

		boolean ret3 = isAnagram("Hello", "hello");
		System.out.println((ret3) ? "Anagrams" : "Not Anagrams");

		boolean ret4 = isAnagram("low", "owl");
		System.out.println((ret4) ? "Anagrams" : "Not Anagrams");

		boolean ret5 = isAnagram("forest", "orestf2");
		System.out.println((ret5) ? "Anagrams" : "Not Anagrams");
	}

	public void testIsAnagram2() {

		boolean ret1 = isAnagram2("cat", "act");
		System.out.println((ret1) ? "Anagrams" : "Not Anagrams");

		boolean ret2 = isAnagram2("man", "mak");
		System.out.println((ret2) ? "Anagrams" : "Not Anagrams");

		boolean ret3 = isAnagram2("Hello", "hello");
		System.out.println((ret3) ? "Anagrams" : "Not Anagrams");

		boolean ret4 = isAnagram2("low", "owl");
		System.out.println((ret4) ? "Anagrams" : "Not Anagrams");

		boolean ret5 = isAnagram2("forest", "orestf2");
		System.out.println((ret5) ? "Anagrams" : "Not Anagrams");

	}

	public void testStrings(String a, String b) {

		System.out.println(a.length() + b.length());
		System.out.println((a.compareTo(b) > 0) ? "Yes" : "No");
		System.out.println(Character.toUpperCase(a.charAt(0)) + a.substring(1) + " "
				+ Character.toUpperCase(b.charAt(0)) + b.substring(1));

	}

	public void stringCompare(String longString, int subLength) {

		String minStr = null;
		String maxStr = null;
		if (subLength > longString.length()) {
			return;
		}

		minStr = longString.substring(0, subLength);
		maxStr = longString.substring(0, subLength);
		for (int i = 1; i < longString.length(); i++) {
			if (subLength + i > longString.length()) {
				break;
			}

			String tempStr = longString.substring(i, i + subLength);
			if (tempStr.compareTo(maxStr) > 0) {
				maxStr = tempStr;
			}

			if (tempStr.compareTo(minStr) < 0) {
				minStr = tempStr;
			}

		}

		System.out.println(minStr);
		System.out.println(maxStr);
	}

	public void testStringCompare() {

		String veryLongString = "ActLikeAwesomeLifeMattersJobSEarchingYeahie";
		stringCompare(veryLongString, 3);

		String shortString = "elcometojava";
		stringCompare(shortString, 3);

	}
	
	
	public void testStringBufferString(){
		
		
		StringBuffer sb1 = new StringBuffer("hi");
		StringBuffer sb2 = new StringBuffer(sb1);
		StringBuffer sb3 = sb2;
		
		String s1 = "hi";
		String s2 = new String("hi");
		String s3 = s2;
		
		if (sb1.equals(sb2)){
			System.out.println("1 ");
		}
		if (sb2.equals(sb3)){
			System.out.println("2 ");
		}
		
		if (sb3.equals(s1)){
			System.out.println("3 ");
		}
		
		if (s1.equals(s2)){
			System.out.println("4 ");
		}
		
		if (s2.equals(s3)){
			System.out.println("5 ");
		}
	}


}
