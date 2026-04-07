public class Person {
    private String name;

    public Person() {
        name = "Unknown";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return name.equals(other.name);
        }
        return false;
    }
}
