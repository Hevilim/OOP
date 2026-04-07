public class Chocolate implements Comparable<Chocolate> {
    private double weight;
    private String name;

    public Chocolate(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public double getWeight() { return weight; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + weight + "g)";
    }

    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }
}
