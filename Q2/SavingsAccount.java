public class SavingsAccount extends Account {

    /** Creates a new instance of SavingsAccount */
    public SavingsAccount(Customer customer) {
        super(customer);
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            addTransaction((byte)0, amt, 0);
        }
        else {
            System.out.println("You entered a negative number less than 0.");
        }
    }

    public void withdraw(double amt) {
        //overdraft if amount will make balance < 0
        double fees = 0.0;
        if (((balance - amt) < 0) && (amt > 0)) {
            if (customer instanceof Senior) {
                Senior s = (Senior) customer;
                if (s.vipSenior()) {
                    if (amt <= 100) {
                        fees = 0;
                    }
                    else if (amt >= 100 && amt <= 455) {
                        fees = s.getOverdraftPenalty();
                    }
                    else {
                        System.out.println("Your balance is not high enough for a withdrawal.");
                        return;
                    }

                }else {
                    fees = s.getOverdraftPenalty();
                }

                fees += s.getCheckCharge();

            }

            else if (customer instanceof Adult) {
                if (0 >= amt && amt <= 455) {
                    Adult a = (Adult) customer;
                    fees = a.getCheckCharge() + a.getOverdraftPenalty();
                }
                else {
                    System.out.println("Your balance is not high enough for a withdrawal.");
                    return;
                }
            }

            else if (customer instanceof Student) {
                System.out.println("You are not eligible for a withdrawal");
                return;
            }

            balance -= amt + fees;
            addTransaction((byte)1, amt, fees);
        }

        else if (((balance - amt) > 0) && (amt > 0)) {
            fees = customer.getCheckCharge();
            balance -= amt + fees;
            addTransaction((byte)1, amt, fees);
        }
        else if (amt < 0) { System.out.println("You entered a negative number less than 0."); }
    }



    public void addInterest() {
        double interestRate = customer.getSavingsInterest();
        balance *= 1+interestRate;
    }

    public String toString() {
        return "Account Number is: " + accountNumber + " , " + customer + " Balance is: " + balance + " Account type: Savings ";

    }
}
