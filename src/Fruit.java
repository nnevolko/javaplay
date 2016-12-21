public class Fruit implements Comparable<Fruit> {

	private String fruitName;
	private String fruitDesc;
	private int quantity;

	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = (fruitName.trim());
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}
	
	public Fruit(String fruitName){
		super();
		this.fruitName = fruitName;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = (fruitName.trim());
	}

	public String getFruitDesc() {
		return fruitDesc;
	}

	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int compareTo(Fruit compareFruit) {

		return this.fruitName.compareTo(compareFruit.getFruitName());
		
		//int compareQuantity = ((Fruit) compareFruit).getQuantity();

		// ascending order
		//return this.quantity - compareQuantity;

		// descending order
		// return compareQuantity - this.quantity;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fruitDesc == null) ? 0 : fruitDesc.hashCode());
		result = prime * result + ((fruitName == null) ? 0 : fruitName.hashCode());
		result = prime * result + quantity;
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
		Fruit other = (Fruit) obj;
		if (fruitDesc == null) {
			if (other.fruitDesc != null)
				return false;
		} else if (!fruitDesc.equals(other.fruitDesc))
			return false;
		if (fruitName == null) {
			if (other.fruitName != null)
				return false;
		} else if (!fruitName.equals(other.fruitName))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fruit [fruitName=");
		builder.append(fruitName);
		builder.append(", fruitDesc=");
		builder.append(fruitDesc);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
	
}
