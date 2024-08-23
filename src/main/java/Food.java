package main.java;

	/*
	 * nnevolko
	 */

interface Food {
	public String getType();
}

class Pizza implements Food {
	public String getType() {
		return "Someone ordered a Fast Food!";
	}
}

class DeliciousCake implements Food {

	public String getType() {
		return "Someone ordered a Dessert!";
	}
}

class FoodFactory {
	
	public Food getFood(String order) {
		if (order.toLowerCase().equals("pizza")) {
			return new Pizza();
		} else if (order.toLowerCase().equals("cake")) {
			return new DeliciousCake();
		}
		
		return null;
	}
}