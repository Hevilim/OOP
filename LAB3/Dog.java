public class Dog extends Animal implements Trainable {

    private String[] learnedCommands = new String[10];
    private int commandCount = 0;

    public Dog(String name) { super(name); }

    @Override
    public void makeSound() { System.out.println("Woof Woof"); }

    public void makeSound(String s) {
        System.out.printf("%s: %s\n", name, s);
    }

    @Override
    public void train(String command) {
        if (commandCount < learnedCommands.length) {
            learnedCommands[commandCount++] = command;
            System.out.println(name + " learned: " + command);
        }
    }

    @Override
    public String[] getLearnedCommands() {
        String[] result = new String[commandCount];
        for (int i = 0; i < commandCount; i++) result[i] = learnedCommands[i];
        return result;
    }

    @Override
    public String toString() {
        return "Dog: " + name + ", ate: " + getAteBowls() + " bowls";
    }
}
