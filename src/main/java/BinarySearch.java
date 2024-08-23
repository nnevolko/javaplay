import java.util.ArrayList;
import java.util.List;

/*
 * nnevolko
 */

public class BinarySearch {

	List<Fruit> fruitList;

	public BinarySearch(List<Fruit> fruitList) {

		this.fruitList = new ArrayList<Fruit>();
		this.fruitList.addAll(fruitList);

	}

	public Fruit search(Fruit searchForFruit, int startIndex, int endIndex) {

		if (startIndex > endIndex) {
			return null;
		}
		int mid = (startIndex + endIndex) / 2;
		System.out.println("Start index: " + startIndex + ", endIndex: " + endIndex);

		Fruit currentFruit = fruitList.get(mid);
		System.out.println("Temp fruit is: " + currentFruit.getFruitName());

		if (currentFruit.compareTo(searchForFruit) == 0) {
			return fruitList.get(mid);
		} else if (searchForFruit.compareTo(currentFruit) > 0) {
			/*
			 * if (mid + 1 == fruitList.size()) { return null; }
			 */
			return search(searchForFruit, mid + 1, endIndex);
		} else if (searchForFruit.compareTo(currentFruit) < 0) {
			/*
			 * if (mid - 1 < 0) { return null; }
			 */
			return search(searchForFruit, startIndex, mid - 1);
		}
		return null;
	}

	public Fruit searchFruit(String name) {
		// checkNotNull(name);
		Fruit f = null;
		Fruit searchForFruit = new Fruit(name);

		Fruit found = search(searchForFruit, 0, fruitList.size() - 1);
		if (found == null) {
			System.out.println("Did not find your fruit: " + searchForFruit.getFruitName());
		} else {
			System.out.println("Matching fruit is: " + found);
		}
		return f;
	}

}
