package coordinate.calculator.figure;

public abstract class Figure {


    private final double area;

    protected Figure(final double area) {
        this.area = area;
    }

    public double area() {
        return this.area;
    }
}
