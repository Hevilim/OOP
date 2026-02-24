public class Problem1a {

    public static void main(String[] args) {
        Shape3D cyl = new Cylinder(3, 5);
        Shape3D sph = new Sphere(4);
        Shape3D cube = new Cube(2);

        System.out.println("Cylinder volume: " + cyl.volume());
        System.out.println("Cylinder surface: " + cyl.surfaceArea());
        System.out.println("Sphere volume: " + sph.volume());
        System.out.println("Sphere surface: " + sph.surfaceArea());
        System.out.println("Cube volume: " + cube.volume());
        System.out.println("Cube surface: " + cube.surfaceArea());
    }
}
