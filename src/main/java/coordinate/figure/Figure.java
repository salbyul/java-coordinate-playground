package coordinate.figure;

import coordinate.Point;

import java.util.List;

public interface Figure {

    double getArea();

    List<Point> getPoints();

    List<Double> getLineDistances();

    String getName();
}
