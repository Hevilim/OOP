import java.util.Scanner;
import java.util.Vector;

enum Gender {

    BOY, GIRL;
    
    @Override
    public String toString() {
        return this == BOY ? "Boy" : "Girl";
    }
}

class Person {

    private Gender gender;
    private String name; 
    
    public Person(Gender gender) {
        this.gender = gender;
        this.name = "";
    }
    
    public Person(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return gender.toString() + (name.isEmpty() ? "" : " (" + name + ")");
    }
}

class DragonLaunch {

    private Vector<Person> line;
    
    public DragonLaunch() {
        line = new Vector<>();
    }
    
    public void kidnap(Person p) {
        line.add(p);
    }
    
    public boolean willDragonEatOrNot() {
        
        Vector<Person> temp = new Vector<>(line);
        
        boolean foundPair = true;
        
        while (foundPair) {
            foundPair = false;
            
            
            for (int i = 0; i < temp.size() - 1; i++) {
                if (temp.get(i).getGender() == Gender.BOY && 
                    temp.get(i + 1).getGender() == Gender.GIRL) {
                    temp.remove(i);
                    temp.remove(i);
                    foundPair = true;
                    break;
                }
            }
        }
        return temp.isEmpty();
    }
    
    public Vector<Person> getLine() {
        return line;
    }

    public void displayLine() {
        System.out.print("Line: ");
        for (Person p : line) {
            System.out.print(p.getGender() == Gender.BOY ? "B" : "G");
        }
        System.out.println();
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DragonLaunch dragon = new DragonLaunch();
        
        System.out.println("Enter students (B, G): ");
        System.out.print("Input: ");
        String line = scanner.nextLine().toUpperCase();
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'B') {
                dragon.kidnap(new Person(Gender.BOY));
            } else if (c == 'G') {
                dragon.kidnap(new Person(Gender.GIRL));
            }
        }

        System.out.println("Will dragon eat? " + dragon.willDragonEatOrNot());
        
        scanner.close();
    }
}