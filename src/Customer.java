import java.util.Comparator;

public class Customer implements Comparable<Customer>{

	private Integer customerId;
	private String firstName;
	private String lastName;
	
	

	public Customer(Integer customerId, String firstName, String lastName) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*public int compare(Customer o1, Customer o2) {
		return o1.getCustomerId().compareTo(o2.getCustomerId());
	}*/

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return this.getCustomerId().compareTo(o.getCustomerId());
	}

	
}
