import java.util.HashSet;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add a Person");
            System.out.println("2. Add a Student");
            System.out.println("3. Add a Staff");
            System.out.println("4. Print all persons");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(in.nextLine().trim());

            if (choice == 1) {
                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();
                people.add(new Person(name, address));
                System.out.println("Person added.");

            } else if (choice == 2) {
                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();
                System.out.print("Program: ");
                String program = in.nextLine();
                System.out.print("Year: ");
                int year = Integer.parseInt(in.nextLine().trim());
                System.out.print("Fee: ");
                double fee = Double.parseDouble(in.nextLine().trim());
                people.add(new Student(name, address, program, year, fee));
                System.out.println("Student added.");

            } else if (choice == 3) {
                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();
                System.out.print("School: ");
                String inhool = in.nextLine();
                System.out.print("Pay: ");
                double pay = Double.parseDouble(in.nextLine().trim());
                people.add(new Staff(name, address, inhool, pay));
                System.out.println("Staff added.");

            } else if (choice == 4) {
                if (people.isEmpty()) {
                    System.out.println("No persons added yet.");
                } else {
                    System.out.println("\nAll Persons:");
                    for (Person p : people) {
                        System.out.println(p);
                    }
                }
            }

        } while (choice != 0);

        in.close();
    }
}
