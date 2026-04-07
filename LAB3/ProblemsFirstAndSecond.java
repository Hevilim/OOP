class ProblemsFirstAndSecond {
	public static void main(String[] args) {
		Pig norka = new Pig("Norka");
		norka.sound();
		norka.move();

		Boat BlackPearl = new Boat();
		BlackPearl.sail();
		BlackPearl.move();
		System.out.println(Boat.count);
	}
}

interface Movable {
	public void move();
}

interface Floatable extends Movable {
	public void sail();
}

class Boat implements Floatable {
	static int count = 0;

	Boat() {
		count++;
	}

	public void move() {
		System.out.println("Boat is moving on the blocs");
	}
	
	public void sail() {
		System.out.println("Boat is sailing");
	}
}
	

abstract class Animal implements Movable {
	String name;

	Animal(String name) {
		this.name = name; 
	}

	public void move() {
		System.out.printf("%s is moving\n", name);
	} 
}

class Pig extends Animal {
	Pig(String name) {
		super(name);
	}

	void sound() {
		System.out.println("Oink-oink");
	}
}	
