import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();

		int area = a * a;
		System.out.printf("area: %d\nperimeter: %d\ndiagonal: %f\n",
						   area, a * 4, Math.sqrt(area + area));

		in.close();
	}
}	
