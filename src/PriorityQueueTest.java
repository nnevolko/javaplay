import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
/*
 * 
 
 57. Given:
         1. import java.util.*;
         2. public class Ps {
         3.   public static void main(String[] args) {
         4.     PriorityQueue<String> pq = new PriorityQueue<String>();
         5.     pq.add("4");
         6.     pq.add("7");
         7.     pq.add("2");
         8.     // insert code here
         9. } }
Which code fragment(s), inserted independently at line 8, produce the output "2-4-7-"? (Choose all that apply.)
A. Iterator it2 = pq.iterator();
while(it2.hasNext()) 
System.out.print(it2.next() + "-");
 System.out.println();

B. Arrays.sort(pq.toArray());
Iterator it3 = pq.iterator();
while(it3.hasNext()) System.out.print(it3.next() + "-"); System.out.println();

C. Object[] pqa = pq.toArray(); Arrays.sort(pqa);
for(Object o: pqa) System.out.print(o + "-"); System.out.println();

D. String s = pq.poll();
 	while (s != null) {
         System.out.print(s + "-");
         s = pq.poll();
       }
       
E. String s = pq.peek(); 
	while (s != null) {
         System.out.print(s + "-");
         s = pq.peek();
       }


 */
public class PriorityQueueTest {

	public void testPriorityTest() {

		PriorityQueue<String> pq = new PriorityQueue<>();

		pq.add("4");
		pq.add("7");
		pq.add("2");

		List<String> list = new ArrayList(pq);
		
		Object[] arr = pq.toArray(); 
		
		////
		ListIterator<String> li = list.listIterator();
		while (li.hasNext()){
			System.out.print(li.next() + "_");
		}
		
		// sort array
		System.out.println("\n");
		Arrays.sort(arr);
		for (Object o: arr){
			System.out.print(o.toString() + "_");
		}
		
		
		// peek
		System.out.println("\n");
		while (!pq.isEmpty()){
			System.out.print(pq.peek() + "_");
			// something here.. 
			break;
		}
		
		// poll
		System.out.println("\n");
		while (!pq.isEmpty()){
			System.out.print(pq.poll() + "_");
		}
	}
}
