public class Dinner extends Meal{

    public static final double ALLOWANCE = 31.80;

    public Dinner(String description, int numberOfMeals) {
        super(description, numberOfMeals);
    }

    public getAmount() {
        return (ALLOWANCE * getNumberOfMeals());
    }
}
