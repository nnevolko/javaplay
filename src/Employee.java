
import java.util.Comparator;
/*
 * nnevolko
 */

public class Employee {

	private Integer employeeId;
	private String firstName;
	private String lastName;

	public Employee(Integer employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	static Comparator<Employee> SORT_BY_EMPLOYEE_ID() {
		return new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getEmployeeId().compareTo(o1.employeeId);
			}
			// compare using attribute employeeid
		};
	}

	static Comparator<Employee> SORT_BY_LASTNAME() {
		return new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
			// compare using attribute lastname
		};
	}

	static Comparator<Employee> SORT_BY_FIRSTNAME() {
		return new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getFirstName().compareTo(e2.getFirstName());
			}
		};
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
	
}
