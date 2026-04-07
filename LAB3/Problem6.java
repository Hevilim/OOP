import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Chocolate[] chocolates = {
            new Chocolate(50, "Twix"),
            new Chocolate(20, "KitKat"),
            new Chocolate(35, "Snickers"),
            new Chocolate(10, "Bounty")
        };

        System.out.println("Chocolates before sort:");
        for (Chocolate c : chocolates) System.out.println(c);
        Sort.bubbleSort(chocolates);
        System.out.println("Chocolates after sort:");
        for (Chocolate c : chocolates) System.out.println(c);

        Time[] times = {
            new Time(10, 30, 0),
            new Time(8, 15, 45),
            new Time(23, 0, 10),
            new Time(6, 0, 0)
        };

        System.out.println("\nTimes before sort:");
        for (Time t : times) System.out.println(t);
        Sort.mergeSort(times);
        System.out.println("Times after sort:");
        for (Time t : times) System.out.println(t);

        Employee[] employees = {
            new Employee("Alice", 3000, new Date(), "NIN001"),
            new Employee("Bob", 1500, new Date(), "NIN002"),
            new Employee("Charlie", 4500, new Date(), "NIN003"),
            new Employee("Diana", 2000, new Date(), "NIN004")
        };

        System.out.println("\nEmployees before sort:");
        for (Employee e : employees) System.out.println(e);
        Sort.bubbleSort(employees);
        System.out.println("Employees after sort:");
        for (Employee e : employees) System.out.println(e);

        Animal[] animals = {
            new Dog("Rex"),
            new Cat("Whiskers"),
            new Dog("Buddy"),
            new Cat("Luna")
        };

        animals[0].eat(3);
        animals[1].eat(1.5);
        animals[2].eat(2);
        animals[3].eat(0.5);

        ((Dog) animals[0]).train("Sit");
        ((Dog) animals[0]).train("Stay");
        ((Dog) animals[2]).train("Fetch");

        System.out.println("\nAnimals before sort:");
        for (Animal a : animals) System.out.println(a);
        Sort.bubbleSort(animals);
        System.out.println("Animals after sort (by name):");
        for (Animal a : animals) System.out.println(a);

        Animal original = animals[0];
        Animal cloned = original.clone();
        System.out.println("\nOriginal: " + original);
        System.out.println("Cloned: " + cloned);
    }
}
