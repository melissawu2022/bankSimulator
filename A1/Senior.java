public class Senior extends Customer {

    public static final double SAVINGS_INTEREST = 0.08;
    public static final double CHECK_INTEREST = 0.04;
    public static final double CHECK_CHARGE = 0.01;
    public static final double OVERDRAFT_PENALTY = 10;
    public static final double SAVINGS_INTEREST_VIP = 0.1;
    public static final double CHECK_INTEREST_VIP = 0.04;
    public static final double CHECK_CHARGE_VIP = 0.0;
    public static final double OVERDRAFT_PENALTY_VIP = 5;
    public boolean isVip;

    public Senior(String customerName, int age, int customerNumber) {
        super(customerName, age, customerNumber);
        boolean isVip;
    }

    public double getSavingsInterest() {
        if(this.vipSenior()) {
            return this.SAVINGS_INTEREST_VIP;
        }
        else {
            return this.SAVINGS_INTEREST;
        }
    }

    public double getCheckInterest() {
        if(this.vipSenior()) {
            return this.CHECK_INTEREST;
        }
        else {
            return this.CHECK_INTEREST;
        }
    }

    public double getCheckCharge() {
        if(this.vipSenior()) {
            return this.CHECK_CHARGE;
        }
        else {
            return this.CHECK_CHARGE_VIP;
        }
    }

    public double getOverdraftPenalty() {
        if (this.vipSenior()) {
            return 0;
        }
        return this.OVERDRAFT_PENALTY;
    }

    public boolean vipSenior() { //fix
        if (isVip == true) {
            return true;
        }
        else {
            return false;
        }
    }
}
