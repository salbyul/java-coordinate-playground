package coordinate.car;

public class K5 implements Car {

    private static final int MILEAGE = 13;
    private static final String CAR_NAME = "K5";
    private final int distance;

    public K5(final int k5Distance) {
        this.distance = k5Distance;
    }

    @Override
    public double getDistancePerLiter() {
        return MILEAGE;
    }

    @Override
    public double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }
}
