public class Animal {

	private String name;
	private double ateBowls = 0.0;

	public Animal() { this.name = "Barsik"; }
	public Animal(String name) { this.name = name; }
	public void makeSound() { System.out.println("*silence*"); }
	public void eat(int bowls) { this.ateBowls += bowls; }

	public void eat(double bowls) { this.ateBowls += bowls; }
}

class Cat extends Animal {

	public Cat(String name) { super(); }
	public void makeSound(String s) { System.out.println(s); }
}

class Dog extends Animal {

	public Dog(String name) { super(name); }
	public void makeSound() { System.out.println("Woof Woof"); }
	public void makeSound(String s) { 
		System.out.printf("%s: %s\n", name, s);
	}
}

	
