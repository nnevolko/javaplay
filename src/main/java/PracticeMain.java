import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import trie.Trie;

public class PracticeMain {
	
	
	public static int balance = 0;

	public static final String EXAMPLE_TEST = "This is my small example "
			+ "string which I'm going to " + "use for pattern matching.";

	public static void main(String[] args) {

		// runQuickSort();

		// runBinarySearchTreeTests();

		// Add add = new Add();
		// add.checkAdd();

		// Prime prime = new Prime();
		// prime.primeTest();

		/*
		 * Singleton s = Singleton.getSingleInstance(); s.str = "new string";
		 * 
		 * Singleton s2 = Singleton.getSingleInstance(); System.out.println(s2.str);
		 */

		// ReflectStudent rs = new ReflectStudent();
		// rs.reflectOnSTudent();
		//
		// PowerOf2 po2 = new PowerOf2();
		// po2.testNumber(8);
		// Object o = new PowerOf2.Inner();
		// Object o2 = po2.Inner();

		// MatrixDifference md = new MatrixDifference();
		// md.calculateDiagonalDifference();

		// RankAlgorithmWarmup raw = new RankAlgorithmWarmup();
		// raw.testCalculate();
		// raw.testStaircase();
		// raw.testConvertStandardToMilitary();
		// raw.printCircularRotation();

		// RankOOP oop = new RankOOP();
		// oop.testDivisorSum();

		// FamilyMember fm = new FamilyMember();
		// fm.testFamilyMember();

		/*
		 * Java8Play jp = new Java8Play(); jp.testMathJava7(); jp.testMathJava8();
		 * jp.testMathOther1(); jp.testMathOther2(); jp.testClasses();
		 */

		// https://jlordiales.me/2012/12/13/the-builder-pattern-in-practice/
		// User newUser = new User.UserBuilder("Jhon", "Doe").age(30).phone("1234567")
		// .address("Fake address 1234").build();
		//

		// Outer.Inner.Private p = new Outer.Inner.Private();
		// Outer2.Inner.Private p2 = new Outer2.Inner().new Private();

		// testRobotInAGrid();

		// http://javahungry.blogspot.com/2013/08/difference-between-comparable-and.html
		/*
		 * List<Employee> employees = new ArrayList<Employee>(); for (int i = 222000300; i < 30;
		 * i++) { Employee newEmployee = new Employee(i, "firstName" + i, "lastName" + i);
		 * employees.add(newEmployee); }
		 * 
		 * Collections.sort(employees, new Comparator<Employee>() {
		 * 
		 * @Override public int compare(Employee e1, Employee e2) { int value1 =
		 * e1.getLastName().compareTo(e1.getLastName()); if (value1 == 0) { return
		 * e2.getFirstName().compareTo(e2.getFirstName()); } else { return value1; }
		 * 
		 * } });
		 * 
		 * for (Employee e : employees) { System.out.println(e); }
		 * 
		 * // example of Comparator Interface..
		 * 
		 * // hashset is unordered set Set<Customer> customers = new HashSet<Customer>();
		 * customers.add(new Customer(44400202, "Who", "Is")); customers.add(new Customer(44400200,
		 * "Bob", "Dillan")); customers.add(new Customer(44400201, "Kurt", "Cobain"));
		 * customers.add(new Customer(44400203, "Marie", "Cobain")); customers.add(new
		 * Customer(44400104, "Woaaa", "Is"));
		 * 
		 * // tree set is ordered set Set<Customer> sortedCustomers = new TreeSet<Customer>();
		 * sortedCustomers.addAll(customers); for (Customer customer : sortedCustomers) {
		 * System.out.println(customer); }
		 */

		// Queens algorithm, using method "backtracking"
		/*
		 * Queens q = new Queens(); q.playQueens(4);
		 */
		/*
		 * 
		 * System.out.println(EXAMPLE_TEST.matches("\\w.*")); System.out.println("\n example 2:");
		 * String[] splitString = (EXAMPLE_TEST.split("\\s+"));
		 * System.out.println(splitString.length);// should be 14 for (String string : splitString)
		 * { System.out.println(string); } // replace all whitespace with tabs
		 * System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
		 */

		// Chapter 1. problem 8
		/*
		 * RotateMatrix newMatrix = new RotateMatrix(6); newMatrix.initialize();
		 * newMatrix.printMatrix(); newMatrix.rorateNinetyDegrees2(); newMatrix.printMatrix();
		 */
		/**
		 * 
		 * 
		 1|2|3|4| 5|6|7|8| 9|10|11|12| 13|14|15|16|
		 * 
		 * 4|8|12|16| 3|6|7|15| 2|10|11|14| 1|5|9|13|
		 */

		/*
		 * 10.1 List<Integer> listA= new ArrayList<Integer>(Arrays.asList(2,3,5,9,10));
		 * List<Integer> listB = new ArrayList<Integer>(Arrays.asList(1,6,7,23,50));
		 * 
		 * MergeSortedArrays msa= new MergeSortedArrays(listA, listB); msa.printA(); msa.printB();
		 * msa.merge(); msa.printA();
		 */

		// Implement Binary Search --- implement..
		/*
		 * List<Fruit> fruitList = new ArrayList<Fruit>();
		 * 
		 * 
		 * fruitList.add(new Fruit("Pineapple", "Pineapple description",70)); fruitList.add(new
		 * Fruit("Apple", "Apple description",100)); fruitList.add(new Fruit("Orange",
		 * "Orange description",80)); fruitList.add(new Fruit("Banana", "Banana description",90));
		 * 
		 * Collections.sort(fruitList);
		 * 
		 * int i=0; for(Fruit temp: fruitList){ System.out.println("fruits " + ++i + " : " +
		 * temp.getFruitName() + ", Quantity : " + temp.getQuantity()); }
		 * 
		 * BinarySearch bs = new BinarySearch(fruitList); String fruitToCompare = "Apple"; Fruit f =
		 * bs.searchFruit(fruitToCompare);
		 * 
		 * String fruitToCompare2 = "Kiwi"; Fruit f2 = bs.searchFruit(fruitToCompare2);
		 */

		/*
		 * for (int i =8; i< 300; i=i+50){ formatCheck("Anna"+i, i); }
		 */

		// testArrayFun();
		// testRegexFun();
		// testTrie();

		// testArrayFun();

		// onyxTests();

		// ObjectFun of = new ObjectFun();
		// of.testPlayerCompare();

		// ParenthesisStack ps = new ParenthesisStack();
		// ps.testBalanced();

		GenericsFun gf = new GenericsFun();
		gf.testIsEqual();
		
		//testCalculateBalance();
		//testArrayFun();
		
		//testRegexFun();
		
		//testArrayFun();
		
		//Cake whiteCake = new Cake.Builder().sugar(1).butter(0.5). eggs(2).vanila(2).flour(1.5). bakingpowder(0.75).milk(0.5).build();
	    
		//Cake blackForestCake = new Cake.Builder().bakingpowder(1.5).bakingsoda(.75).eggs(3).salt(0.75).build();// etc
        //Cake is ready to eat :)
       // System.out.println(whiteCake);
        
        //testPlusMinus();
        
        //testMinMaxSum();
		//testEvenNumbers();
		
		//testQueryForStrings();
		testDiagonalDifference();
        

	}
	
	public static void testDiagonalDifference() {
		
		
		DiagonalDifference dd = new DiagonalDifference();
		List<Integer> row1 = new ArrayList<Integer>();
		row1 = Stream.of(11,2,4).collect(Collectors.toList());
		List<Integer> row2 = new ArrayList<Integer>();
		row2 = Stream.of(4,5,6).collect(Collectors.toList());
		List<Integer> row3 = new ArrayList<Integer>();
		row3 = Stream.of(10,8,-12).collect(Collectors.toList());
		
		List<List<Integer>> listOfLists = new ArrayList<>();
		listOfLists.add(row1);
		listOfLists.add(row2);
		listOfLists.add(row3);
		
		int result = dd.calculateAbsoluteDiagonalDifference(listOfLists);
		
		System.out.println(result);
	}
	
	public static void testQueryForStrings() {
		
		QueryForStrings qfs= new QueryForStrings();
		List<String> strings = new ArrayList<String>();
		strings = Stream.of("aba", "baba","aba","xzxb").collect(Collectors.toList());
		List<String> queries = new ArrayList<String>();
		queries = Stream.of("aba","xzxb","ab").collect(Collectors.toList());
		List<Integer> numOfOccurances = qfs.matchStrings(strings, queries);
		
		System.out.println(numOfOccurances.toString());
		
	}
	
	public static void testEvenNumbers() {
		
		EvenNumbers en = new EvenNumbers();
		en.printEvenNumbers(0, 100);
	}
	

	public static void testMinMaxSum() {
		
		MinMaxSum mms = new MinMaxSum();
		int[] intArray = new int[] {1,3,5,7,9};
		int[] intArray2 = new int[] {1,2,3,4,5};
		

        Integer[] arr = Arrays.stream( intArray ).boxed().toArray( Integer[]::new );
        List<Integer> intList = Arrays.asList(arr);
		mms.miniMaxSum(intList);
		
		Integer[] arr2 = Arrays.stream( intArray2 ).boxed().toArray( Integer[]::new );
        List<Integer> intList2 = Arrays.asList(arr2);
		mms.miniMaxSum(intList2);
		
	}
	public static void testPlusMinus() {
		PlusMinus pm = new PlusMinus();
		
		int[] intArray = new int[] {1,1, 0, -1, -1};
		

        Integer[] arr = Arrays.stream( intArray ).boxed().toArray( Integer[]::new );
        List<Integer> intList = Arrays.asList(arr);
        
        
        int[] intArray2 = new int[] {-4, 3, -9, 0, 4, 1};
        List<Integer> intList2 = Arrays.stream(intArray2).boxed().collect(Collectors.toList());
 
        System.out.println("______________");
		pm.plusMinus(intList);
		System.out.println("______________");
		pm.plusMinus(intList2);
		System.out.println("______________");
		
		
	}
	
	public static void testCalculateBalance (){
		int[] credits = {250, 250};
		int[] debits ={500};
		int result = calculateBalance (5000, credits, debits );
		System.out.println( result == 5000);
	}
	
	public static int calculateBalance(int currentBalance, int[]credits, int []debits){
		
		balance = currentBalance;
		for (int i =0 ;i<credits.length; i++){
			currentBalance +=credits[i];
		}
		for (int i = 0; i<debits.length; i++){
			currentBalance-= debits[i];
		}
		
		//return currentBalance;
		balance = currentBalance;
		return balance;
	}

	public static void testBitSets() {
		/*
		 * 
		5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1
		 */

        Scanner sc = new Scanner(System.in);
       int size = sc.nextInt();
       BitSet b1set = new BitSet(size);
       BitSet b2set = new BitSet(size);
       
       for (int j = 0; j< size; j++){
          	b1set.set(j, false);
	        b2set.set(j, false);
       }
       
      	int numberOfQuestions = sc.nextInt();
		for (int i = 0; i < numberOfQuestions; i++) {
			String operation = sc.next();
			if ((operation.toUpperCase()).equals("AND") || (operation.toUpperCase()).equals("OR")
					|| (operation.toUpperCase()).equals("XOR")) {
				BitSet source;
				BitSet destination;
				int value1 = sc.nextInt();
				int value2 = sc.nextInt();
				if (value1 == 2 && value2 == 1) {
					destination = b2set;
					source = b1set;
				} else {
					destination = b1set;
					source = b2set;
				}
				if ((operation.toUpperCase()).equals("AND")) {
					destination.and(source);
				} else if ((operation.toUpperCase()).equals("OR")) {
					destination.or(source);
				} else if (operation.toUpperCase().equals("XOR")) {
					destination.xor(source);
				}

			} else if ((operation.toUpperCase()).equals("FLIP")  ||          
                     (operation.toUpperCase()).equals("SET")) {
               BitSet destination;
               int set = sc.nextInt();
				int index = sc.nextInt();
				if (set == 1 ) {
					destination = b1set;
				} else {
					destination = b2set;
				}
               
               if ((operation.toUpperCase()).equals("FLIP")){
                  destination.flip(index);
               }else if ((operation.toUpperCase()).equals("SET")) {
                    destination.set(index);
               }
               
			}
           System.out.println(b1set.cardinality() + " " + b2set.cardinality());
       }
     
	}

	public static void onyxTests() {

		// test StringBuffer and String -> ArrayFun..

		String[] params0 = {};
		testArgs(params0);

		KantTest kt = new KantTest();
		kt.testKant();

		IntegerTest it = new IntegerTest();
		it.testIntegerTest();

		BoggyTest bg = new BoggyTest();
		bg.testBoggyTest();

		PriorityQueueTest pq = new PriorityQueueTest();
		pq.testPriorityTest();

		testVibrateEcho();
		testHummingbird();

		ChillisTest ct = new ChillisTest();
		String[] params = { "green", "4" };
		ct.testChilli(params);

		testRegex();

		testExceptionHierarchy();
		testBig();
		testException();
	}

	public static void testBig() {
		Weighty w = new Weighty();

	}

	public static void testExceptionHierarchy() {

		SticksMud sm = new SticksMud();
		sm.testSticksMud();

	}

	public static void testException() {
		MacPro mp = new MacPro();
	}

	public static void testRegex() {

		/*
		 * Given this code in a method: 5. String s = "dogs. with words."; 6. // insert code here 7.
		 * for(String o: output) 8. System.out.print(o + " "); Which of the following, inserted
		 * independently at line 6, will produce output that contains the String "dogs"? (Choose all
		 * that apply.) A. String[]output=s.split("s"); B. String[]output=s.split("d"); C. String[]
		 * output = s.split("\\d"); D. String[] output = s.split("\\s"); E.
		 * String[]output=s.split("\\w"); F. String[] output = s.split("\\.");
		 */

		String s = "dogs.with words.";
		String[] output = s.split("s");

		System.out.println("0:" + output[0]);

		String[] output1 = s.split("d");
		System.out.println("1:" + output1[0]);

		String[] output2 = s.split("\\d");
		System.out.println("2:" + output2[0]);

		String[] output3 = s.split("\\s");
		System.out.println("3:" + output3[0]);

		String[] output4 = s.split("\\w");
		System.out.println("4:" + output4[0]);

		String[] output5 = s.split("\\.");
		System.out.println("5:" + output5[0]);

	}

	public static void testArgs(String[] args) {
		try {
			if (args.length == 0)
				throw new Exception();
		} catch (Exception e) {
			System.out.print("done ");
			// doStuff(); // assume this method compiles
		} finally {
			System.out.println("finally ");
		}
	}

	public static void testHummingbird() {

		HummingbirdTest hb = new HummingbirdTest();
		hb.testHummingbird();
	}

	public static void testVibrateEcho() {
		VibrateEcho t = new VibrateEcho();
		t.test();

	}

	public static void testTrie() {

		Trie t = new Trie();
		List<String> words = Arrays.asList("cat", "camera", "word");
		for (String word : words) {
			t.insert(word);
		}
		t.printWords();

		String prefix = "ca";
		System.out.println("Print words with prefix : " + prefix);
		List<String> words2 = (List<String>) t.findWordsByPrefix(prefix);
		for (String word : words2) {
			System.out.println(word);
		}
	}

	public static void testRegexFun() {
		RegexFun rf = new RegexFun();
		rf.testTokenizer();
		rf.testIsIpAddress();
		rf.testTrimAccountName();

	}

	public static void testArrayFun() {

		ArrayFun af = new ArrayFun();
		// af.testStringBufferString();
		/*
		 * af.testIsPalindrome(); System.out.println("\n"); af.testIsAnagram();// 2n, On
		 * af.testIsAnagram2(); // sort O2nlogn+n af.testStrings("hello", "Java");
		 * af.testStrings("java", "java"); af.testStrings("vuu", "vuuuuu"); af.testStringCompare();
		 * af.testIsPrime();
		 */

		// af.testMaxSumHourglass();
		//af.testCalcNegativeSubarrays();
		af.testSortedArrayMerge();
		
	}

	public static void formatCheck(String name, int number) {
		// left aligh and pad 1 5 characters, digit pad with 0s
		System.out.printf("%-15s%03d\n", name, number);
	}

	// // Notes from Other problmes

	/*
	 * public int getPossibleRoutes(String startFrom, String endWith, int currentNumOfStop, int
	 * maxNumOfSTops){ if( currentNumOfStop>0 && startFrom.equals(endWith)){ return 1; } else if
	 * (currentNumOfStops > maxNumOfStops){ return 0; } List<Town> routes =
	 * getExistingRoute(startFrom); for (Town neighborTown : routes) { return
	 * getPossibleRoutes(neighborTown.getName(), endWith, currentNumOfStops+1, maxNumOfStops); }
	 * 
	 * }
	 */

	/*
	 * public void getNumberOfStopsMaxStops(String startFrom, String endWith, int maxNumOfStops) {
	 * int currentNumOfStops = 0;
	 * 
	 * List<String> results = new ArrayList<String>(); List<Town> routes =
	 * getExistingRoutes(startFrom); for (Town neighborTown : routes) { String interResult =
	 * checkNeighborsMax(neighborTown, endWith, currentNumOfStops+1, maxNumOfStops); if
	 * (!interResult.equals("")) { results.add("[" + startFrom + "-" + neighborTown.getName() +
	 * interResult); } }
	 * 
	 * System.out.println("\n\nNumber of stops result![" + startFrom + "," + endWith +"]"); for
	 * (String path : results) { System.out.println(path); }
	 * 
	 * }
	 */

	/*
	 * 
	 * 
	 * 
	 * static { //
	 * http://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java /* The
	 * symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They
	 * may appear four times if the third and fourth are separated by a smaller value, such as
	 * XXXIX.) "D", "L", and "V" can never be repeated. "I" can be subtracted from "V" and "X" only.
	 * "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only.
	 * "V", "L", and "D" can never be subtracted. Only one small-value symbol may be subtracted from
	 * any large-value symbol. A number written in [16]Arabic numerals can be broken into digits.
	 * For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the
	 * non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3
	 * = III. Therefore, 1903 = MCMIII.
	 */
	/*
	 * romanToArabicMap.put("M", 1000); romanToArabicMap.put("CM", 900); romanToArabicMap.put("D",
	 * 500); romanToArabicMap.put("CD", 400); romanToArabicMap.put("C", 100);
	 * romanToArabicMap.put("XC", 90); romanToArabicMap.put("L", 50); romanToArabicMap.put("XL",
	 * 40); romanToArabicMap.put("X", 10); romanToArabicMap.put("IX", 9); romanToArabicMap.put("V",
	 * 5); romanToArabicMap.put("IV", 4); romanToArabicMap.put("I", 1); }
	 */

	public static void testRobotInAGrid() {

		RobotInAGrid newRobot = new RobotInAGrid(10, 12);
		newRobot.initialize();
		newRobot.printMatrix();
		newRobot.computeDistance();
		newRobot.printMatrix();
		newRobot.callPath();
	}

	public void testNestedInterface() {

		Showable.Message message = new TestNestedInterface();// upcasting here
		message.msg();

	}

	public void testCalculator() {

		try {
			Calculate cal = new Calculate();
			int T = cal.get_int_val();
			while (T-- > 0) {
				double volume = 0.0;
				int ch = cal.get_int_val();
				if (ch == 1) {
					int a = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(a);
				} else if (ch == 2) {
					int l = cal.get_int_val();
					int b = cal.get_int_val();
					int h = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(l, b, h);

				} else if (ch == 3) {
					double r = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r);

				} else if (ch == 4) {
					double r = cal.get_double_val();
					double h = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void varArgsCheck() {

	}

	public static void runBinarySearchTreeTests() {
		List<Integer> listOfNumbers = new ArrayList<Integer>(Arrays.asList(46, 32, 20, 38, 18, 26,
				34, 42, 33, 40, 44, 50, 53, 68));
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Insert");
		for (Integer num : listOfNumbers) {
			bst.insert(num);
		}

		System.out.println("\nFind");
		BinarySearchTreeNode found = bst.find(44);
		if (found == null) {
			System.out.println("Node not found.");
		} else {
			System.out.println(found);
		}

	}

	public static void runQuickSort() {

		List<Integer> listToSort = new ArrayList<Integer>(Arrays.asList(12, 2, 86, 6, 24, 8, 9, 36,
				99, 4));
		QuickSort qs = new QuickSort(listToSort);
		qs.printList();
		qs.sort();
		qs.printList();

	}

	public void runDijstra() {

		DNode source = new DNode("a");
		DNode nodeA = new DNode("a");
		DNode nodeB = new DNode("b");
		DNode nodeC = new DNode("c");
		DNode nodeD = new DNode("d");
		DNode nodeE = new DNode("e");
		DNode nodeF = new DNode("f");
		DNode nodeG = new DNode("g");
		DNode nodeH = new DNode("h");
		DNode nodeI = new DNode("i");

		DijkstraPQN dgraph = new DijkstraPQN(source);
		/*
		 * dgraph.addEdge("a", "b", 5); dgraph.addEdge("a", "c", 3); dgraph.addEdge("a", "e", 2);
		 * 
		 * dgraph.addEdge("b", "d", 2);
		 * 
		 * dgraph.addEdge("c", "b", 1); dgraph.addEdge("c", "d", 1);
		 * 
		 * dgraph.addEdge("d", "a", 1); dgraph.addEdge("d", "h", 1); dgraph.addEdge("d", "g", 2);
		 * 
		 * dgraph.addEdge("e", "a", 1); dgraph.addEdge("e", "h", 4); dgraph.addEdge("e", "i", 7);
		 * 
		 * dgraph.addEdge("f", "b", 3); dgraph.addEdge("f", "g", 1);
		 * 
		 * dgraph.addEdge("h", "c", 2); dgraph.addEdge("h", "f", 2); dgraph.addEdge("h", "g", 2);
		 * 
		 * dgraph.addEdge("g", "c", 3); dgraph.addEdge("g", "i", 2);
		 */
		dgraph.addEdge(nodeA, nodeB, 5);
		dgraph.addEdge(nodeA, nodeC, 3);
		dgraph.addEdge(nodeA, nodeE, 2);

		dgraph.addEdge(nodeB, nodeD, 2);

		dgraph.addEdge(nodeC, nodeB, 1);
		dgraph.addEdge(nodeC, nodeD, 1);

		dgraph.addEdge(nodeD, nodeA, 1);
		dgraph.addEdge(nodeD, nodeH, 1);
		dgraph.addEdge(nodeD, nodeG, 2);

		dgraph.addEdge(nodeE, nodeA, 1);
		dgraph.addEdge(nodeE, nodeH, 4);
		dgraph.addEdge(nodeE, nodeI, 7);

		dgraph.addEdge(nodeF, nodeB, 3);
		dgraph.addEdge(nodeF, nodeG, 1);

		dgraph.addEdge(nodeH, nodeC, 2);
		dgraph.addEdge(nodeH, nodeF, 2);
		dgraph.addEdge(nodeH, nodeG, 2);

		dgraph.addEdge(nodeG, nodeC, 3);
		dgraph.addEdge(nodeG, nodeI, 2);

		dgraph.printGraph();
		dgraph.printGraphNumbers();

		dgraph.calculateDistances();
		dgraph.printPrevious();
		dgraph.printPathWeight();

		DNode endNode = dgraph.findNode(nodeI);
		List<DNode> path = dgraph.getPath(endNode);
		if (path == null || path.size() == 0) {
			System.out.println("There is no path from " + source.getName() + " to "
					+ endNode.getName());
		}
	}
}
