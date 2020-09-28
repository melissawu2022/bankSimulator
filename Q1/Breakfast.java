public class Breakfast extends Meal{
    public static final double ALLOWANCE = 11.55;

    public Breakfast(String description, int numberOfMeals) {
        super(description, numberOfMeals);
    }

    public getAmount() {
        return (ALLOWANCE*getNumberOfMeals());
    }

}
