import java.util.Arrays;

public abstract class Account {
    //instance variables
    public static int firstAcctNumber = 100;
    public static int INITSIZE = 25;
    protected Customer customer;
    protected double balance;
    protected int accountNumber;
    protected Transaction[] transactions;
    int size;
    private int index = 0;

    public Account(Customer customer) {
        this.customer = customer;
        balance = 0;
        this.accountNumber = firstAcctNumber++;
        transactions = new Transaction[INITSIZE];
    }

    //stores a transaction in transaction array
    public void addTransaction(byte type, double amount, double fees) {
        transactions[index] = new Transaction(type, amount, fees);
        index++;
    }

    public void reallocate() {
        size = size*2;
        Transaction[] newTrans = new Transaction[size];
        newTrans = Arrays.copyOf(transactions, transactions.length);
        transactions = newTrans;
    }

    public double getBalance() {
        return this.balance;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getAccountNumber() {
        String s = String.valueOf(this.accountNumber);
        return s;
    }


    public void setBalance(double b) {
        this.balance = b;
    }

    public void setCustomer(Customer c) {
        this.customer = c;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String toString() {
        String s = "Account Number: " + accountNumber + " , " + " Customer: " + customer + " Balance: " + balance;
        return s;
    }


    public abstract void deposit(double amt);

    public abstract void withdraw(double amt);

    public abstract void addInterest();
}
