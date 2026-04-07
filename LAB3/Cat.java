public class Cat extends Animal {

    public Cat(String name) { super(name); }

    @Override
    public void makeSound() { System.out.println("Meow"); }

    public void makeSound(String s) { System.out.println(s); }

    @Override
    public String toString() {
        return "Cat: " + name + ", ate: " + getAteBowls() + " bowls";
    }
}
