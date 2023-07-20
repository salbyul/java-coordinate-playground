package coordinate.figure;

import coordinate.Point;

import java.util.ArrayList;
import java.util.List;

public class Line extends AbstractFigure {

    private static final String LINE_NAME = "직선";

    public Line(final List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        return getLineDistances().get(0);
    }

    @Override
    public List<Double> getLineDistances() {
        List<Double> distances = new ArrayList<>();
        distances.add(getPoints().get(0).calculateDistance(getPoints().get(1)));
        return distances;
    }

    @Override
    public String getName() {
        return LINE_NAME;
    }
}
