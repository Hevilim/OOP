import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
 
public class Problem4 {
    public static void main(String[] args) {
 
        Date date1 = new Date(120, 0, 15);
        Date date2 = new Date(118, 5, 1);
        Date date3 = new Date(122, 2, 10);
 
        Employee alice = new Employee("Alice", 55000, date1, "AB123456C");
        Employee bob   = new Employee("Bob",   70000, date2, "CD789012E");
        Employee carol = new Employee("Carol", 55000, date3, "EF345678G");
 
        System.out.println("Employees:");
        System.out.println(alice);
        System.out.println(bob);
        System.out.println(carol);
 
        System.out.println("\nEquals:");
        Employee aliceCopy = new Employee("Alice", 55000, date1, "AB123456C");
        System.out.println("alice equals aliceCopy: " + alice.equals(aliceCopy));
        System.out.println("alice equals bob: " + alice.equals(bob));
 
        System.out.println("\ncompareTo:");
        System.out.println("alice vs bob: " + alice.compareTo(bob));
        System.out.println("bob vs alice: " + bob.compareTo(alice));
        System.out.println("alice vs carol: " + alice.compareTo(carol));
 
        System.out.println("\nSort by name:");
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(carol);
        list.add(alice);
        list.add(bob);
        Collections.sort(list, Employee.getNameComparator());
        for (Employee e : list) System.out.println(e.getName());
 
        System.out.println("\nSort by hire date:");
        Collections.sort(list, Employee.getHireDateComparator());
        for (Employee e : list) System.out.println(e.getName() + " - " + e.getHireDate());
 
        System.out.println("\nSort by salary:");
        Collections.sort(list);
        for (Employee e : list) System.out.println(e.getName() + " - " + e.getSalary());
 
        Date date4 = new Date(115, 3, 20);
        Manager dave = new Manager("Dave", 90000, date4, "MN111111A", 15000);
        Manager eve  = new Manager("Eve",  90000, date4, "MN222222B", 20000);
 
        dave.addEmployee(alice);
        dave.addEmployee(bob);
        eve.addEmployee(carol);
 
        System.out.println("\nManagers:");
        System.out.println(dave);
        System.out.println(eve);
 
        System.out.println("\nManager compareTo:");
        System.out.println("dave vs eve: " + dave.compareTo(eve));
        System.out.println("eve vs dave: " + eve.compareTo(dave));
 
        System.out.println("\nManager equals:");
        System.out.println("dave equals eve: " + dave.equals(eve));
 
        System.out.println("\nClone Employee:");
        Employee aliceClone = alice.clone();
        System.out.println("Original: " + alice);
        System.out.println("Clone: " + aliceClone);
        System.out.println("equals: " + alice.equals(aliceClone));
        System.out.println("same object: " + (alice == aliceClone));
        aliceClone.setSalary(99999);
        System.out.println("Original salary after clone change: " + alice.getSalary());
 
        System.out.println("\nClone Manager:");
        Manager daveClone = dave.clone();
        System.out.println("Original team size: " + dave.getTeam().size());
        System.out.println("Clone team size: " + daveClone.getTeam().size());
        System.out.println("Same team object: " + (dave.getTeam() == daveClone.getTeam()));
        daveClone.addEmployee(carol);
        System.out.println("Original team size after clone change: " + dave.getTeam().size());
    }
}
