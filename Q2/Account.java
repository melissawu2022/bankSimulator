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

    /** Creates a new instance of Account*/
    public Account(Customer customer) {
        this.customer = customer;
        balance = 0;
        this.accountNumber = firstAcctNumber++;
        transactions = new Transaction[INITSIZE];
    }

    /***********************************************************************
     * stores a transaction in transaction array
     * pre: amount must be positive, fees must be double
     * post: account information is stored in a sport in Transaction array
     * @param type String Account's number
     * @param amount double Amount to deposit
     */
    public void addTransaction(byte type, double amount, double fees) {
        transactions[index] = new Transaction(type, amount, fees);
        index++;
    }
    /** Allocate a new array to hold the transactions. */
    public void reallocate() {
        size = size*2;
        Transaction[] newTrans = new Transaction[size];
        newTrans = Arrays.copyOf(transactions, transactions.length);
        transactions = newTrans;
    }

    /*******************************************
    * Returns account balance
    * @return double Account balance
    */
    public double getBalance() {
        return this.balance;
    }

    /*******************************************
    * Returns account owner
    * @return Customer Account owner
    */
    public Customer getCustomer() {
        return this.customer;
    }

    /*******************************************
    * Returns account number
    * @return String Account number
    */
    public String getAccountNumber() {
        String s = String.valueOf(this.accountNumber);
        return s;
    }


    /*******************************************
    * Changes account balance
    * pre: balance must be a positive value
    * post: account balance changes to <balance>
    * @param double balance New balance
    */
    public void setBalance(double b) {
        this.balance = b;
    }

    /*******************************************
    * Changes account customer
    * pre: customer must be valid
    * post: account owner changes to <customer>
    * @param Customer customer New customer
    */
    public void setCustomer(Customer c) {
        this.customer = c;
    }

    /*******************************************
    * Changes account number
    * pre: accountNumber must be integer
    * post: account owner changes to <accountNumber>
    * @param accountNumber accountNumber New accountNumber
    */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /*******************************************
    * Converts Account object to a String object
    * @return String account information as String object
    */
    public String toString() {
        return "Account Number is: " + accountNumber + " , " + " Customer number " + customer + ", Balance is: " + balance;

    }

    //abstract methods
    public abstract void deposit(double amt);

    public abstract void withdraw(double amt);

    public abstract void addInterest();
}
