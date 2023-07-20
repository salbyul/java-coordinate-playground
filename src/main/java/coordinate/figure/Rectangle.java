package coordinate.figure;

import coordinate.Point;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {

    private static final String ERROR_RECTANGLE_MESSAGE = "직사각형과 정사각형만 입력이 가능합니다.";
    private static final int NUMBER_OF_UNIQUE_POINT = 2;
    private static final String RECTANGLE_NAME = "사각형";

    public Rectangle(final List<Point> points) {
        super(points);
        validateRectangle();
    }

    private void validateRectangle() {
        Set<Integer> xSet = getUniquePoint(Point::getX);
        Set<Integer> ySet = getUniquePoint(Point::getY);
        if (xSet.size() != NUMBER_OF_UNIQUE_POINT || ySet.size() != NUMBER_OF_UNIQUE_POINT) {
            throw new IllegalArgumentException(ERROR_RECTANGLE_MESSAGE);
        }
    }

    private Set<Integer> getUniquePoint(Function<Point, Integer> function) {
        return getPoints().stream().map(function).collect(Collectors.toSet());
    }

    @Override
    public double getArea() {
        List<Double> lineDistances = getLineDistances();
        return lineDistances.get(0) * lineDistances.get(1);
    }

    @Override
    public List<Double> getLineDistances() {
        List<Double> distances = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>(getUniquePoint(Point::getX));
        List<Integer> yValues = new ArrayList<>(getUniquePoint(Point::getY));
        distances.add((double) Math.abs(xValues.get(0) - xValues.get(1)));
        distances.add((double) Math.abs(yValues.get(0) - yValues.get(1)));
        return distances;
    }

    @Override
    public String getName() {
        return RECTANGLE_NAME;
    }
}
