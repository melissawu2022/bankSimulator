public abstract class Expense {

    //instance variables
    private String description;

    //constructor
    public Expense(String description) {
        this.description = description;
    }

    //methods
    public String getDescription() {
        return this.description;
    }

    public abstract double getAmount();
}
