import java.util.Scanner;

public class Problem2 {

	public static void main (String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter the width of the triangle: ");
		int width = in.nextInt();
		in.close();

		StarTriangle figure = new StarTriangle(width);
		System.out.println(figure.toString());		
	}	
}

public class StarTriangle {

	private int width;

	StarTriangle(int width) {
		this.width = width;
	}

	public String toString() {

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j <= i; j++) {
				result.append("[*]");
			}
			result.append("\n");
		}

		return result.toString();
	}
}
