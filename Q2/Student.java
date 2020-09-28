public class Student extends Customer {

    public static final double SAVINGS_INTEREST = 0.07;
    public static final double CHECK_INTEREST = 0.03;
    public static final double CHECK_CHARGE = 0.02;
    public static final double OVERDRAFT_PENALTY = 0;

    /** Creates a new instance of Student */
    public Student(String customerName, int age) {
        super(customerName, age);
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
