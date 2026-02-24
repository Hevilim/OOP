public class Problem3 {

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(1001, 5.0);
        sa.deposit(1000);

        CheckingAccount ca = new CheckingAccount(1002);
        ca.deposit(500);
        ca.withdraw(100);
        ca.deposit(200);
        ca.withdraw(50);

        Bank bank = new Bank();
        bank.openAccount(sa);
        bank.openAccount(ca);

        System.out.println("Before update:");
        bank.printAll();

        bank.update();

        System.out.println("\nAfter update:");
        bank.printAll();

        System.out.println("\nTransfer $200 from savings to checking:");
        sa.transfer(200, ca);
        bank.printAll();

        System.out.println("\nClose savings account #1001:");
        bank.closeAccount(1001);
        bank.printAll();
    }
}
