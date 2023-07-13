package coordinate.calculator.figure;

public class Triangle implements Figure{

    private final double area;

    public Triangle(final double area) {
        this.area = area;
    }

    @Override
    public double area() {
        return this.area;
    }
}
