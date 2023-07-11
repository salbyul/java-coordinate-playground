package coordinate.car;

public abstract class Car {

    double distance;
    abstract double getMileage();
    abstract double getTripDistance();
    public abstract String getName();

    public double getChargeQuantity() {
        return getTripDistance() / getMileage();
    }

    public Car(final int distance) {
        this.distance = distance;
    }
}
