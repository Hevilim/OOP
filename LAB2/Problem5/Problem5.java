public class Problem5 {

    public static void main(String[] args) {
        Person john  = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
        Person bob   = new Student("Bob", 22, "Mathematics");

        Animal murka = new Cat("Murka", 5);
        Animal rex = new Dog("Rex", 3);
        Animal tweety = new Bird("Tweety", 2);

        john.assignPet(murka);
        bob.assignPet(tweety);

        System.out.println("Trying to give a dog to PhD student:");
        alice.assignPet(rex);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);

        System.out.println("\n" + registry);

        System.out.println("John goes on vacation, leaves Murka with Alice:");
        john.leavePetWith(alice);
        System.out.println(registry);

        System.out.println("John returns and retrieves Murka:");
        john.retrievePetFrom(alice);
        System.out.println(registry);

        registry.printPeopleWithPets();
        System.out.println();
        registry.printPeopleWithoutPets();
    }
}
