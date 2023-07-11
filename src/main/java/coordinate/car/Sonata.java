package coordinate.car;

public class Sonata implements Car{

    private static final String CAR_NAME = "Sonata";
    private static final int MILEAGE = 10;
    private final int distance;

    public Sonata(final int sonataDistance) {
        this.distance = sonataDistance;
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
