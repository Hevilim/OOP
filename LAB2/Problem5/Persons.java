import java.util.Objects;

abstract class Person {

    private String name;
    private int age;
    private Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Animal getPet() { return pet; }

    public void assignPet(Animal pet) {
        this.pet = pet;
    }

    public void removePet() {
        this.pet = null;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public abstract String getOccupation();

    public void leavePetWith(Person other) {
        if (!hasPet()) {
            System.out.println(name + " has no pet to leave.");
            return;
        }
        if (other instanceof PhDStudent && pet instanceof Dog) {
            System.out.println("Cannot leave a dog with a PhD student.");
            return;
        }
        other.assignPet(pet);
        removePet();
    }

    public void retrievePetFrom(Person other) {
        if (!other.hasPet()) {
            System.out.println(other.getName() + " has no pet to return.");
            return;
        }
        assignPet(other.getPet());
        other.removePet();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return age == p.age && Objects.equals(name, p.name);
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return name + " [" + getOccupation() + "]" + (hasPet() ? " | Pet: " + pet : " | No pet");
    }
}

class Employee extends Person {

    private String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() { return jobTitle; }
    public String getOccupation() { return "Employee - " + jobTitle; }
}

class Student extends Person {

    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() { return major; }
    public String getOccupation() { return "Student - " + major; }
}

class PhDStudent extends Person {

    private String researchArea;

    public PhDStudent(String name, int age, String major, String researchArea) {
        super(name, age);
        this.researchArea = researchArea;
    }

    public void assignPet(Animal pet) {
        if (pet instanceof Dog) {
            System.out.println("PhD students cannot have dogs — too busy with research!");
            return;
        }
        super.assignPet(pet);
    }

    public String getResearchArea() { return researchArea; }
    public String getOccupation() { return "PhD Student - " + researchArea; }
}
