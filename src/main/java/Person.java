
public class Person {
	
	private String name;
	private Gender gender;
	private Integer age;
	public Person(String name, Gender gender, Integer age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public Gender getGender() {
		return gender;
	}
	public Integer getAge() {
		return age;
	}
	
	

}

enum Gender{
	FEMALE, MALE
}
