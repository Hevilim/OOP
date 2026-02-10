public class Problem2 {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("Ljnsas", 500);
        BankAccount acc2 = new BankAccount("Kakakakaka");
        
        acc1.deposit(100);
        acc2.deposit(50, "Birthday gift");
        
        System.out.println(acc1.getOwner() + " balance: " + acc1.getBalance());
        System.out.println(acc2.getOwner() + " balance: " + acc2.getBalance());
        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Minimum balance: " + BankAccount.getMinBalance());
    }
}