import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double balance = 100000.0;
        double interest = 15.5;
        
        System.out.print("Enter period (years): ");
        int years = in.nextInt();
        
        double initial_balance = balance;
        for (int i = 1; i <= years; i++) {
            balance += balance * interest / 100;
        }
        
        double totalInterest = balance - initial_balance;
        
        System.out.println("\nAccount Information:");
        System.out.println("Initial balance: " + initial_balance);
        System.out.println("Interest rate: " + interest + "%");
        System.out.println("Period: " + years + " years");
        System.out.println("Interest earned: " + totalInterest);
        System.out.println("New balance: " + balance);
        
        in.close();
    }
}
