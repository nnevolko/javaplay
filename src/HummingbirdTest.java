public class HummingbirdTest {

	public static void testHummingbird() {

		Bird b1 = new Bird();
		Bird b2 = new Hummingbird();
		Hummingbird b3 = (Hummingbird) b2;
		Hummingbird b4 = (Hummingbird) b3;

		b1.fly();
		System.out.println(b1.toString());
		b2.fly();
		System.out.println(b2.toString());
		b3.fly();
		b4.fly();
		System.out.println(Bird.s);
		//fly fly hover hover
		// fly hover hover hover
	}

}

class Bird {
	static String s = "";

	static void fly() {
		s += "fly ";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bird []");
		return builder.toString();
	}
	
	
}

class Hummingbird extends Bird {
	static void fly() {
		s += "hover ";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hummingbird []");
		return builder.toString();
	}
	
	
}