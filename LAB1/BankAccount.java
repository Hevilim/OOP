public class BankAccount {
    
    private static int totalAccounts = 0;
    private static final double MIN_BALANCE = 10.0;
    private final int accountNumber;
    private String owner;
    private double balance;
    
    static {
        System.out.println("Bank system initialized");
        totalAccounts = 0;
    }
    
    {
        totalAccounts++;
        System.out.println("New account created. Total accounts: " + totalAccounts);
    }
    
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = totalAccounts;
    }
    
    public BankAccount(String owner) {
        this(owner, MIN_BALANCE);
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void deposit(double amount, String note) {
        balance += amount;
        System.out.println("Deposited with note: " + note);
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public final int getAccountNumber() {
        return accountNumber;
    }
    
    public static final double getMinBalance() {
        return MIN_BALANCE;
    }
}