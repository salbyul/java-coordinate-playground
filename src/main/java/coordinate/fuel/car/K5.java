package coordinate.fuel.car;

public class K5 extends Car {

    private static final int MILEAGE = 13;
    private static final String CAR_NAME = "K5";

    @Override
    double getMileage() {
        return MILEAGE;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }

    public K5(final int k5Fuel) {
        super(k5Fuel);
    }
}
