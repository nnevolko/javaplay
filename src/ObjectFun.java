import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectFun {

	public void testPlayerCompare() {

		List<Player> players = new ArrayList<>();

		players.add(new Player("amy", 100));
		players.add(new Player("heraldo", 50));
		players.add(new Player("aakansha", 75));
		players.add(new Player("aleksa", 150));
		players.add(new Player("david", 100));

		players.sort(new Checker());

		for (Player p : players) {
			System.out.println(p);
		}

		List<Student2> students = new ArrayList<>();
		students.sort(new StudentComparator());
		Collections.sort(students, new StudentComparator());
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=");
		builder.append(name);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

}

class Checker implements Comparator {

	public int compare(Object o1, Object o2) {
		Player player1 = (Player) o1;
		Player player2 = (Player) o2;
		if (player1.score > player2.score) {
			return -1;
		} else if (player1.score < player2.score) {
			return 1;
		} else {
			return (player1.name).compareTo(player2.name);
		}
	}
}

class Student2 {
	private int id;
	private String fname;
	private double cgpa;

	public Student2(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

}

class StudentComparator implements Comparator {
	/*
	 * You are given a list of student information: ID, FirstName, and CGPA. Your task is to
	 * rearrange them according to their CGPA in decreasing order. If two student have the same
	 * CGPA, then arrange them according to their first name in alphabetical order. If those two
	 * students also have the same first name, then order them according to their ID. No two
	 * students have the same ID.
	 */
	public int compare(Object o1, Object o2) {
		Student2 student1 = (Student2) o1;
		Student2 student2 = (Student2) o2;

		if (student1.getCgpa() > student2.getCgpa()) {
			return -1;
		} else if (student1.getCgpa() < student2.getCgpa()) {
			return 1;
		} else {
			int firstNameCompare = student1.getFname().compareTo(student2.getFname());
			if (firstNameCompare != 0) {
				return firstNameCompare;
			} else {
				if (student1.getId() < student2.getId()) {
					return -1;
				} else if (student1.getId() > student2.getId()) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
}
