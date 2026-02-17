import java.util.Scanner;

public class Problem1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Who do you want to get(Dog or Cat)?");
		System.out.println("After that enter a name for your pet on new line");

		String type = in.next();
		String name = in.next();

		Animal pet;
		if (type == "Dog") { 
			pet = new Dog(name);
		} else if (type == "Cat") {
			pet = new Cat(name);
		} else {
			pet = new Animal(name); 
		}

		System.out.println("Your pet's name is: "); 
		System.out.println(pet.name);	
		System.out.printf("%s, voice!\n", pet.name);
		pet.makeSound();
		pet.makeSound("whoami");
	}
}
