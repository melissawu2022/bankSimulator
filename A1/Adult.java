public class Adult extends Customer {

    public static final double SAVINGS_INTEREST = 0.03;
    public static final double CHECK_INTEREST = 0.01;
    public static final double CHECK_CHARGE = 0.03;
    public static final double OVERDRAFT_PENALTY = 25;

    public Adult(String customerName, int age, int customerNumber) {
        super(customerName, age, customerNumber);
    }


    public double getSavingsInterest() {
        return this.SAVINGS_INTEREST;
    }

    public double getCheckInterest() {
        return this.CHECK_INTEREST;
    }

    public double getCheckCharge() {
        return this.CHECK_CHARGE;
    }

    public double getOverdraftPenalty () {
        return this.OVERDRAFT_PENALTY;
    }

}
