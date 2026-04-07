public class Animal implements Comparable<Animal>, Cloneable, Feedable {

    protected String name;
    private double ateBowls = 0.0;

    public Animal() { this.name = "Barsik"; }
    public Animal(String name) { this.name = name; }

    public String getName() { return name; }

    public void makeSound() { System.out.println("*silence*"); }

    @Override
    public void eat(int bowls) { this.ateBowls += bowls; }

    @Override
    public void eat(double bowls) { this.ateBowls += bowls; }

    @Override
    public double getAteBowls() { return ateBowls; }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Animal: " + name + ", ate: " + ateBowls + " bowls";
    }
}
