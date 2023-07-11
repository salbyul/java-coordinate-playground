package coordinate.car;

public class Sonata extends Car {

    private static final int MILEAGE = 10;
    private static final String CAR_NAME = "Sonata";

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

    public Sonata(final int sonataFuel) {
        super(sonataFuel);
    }
}
