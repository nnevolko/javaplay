import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Java8Play {

	private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	private List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
	private List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14,
			15, 16, 17, 18, 19, 20);

	public void test8() {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted()
				.forEach(System.out::println);

	}

	public void testMathJava7() {
		int result = 0;
		for (int e : numbers) {
			if (e % 2 == 0) {
				result += e * 2;
			}
		}
		System.out.println(result);
	}

	public void testMathJava8() {
		// stream - fancy, nice iterator
		// next element and next element, stream has a wealth of functions we can use
		// filter is one of them
		//

		System.out.println(numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2)
				.reduce(0, Integer::sum));

	}

	public void testMathOther1() {

		System.out.println(numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2.0)
				.reduce(0.0, (carry, e) -> carry + e));

		System.out
				.println(numbers.stream().filter(e -> e % 2 == 0).mapToDouble(e -> e * 2.0).sum());

		// filter 0<= number of elemnts in the output <= number of elements in teh input
		// parameter: Stream<T> filter takes Predicate<T>

		// map transforms values
		// number of output == number of input
		// no guarantee on the type of output wiht respect to the type of the input
		// parameter: Stream<T> map takes Function<T,R> to return Stream<R>
		// transformation function

		// both filter and map, stay within their swimlanes
		// filter is going to block a certain value, let some
		// swim lanes. move it forward or block it
		// map is going to create a transformation

		// reduce cuts across the swimlanes.. I'm going to start here and cut
		// across the swim lanes
		// reduce on Stream<T> takes two parameters:
		// first parameter is of type T
		// second parameter is of type BiFunction<R,T,R> to produce result R

		// specilized reduce functions -> sum

		// very special reduce operation -> collect
		//
	}

	public void testMathOther2() {

		// double the even values and put that into a list
		// wrong way to do this

		List<Integer> doubleOfEven = new ArrayList<>();
		numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2).forEach(e -> doubleOfEven.add(e)); // don't
																									// do
																									// this

		Set<Integer> doubleOfEven2 = numbers2.stream().filter(e -> e % 2 == 0).map(e -> e * 2)
				.collect(toSet());
		System.out.println(doubleOfEven2);

		// mutability is Ok, sharing is nice, shared mutability is devil's work
		// friends dont let friends do shared mutation
		// potentially coudl be running in parallel threads, concurrency problems,
		// race conditions

		// collect is a reduce operation as well
		// converted stream into a list

		// how do you go about creating a map
	}

	public static List<Person> createPeople() {
		return Arrays.asList(new Person("Sara", Gender.FEMALE, 20), new Person("Bob", Gender.MALE,
				49), new Person("Jack", Gender.MALE, 2), new Person("Jack", Gender.MALE, 72));

	}

	public void testClasses() {

		List<Person> people = createPeople();

		// map creates name-age as key, and person as value
		/*
		 * System.out.println( people.stream() .collect(toMap( person->person.getName()+ "-" +
		 * person.getAge(), person -> person )));
		 */

		System.out.println(people.stream().collect(groupingBy(Person::getName)));

		// collectors interface -> groupingBy

		// given a list of people, create a map where
		// their name is the key and value is all the people with that name

		// value is all the ages of people with that name

		System.out.println(people.stream().collect(
				groupingBy(Person::getName, mapping(Person::getAge, toList()))));

		// given an ordered list find the double of the first even number greater than 3

		int result = 0;
		// how much work ? 8 units work
		for (int e : numbers) {
			if (e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		System.out.println(result);

		// 20 +17 + 9 -> 46 units
		System.out.println(numbers.stream()
				.filter(e -> e > 3)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.findFirst());

		// streams are absolutely lazy

		// turn off tv, clean up your room, do your homework
		// -> call daddy.. then everything happens

		// intermediate operations and terminal operations
		// intermediate are postponed for evaluation

		System.out.println(
			numbers.stream()
					.filter(Java8Play::isGT3)
					.filter(Java8Play::isEven)
					.map(Java8Play::doubleIt)
					.findFirst());

		// 1.. 2  .. 3.. vv
		// take the value 1 and go.. apply the whole sequence of steps to it
		// 3... 5.. I'm not even
		// 4.. double 8.. findFirst. I'm done..
		
		//Lazy in java is pronounced differently - > as efficient
		// cute code, performs really well, easier to maintain, easier to change
		
		// you never called terminal operation.. so nothing happens
		//lazy evaluation is possible only if the function don't 
		// have side effects
		// 4 characteristics of a stream
		// sized or unsized.. boundless.
		// ordered or unordered.. no ordering at all
		//distinct or non distinct .. may or may not enforce
		// sorted or unsorted.. 
		
		numbers2.stream()
		.filter(e->e%2 ==0)
		.forEach(System.out::println);
		//siezd, ordered, nont-distinct, non-sorted
		
		numbers2.stream()
		.filter(e->e%2 ==0)
		//.sorted()
		.distinct()
		.forEach(System.out::println);
		// can change the property
		
		//can have infinite stream, paves for some really fun programming capabilities
		
		System.out.println(Stream.iterate(100, e->e+1));
		// start with 100, create a series
		// 100, 101, 102, 103, ...
		
		//given a number k, and a count n, find the total of double of n
		// even numbers starting with k, where sqrt of each number is 20
	}
	
	public static int compute(int k, int n){
		
		int result = 0;		
		int index = k;
		int count = 0;
		while (count < n){
			if (index %2 == 0 && Math.sqrt(index) > 20){
				result += index +2;
				count++;
			}
			index++;
		}
		return result;
	}
	
	public static int compute2(int k, int n){
		
		return Stream.iterate(k,  e->e+1) 		//unbounded, lazy
				.filter(e->e%2 == 0)			//unbounded, lazy
				.filter(e->Math.sqrt(e) >20)	//unbounded, lazy
				.mapToInt(e->e*2)				//unbounded, lazy
				.limit(n)						//sized, lazy
				.sum();							//eager
		
		//how do you know if function is lazy or eager
		//look for the return type
	}

	public static boolean isGT3(int number) {
		return number > 3;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static int doubleIt(int number) {
		return number * 2;
	}

}
