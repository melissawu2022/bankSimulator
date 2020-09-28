public class ExpenseTracker {
    private Expense[] expenses;

    private int size; // keeps track of the number of elements

    public ExpenseTracker( int capacity ) {
        size = capacity;
        size = 0;
    }

    // a method has been defined for adding expenses to the tracker
    public boolean add( Expense e ) {...}

    public double getTotal() {
        for (int i = 0; i < expenses.length; i++) {
            double sum = 0;
            sum += expenses[i];
        }
    }
}
