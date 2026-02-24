import java.util.Vector;

class Account {

    private double balance;
    private int accNumber;

    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }

    public void deposit(double sum) {
        if (sum > 0) balance += sum;
    }

    public void withdraw(double sum) {
        if (sum > 0 && sum <= balance) balance -= sum;
    }

    public double getBalance() { return balance; }
    public int getAccountNumber() { return accNumber; }

    public void transfer(double amount, Account other) {
        withdraw(amount);
        other.deposit(amount);
    }

    public String toString() {
        return "Account #" + accNumber + ", Balance: $" + String.format("%.2f", balance);
    }

    public final void print() {
        System.out.println(toString());
    }
}

class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        deposit(getBalance() * interestRate / 100);
    }

    public String toString() {
        return "Savings " + super.toString() + ", Rate: " + interestRate + "%";
    }
}

class CheckingAccount extends Account {
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }

    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public void deductFee() {
        if (transactionCount > FREE_TRANSACTIONS) {
            int extra = transactionCount - FREE_TRANSACTIONS;
            super.withdraw(extra * 0.02);
        }
    }

    public String toString() {
        return "Checking " + super.toString() + ", Transactions: " + transactionCount;
    }
}

class Bank {

    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void openAccount(Account a) {
        accounts.add(a);
    }

    public void closeAccount(int accNumber) {
        accounts.removeIf(a -> a.getAccountNumber() == accNumber);
    }

    public void update() {
        for (Account a : accounts) {
            if (a instanceof SavingsAccount) {
                ((SavingsAccount) a).addInterest();
            } else if (a instanceof CheckingAccount) {
                ((CheckingAccount) a).deductFee();
            }
        }
    }

    public void printAll() {
        for (Account a : accounts) a.print();
    }
}
