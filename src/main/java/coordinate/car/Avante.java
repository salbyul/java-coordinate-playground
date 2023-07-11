package coordinate.car;

public class Avante implements Car {

    private static final int MILEAGE = 15;
    private static final String CAR_NAME = "Avante";
    private final int distance;

    public Avante(final int avanteDistance) {
        this.distance = avanteDistance;
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
