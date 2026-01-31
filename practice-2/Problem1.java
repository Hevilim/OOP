import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Your name: ");
		String name = in.nextLine();
		System.out.println("Year of study: ");
		int yearOfStudy = in.nextInt();
		in.close();

		Student student = new Student(name, yearOfStudy);

		student.info();	
	}
}

public class Student {

	private String name;
	private int id;
	private int yearOfStudy;

	private int i = 0;
	Student(String name, int yearOfStudy) {

		this.name = name;
		id = i++;
		this.yearOfStudy = yearOfStudy;
	}

	public void info() {

	System.out.printf("Student name: %s\nYear of study: %d", name, yearOfStudy);
	}
}
