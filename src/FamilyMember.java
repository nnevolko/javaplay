import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
	String userRole() default "GUEST";
	int budgetLimit();
}

class Pair{
	private String member;
	private Integer expenses;
	
	
	public Pair(String member, Integer expenses) {
		super();
		this.member = member;
		this.expenses = expenses;
	}
	public String getMember() {
		return member;
	}

	public Integer getExpenses() {
		return expenses;
	}
}

class FamilyMember {

	@FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
	public void seniorMember(int budget, int moneySpend) {
		System.out.println("Senior Member");
		System.out.println("Spend: " + moneySpend);
		System.out.println("Budget Left: " + (budget - moneySpend));
	}

	@FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
	public void juniorUser(int budget, int moneySpend) {
		System.out.println("Junior Member");
		System.out.println("Spend: " + moneySpend);
		System.out.println("Budget Left: " + (budget - moneySpend));
	}

	public void testFamilyMember() {

		List<Pair> inputs = new ArrayList<Pair>();

		// 3
		inputs.add(new Pair("SENIOR", 75));
		inputs.add(new Pair("JUNIOR", 45));
		inputs.add(new Pair("SENIOR", 40));

		for (Pair input: inputs) {

			String role = input.getMember();
			int spend = input.getExpenses();
			//System.out.printf( "role %s %d\n", role, spend);
			try {
				Class annotatedClass = FamilyMember.class;
				Method[] methods = annotatedClass.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(FamilyBudget.class)) {
						FamilyBudget family = method.getAnnotation(FamilyBudget.class);
						String userRole = family.userRole();
						int budgetLimit = family.budgetLimit();
						if (userRole.equals(role)) {
							if (spend <= budgetLimit) {
								method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
							} else {
								System.out.println("Budget Limit Over");
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
