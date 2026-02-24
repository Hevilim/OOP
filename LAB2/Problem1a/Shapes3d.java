abstract class Shape3D {

    public abstract double volume();
    public abstract double surfaceArea();
}

class Cylinder extends Shape3D {

    private double radius, height;

    public Cylinder(double r, double h) {
        this.radius = r;
        this.height = h;
    }

    public double volume() {
        return Math.PI * radius * radius * height;
    }

    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}

class Sphere extends Shape3D {

    private double radius;

    public Sphere(double r) {
        this.radius = r;
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

class Cube extends Shape3D {

    private double side;

    public Cube(double s) {
        this.side = s;
    }

    public double volume() {
        return side * side * side;
    }

    public double surfaceArea() {
        return 6 * side * side;
    }
}
