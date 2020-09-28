import java.util.Date;
public class Transaction {

    //public static final int DEPOSIT = 0;
    //public static final int WITHDRAW = 1;
    //public static final int ADDED_INTEREST = 2;

    private byte type;
    private double amount;
    private Date date;
    private double fees;
    private String description;

    public Transaction(byte type, double amount, double fees) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.fees = fees;
        description = processTransaction();

    }

    public String processTransaction() {
        String s = "";
        if (type == 0) {
            s = "DEPOSIT";
        }
        else if (type == 1) {
            s = "WITHDRAW";
        }
        else {
            s = "ADD INTEREST";
        }
        return "Type of transaction: " + s + " Amount: " + amount + " Date: " + date + " Fees: " + fees + " Description: " + description;

    }


}
