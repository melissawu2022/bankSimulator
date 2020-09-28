public class Lunch extends Meal{
    public static final double ALLOWANCE = 11.30;

    public Lunch(String description, int numberOfMeals) {
        super(description, numberOfMeals);
    }

    public getAmount() {
        return (ALLOWANCE * getNumberOfMeals());
    }
}
