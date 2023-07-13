package coordinate.calculator.figure;

public class Line implements Figure {

    private final double length;

    public Line(final double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return this.length;
    }
}
