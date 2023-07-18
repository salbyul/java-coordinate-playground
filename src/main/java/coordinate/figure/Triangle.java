package coordinate.figure;

import coordinate.Point;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends AbstractFigure {

    public Triangle(final List<Point> points) {
        super(points);
    }

    @Override
    public double getArea() {
        List<Double> lineDistances = getLineDistances();
        double s = (lineDistances.get(0) + lineDistances.get(1) + lineDistances.get(2)) / 2;
        return Math.sqrt(s * (s - lineDistances.get(0)) * (s - lineDistances.get(1)) * (s - lineDistances.get(2)));
    }

    @Override
    public List<Double> getLineDistances() {
        List<Double> distances = new ArrayList<>();
        distances.add(getPoints().get(0).calculateDistance(getPoints().get(1)));
        distances.add(getPoints().get(0).calculateDistance(getPoints().get(2)));
        distances.add(getPoints().get(1).calculateDistance(getPoints().get(2)));
        return distances;
    }
}
