public class PrivateCar extends Transportation{

    public static final double RATE = 0.427;
    private int distance;

    public PrivateCar(String description, String destination, int distance) {
        super(description, destination);
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance*RATE;
    }

}
