package main.java;

class Cake {

	private final double sugar; // cup
	private final double butter; // cup
	private final int eggs;
	private final int vanila; // spoon
	private final double flour; // cup
	private final double bakingpowder; // spoon
	private final double milk; // cup
	private final int cherry;
	private final double bakingsoda; // spoon
	private final double salt; // spoon 

	public static class Builder {

		private double sugar; // cup
		private double butter; // cup
		private int eggs;
		private int vanila; // spoon
		private double flour; // cup
		private double bakingpowder; // spoon
		private double milk; // cup
		private int cherry;
		private double bakingsoda; // spoon
		private double salt; // spoon 

		// builder methods for setting property
		public Builder sugar(double cup) {
			this.sugar = cup;
			return this;
		}

		public Builder butter(double cup) {
			this.butter = cup;
			return this;
		}

		public Builder eggs(int number) {
			this.eggs = number;
			return this;
		}

		public Builder vanila(int spoon) {
			this.vanila = spoon;
			return this;
		}

		public Builder flour(double cup) {
			this.flour = cup;
			return this;
		}

		public Builder bakingpowder(double spoon) {
			this.sugar = spoon;
			return this;
		}

		public Builder milk(double cup) {
			this.milk = cup;
			return this;
		}

		public Builder cherry(int number) {
			this.cherry = number;
			return this;
		}
		
		public Builder bakingsoda (double spoon) {
			this.bakingsoda = spoon;
			return this;
		}
		
		public Builder salt(double spoon){
			this.salt = spoon;
			return this;
		}

		// return fully build object
		public Cake build() {
			return new Cake(this);
		}
	}

	// private constructor to enforce object creation through builder
	private Cake(Builder builder) {
		this.sugar = builder.sugar;
		this.butter = builder.butter;
		this.eggs = builder.eggs;
		this.vanila = builder.vanila;
		this.flour = builder.flour;
		this.bakingpowder = builder.bakingpowder;
		this.milk = builder.milk;
		this.cherry = builder.cherry;
		this.bakingsoda = builder.bakingsoda;
		this.salt = builder.salt;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Cake [sugar=");
		builder2.append(sugar);
		builder2.append(", butter=");
		builder2.append(butter);
		builder2.append(", eggs=");
		builder2.append(eggs);
		builder2.append(", vanila=");
		builder2.append(vanila);
		builder2.append(", flour=");
		builder2.append(flour);
		builder2.append(", bakingpowder=");
		builder2.append(bakingpowder);
		builder2.append(", milk=");
		builder2.append(milk);
		builder2.append(", cherry=");
		builder2.append(cherry);
		builder2.append(", bakingsoda=");
		builder2.append(bakingsoda);
		builder2.append(", salt=");
		builder2.append(salt);
		builder2.append("]");
		return builder2.toString();
	}



}

// Read more:
// http://javarevisited.blogspot.com/2012/06/builder-design-pattern-in-java-example.html#ixzz57tdzpIjK