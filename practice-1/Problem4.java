import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("a = ");
        double a = in.nextDouble();
        
        System.out.print("b = ");
        double b = in.nextDouble();
        
        System.out.print("c = ");
        double c = in.nextDouble();
        
        if (a == 0) {
            System.out.println("Err");
            in.close();
            return;
        }
        
        double D = b * b - 4 * a * c;
		double A = a * 2;
        
        if (D < 0) {
            System.out.println("Err");
        } else if (D == 0) {
            double x = -b / A;
            System.out.println("x = " + x);
        } else {
            double sqrtD = Math.sqrt(D);
            
            double x1 = (-b + sqrtD) / A;
            double x2 = (-b - sqrtD) / A;
            
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        
        in.close();
    }
}
