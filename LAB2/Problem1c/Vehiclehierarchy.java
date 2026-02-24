import java.util.Objects;

class Vehicle {

    private String brand;
    private int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public int getYear() { return year; }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) o;
        return year == v.year && Objects.equals(brand, v.brand);
    }

    public int hashCode() {
        return Objects.hash(brand, year);
    }

    public String toString() {
        return brand + " (" + year + ")";
    }
}

class Car extends Vehicle {

    private String model;

    public Car(String brand, int year, String model) {
        super(brand, year);
        this.model = model;
    }

    public String getModel() { return model; }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Car)) return false;
        Car c = (Car) o;
        return Objects.equals(model, c.model);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), model);
    }

    public String toString() {
        return super.toString() + " Model: " + model;
    }
}
