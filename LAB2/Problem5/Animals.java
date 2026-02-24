abstract class Animal {

    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public abstract String getSound();

    public String toString() {
        return name + " (age " + age + ") says: " + getSound();
    }
}

class Cat extends Animal {
  
    public Cat(String name, int age) { super(name, age); }
    public String getSound() { return "Meow"; }
}

class Dog extends Animal {

    public Dog(String name, int age) { super(name, age); }
    public String getSound() { return "Woof"; }
}

class Bird extends Animal {

    public Bird(String name, int age) { super(name, age); }
    public String getSound() { return "Tweet"; }
}

class Fish extends Animal {

    public Fish(String name, int age) { super(name, age); }
    public String getSound() { return "..."; }
}
