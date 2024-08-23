package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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

	public boolean isPrime(int number) {
		boolean prime = true;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				prime = false;
				break;
			}
		}

		return prime;

	}

	public void testIsPrime() {

		List<Integer> integers = Arrays.asList(3, 15, 30, 45, 99, 7, 11, 25);
		for (Integer num : integers) {
			System.out.println(num + " is prime: " + isPrime(num));
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

	public void testStringBufferString() {

		StringBuffer sb1 = new StringBuffer("hi");
		StringBuffer sb2 = new StringBuffer(sb1);
		StringBuffer sb3 = sb2;

		String s1 = "hi";
		String s2 = new String("hi");
		String s3 = s2;

		if (sb1.equals(sb2)) {
			System.out.println("1 ");
		}
		if (sb2.equals(sb3)) {
			System.out.println("2 ");
		}

		if (sb3.equals(s1)) {
			System.out.println("3 ");
		}

		if (s1.equals(s2)) {
			System.out.println("4 ");
		}

		if (s2.equals(s3)) {
			System.out.println("5 ");
		}
	}

	// a b c
	// d
	// e f g

	// a b
	// d
	// e f

	// b
	// d
	// f
	public int maxSumHourglass(int[][] arr, int size) {

		int arrayLength = 6;
		int hsums[][] = new int[arrayLength][arrayLength];
		Integer maxSum = null;
		for (int k = 0; k < arrayLength; k++) {
			for (int l = 0; l < arrayLength; l++) {
				// check for full hourglass
				if (k + 2 < arrayLength && l + 2 < arrayLength) {
					int sum = arr[k][l] + arr[k][l + 1] + arr[k][l + 2] + arr[k + 1][l + 1]
							+ +arr[k + 2][l] + arr[k + 2][l + 1] + arr[k + 2][l + 2];
					if (maxSum == null) {
						maxSum = sum;
					}
					if (sum > maxSum) {
						maxSum = sum;
					}
				}
			}
		}

		return maxSum;
	}

	public void testMaxSumHourglass() {
		/*
		 * 0 6 -7 1 6 3 -8 2 8 3 -2 7 -3 3 -6 -3 0 -6 5 0 5 -1 -5 2 6 2 8 1 3 0 8 5 0 4 -7 4
		 */
		/*
		 * int[] row1 = {0, 6, -7, 1, 6, 3}; int[] row2 = {-8, 2, 8, 3, -2, 7}; int[] row3 = {-3, 3,
		 * -6, -3, 0, -6}; int[] row4 = {5, 0, 5, -1, -5, 2}; int[] row5 = {6, 2, 8, 1, 3, 0}; int[]
		 * row6 = {8, 5, 0, 4, -7, 4};
		 */

		int[] row1 = { 0, -4, -6, 0, -7, -6 };
		int[] row2 = { -1, -2, -6, -8, -3, -1 };
		int[] row3 = { -8, -4, -2, -8, -8, -6 };
		int[] row4 = { -3, -1, -2, -5, -7, -4 };
		int[] row5 = { -3, -5, -3, -6, -6, -6 };
		int[] row6 = { -3, -6, 0, -8, -6, -7 };

		int length = 6;
		int[][] arr = new int[length][length];
		for (int i = 0; i < length; i++) {
			System.out.print("\n ");
			for (int j = 0; j < length; j++) {
				switch (i) {
				case 0:
					arr[i][j] = row1[j];
					break;
				case 1:
					arr[i][j] = row2[j];
					break;
				case 2:
					arr[i][j] = row3[j];
					break;
				case 3:
					arr[i][j] = row4[j];
					break;
				case 4:
					arr[i][j] = row5[j];
					break;
				case 5:
					arr[i][j] = row6[j];
					break;
				}
				System.out.print(", " + arr[i][j]);
			}
		}
		System.out.println("\n" + maxSumHourglass(arr, 6));
	}

	public void phoneBook(String findName) {
		Map<String, Integer> phoneBook = new HashMap<>();
		phoneBook.put("uncle sam", 99912222);
		phoneBook.put("tom", 11122222);
		phoneBook.put("harry", 12299933);

		if (phoneBook.containsKey(findName)) {
			System.out.println(findName + "=" + phoneBook.get(findName));
		} else {
			System.out.println("Not found");
		}
	}

	public void calcNegativeSubarrays() {

		// 5
		// 1 -2 4 -5 1
		List<Integer> intValues = new ArrayList<Integer>();
		intValues.add(1);
		intValues.add(-2);
		intValues.add(4);
		intValues.add(-5);
		intValues.add(1);

		int[] array = new int[intValues.size()];
		for (int i = 0; i < intValues.size(); i++) {
			array[i] = intValues.get(i); // create random number; -10^4 > value < 10^4
		}
		int numNegative = 0;
		for (int j = 0; j < intValues.size(); j++) {
			int currentSum = 0;
			for (int k = j; k < intValues.size(); k++) {
				currentSum += array[k];
				if (currentSum < 0) {
					numNegative++;
				}
			}
		}
		System.out.println(numNegative);
	}

	public void testCalcNegativeSubarrays() {
		calcNegativeSubarrays();

	}

	public void testList() {

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		List<Integer> numList = new ArrayList<>(num);
		for (int i = 0; i < num; i++) {
			Integer newValue = in.nextInt();
			numList.add(newValue);
		}
		Integer numberOfQueries = in.nextInt();
		for (int j = 0; j < numberOfQueries; j++) {
			String operation = in.next();
			if ((operation.toLowerCase()).equals("insert")) {
				int index = in.nextInt();
				int value = in.nextInt();
				numList.add(index, value);
			} else if ((operation.toLowerCase()).equals("delete")) {
				int index = in.nextInt();
				numList.remove(index);
			}
		}

		int count = 0;
		StringBuffer result = new StringBuffer();
		for (Integer intVal : numList) {
			if (count > 0) {
				result.append(" ");
			}
			result.append(intVal);
			count++;
		}
		System.out.println(result.toString());
	}

	public void createSet() {

		Set<StringPair> newPair = new HashSet<>();
		newPair.add(new StringPair("Bob", "Marci"));

	}

	// generic method
	public <T> void printArray(T[] array) {
		for (T val : array) {
			System.out.println(val.toString());
		}
	}

	
	
	public void testSet(){
		
		Set<String> newSet = new HashSet<>();
		String[] names = {"Bob", "Kat", "Billy", "Kat"};
	    /* If this set already contains the element, the call leaves the set
	     * unchanged and returns <tt>false</tt>.  In combination with the
	     * restriction on constructors, this ensures that sets never contain
	     * duplicate elements.*/

		for (int i = 0; i<names.length; i++){
			if (newSet.add(names[i])){
				System.out.println("added: " + names[i]);
			} else {
				System.out.println("duplicate: " + names[i]);
			}
		}
		String[] names2 = {"July", "Meg"};
		Set<String> otherNames = new HashSet<>(Arrays.asList(names2));

		Set<String> union = new HashSet<>(newSet);
		union.addAll(otherNames);
		System.out.println(union.toString());
	}
	
	public List<Integer> mergeSortedArrays(List<Integer> list1, List<Integer> list2){
		List<Integer> mergedList = new ArrayList<>();
		
		int list1Index = 0;
		int list2Index = 0;
		for (int i = 0; i< list1.size() + list2.size(); i++){
			
			// check that we didn't reach the end of the list
			if (list1Index < list1.size() ){
				if (list1.get(list1Index)<= list2.get(list2Index)){
					mergedList.add(list1.get(list1Index));
					list1Index++;
				} else {
					if (list2Index < list2.size()){
						mergedList.add(list2.get(list2Index));
						list2Index++;
					}
					else {
						mergedList.add(list1.get(list1Index));
						list1Index++;
					}
				}
			} else {
				mergedList.add(list2.get(list2Index));
				list2Index++;				
			}
		}
		
		return mergedList;
	}
	
	public void testSortedArrayMerge(){
		
		List<Integer> list1 = Arrays.asList(4,6,9,30,88, 99);
		List<Integer> list2 = Arrays.asList(2,8,44, 88,92, 102 );
		List<Integer> resultingList = mergeSortedArrays(list1, list2);
		
		resultingList.forEach(System.out::println);

		
	}
	
	public void testMap(){
		
		Map<String, Integer> nameAgePairs = new HashMap<>();
		String[] names = {"Bob", "Kat", "Billy", "Kat"};
		Integer[] ages = {10, 20, 30, 20};
		
/*
 * If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.
 */
		for (int i = 0; i<names.length; i++){
			Integer k = nameAgePairs.put(names[i], ages[i]);
			System.out.println("added: " + names[i]);
			
		}
	}
}
