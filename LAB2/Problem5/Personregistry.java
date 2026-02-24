import java.util.ArrayList;

class PersonRegistry {

    private ArrayList<Person> people;

    public PersonRegistry() {
        people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public void removePerson(Person p) {
        people.remove(p);
    }

    public void printPeopleWithPets() {
        System.out.println("People with pets:");
        for (Person p : people) {
            if (p.hasPet()) System.out.println("  " + p);
        }
    }

    public void printPeopleWithoutPets() {
        System.out.println("People without pets:");
        for (Person p : people) {
            if (!p.hasPet()) System.out.println("  " + p);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Registry\n");
        for (Person p : people) sb.append("  ").append(p).append("\n");
        return sb.toString();
    }
}
