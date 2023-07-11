package coordinate.fuel.car;

public class Avante extends Car {

    private static final String CAR_NAME = "Avante";
    private static final int MILEAGE = 15;

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

    public Avante(final int sonataFuel) {
        super(sonataFuel);
    }
}
