import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculate {

	Scanner sc;

	Calculate output;

	public Calculate() {
		output = this;
		sc = new Scanner(System.in);
	}

	public Calculate(boolean flag) {
		output = this;
	}

	// cuboid
	public static Calculate do_calc() {
		return new Calculate(true);
	}

	// cube
	public int get_volume(int a) {
		if (a <= 0) {
			throw new NumberFormatException("All the values must be positive");
		}
		return a * a * a;
	}

	public int get_volume(int l, int b, int h) {
		if (l <= 0 || b <= 0 || h <= 0) {
			throw new NumberFormatException("All the values must be positive");
		}
		return l * b * h;
	}

	// hemisphere
	public double get_volume(double r) {
		if (r <= 0) {
			throw new NumberFormatException("All the values must be positive");
		}
		return (2 / 3d) * Math.PI * r * r * r;
	}

	// cylindr
	public double get_volume(double r, double h) {
		if (r <= 0 || h <= 0) {
			throw new NumberFormatException("All the values must be positive");
		}
		return Math.PI * r * r * h;
	}

	public int get_int_val() throws IOException {
		int newInt = sc.nextInt();
		return newInt;
	}

	public double get_double_val() throws IOException {
		double newDouble = sc.nextDouble();
		return newDouble;
	}

	public Calculate output() {
		return this;
	}

	public void display(Double volume) {
		System.out.printf("%.3f\n", volume);
	}
}