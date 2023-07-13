package coordinate.calculator.figure;

public class Rectangle implements Figure {

    private final double area;

    public Rectangle(final double area) {
        this.area = area;
    }

    @Override
    public double area() {
        return this.area;
    }
}
