import java.util.HashSet;

public class Problem1c {
 
    public static void main(String[] args) {
        HashSet<Vehicle> set = new HashSet<>();
        set.add(new Vehicle("Toyota", 2020));
        set.add(new Vehicle("Toyota", 2020));
        set.add(new Car("Honda", 2021, "Civic"));
        set.add(new Car("Honda", 2021, "Civic"));

        System.out.println("Unique entries in HashSet:");
        for (Vehicle v : set) {
            System.out.println(v);
        }
    }
}
