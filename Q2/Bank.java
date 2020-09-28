import java.util.Arrays;

//Bank.java

/*
 * Bank.java
 *
 * Created on July 21, 2004, 1:23 AM
 */

public class Bank {
    private Account[] accounts;
    private int size;
    private int capacity;

    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;
    private static final int SENIOR = 0;
    private static final int ADULT = 1;
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;

    /** Creates a new instance of Bank */
    public Bank() {
        accounts = new Account[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
    }



    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owners name
     * @param age int Owner's age (in years)
     * @param customerType int Owner's type of customer within bank
     * @param VIP bool Owner is VIPsenior or not
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */
    public String addAccount(String customerName, int age, int customerType, boolean VIP, int typeAccount) {
        Customer customer;
        String accountNumber;

        if (customerType == STUDENT) {
            customer = new Student(customerName, age);
        }
        else if (customerType == ADULT) {
            customer = new Adult(customerName, age);
        }
        else{
            customer = new Senior(customerName, age, VIP);
        }
        if (typeAccount == SAVINGS){
            accounts[size] = new SavingsAccount(customer);
        }
        else {
            accounts[size] = new CheckingAccount(customer);
        }

        accountNumber = accounts[size].getAccountNumber();
        size++;
        return accountNumber;
    }

    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    public String makeDeposit(String accountNumber, double amount){
        int index = find(accountNumber);
        if(index != -1){
            accounts[index].deposit(amount);
            return Double.toString(accounts[index].getBalance());
        }
        else{
            return null;
        }

    }

    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */
    public String makeWithdrawal(String accountNumber, double amount){
        int index = find(accountNumber);
        if(index != -1){
            accounts[index].withdraw(amount);
            return Double.toString(accounts[index].getBalance());
        }
        else{
            return null;
        }
    }

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */
    public String getAccount(String accountNumber) {
        int index = find(accountNumber);
        if(index != -1){
            return accounts[index].toString();
        }
        else{
            return null;
        }
    }

    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
     */
    private int find(String accountNumber) {
        int accNum = Integer.parseInt(accountNumber);
        for (int i = 0; i < this.size; i++) {
            if (this.accounts[i].accountNumber == accNum) {
                return i;
            }
        }
        return -1;
    }

 /***********************************************************************


    /** You need to create private method : Allocate to allocate a new array to hold the transactions. */
    private void reallocate() {
        size = size*2;
        Account[] newAcct = new Account[size];
        newAcct = Arrays.copyOf(accounts, accounts.length);
        accounts = newAcct;
    }

    public String addInterest(String accountNumber) {
            int i = this.find(accountNumber);
            if(i != -1){
                Account acc = accounts[i];
                acc.addInterest();
                double accBalance = acc.getBalance();
                return Double.toString(accBalance);
            }else{
                return null;
            }
    }
}
