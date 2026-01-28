import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int num = in.nextInt();
        
        String grade;
        
        if (num >= 95) {
            grade = "A";
        } else if (num >= 90) {
            grade = "A-";
        } else if (num >= 85) {
            grade = "B+";
        } else if (num >= 80) {
            grade = "B";
        } else if (num >= 75) {
            grade = "B-";
        } else if (num >= 70) {
            grade = "C+";
        } else if (num >= 65) {
            grade = "C";
        } else if (num >= 60) {
            grade = "C-";
        } else if (num >= 55) {
            grade = "D+";
        } else if (num >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }       

        System.out.println("Grade: " + grade);
        
        in.close();
    }
}
