package coordinate;

import coordinate.figure.Figure;
import coordinate.figure.Line;
import coordinate.figure.Rectangle;
import coordinate.figure.Triangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final int LINE_POINTS_SIZE = 2;
    private static final int TRIANGLE_POINTS_SIZE = 3;
    private static final int RECTANGLE_POINTS_SIZE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> map = new HashMap<>();
    public static final String ERROR_POINTS_SIZE = "좌표의 갯수를 확인해주세요.";

    static {
        map.put(LINE_POINTS_SIZE, Line::new);
        map.put(TRIANGLE_POINTS_SIZE, Triangle::new);
        map.put(RECTANGLE_POINTS_SIZE, Rectangle::new);
    }

    public static Figure create(final List<Point> points) {
        validatePointSize(points);
        return map.get(points.size()).apply(points);
    }

    private static void validatePointSize(final List<Point> points) {
        if (points.size() < LINE_POINTS_SIZE || points.size() > RECTANGLE_POINTS_SIZE) {
            throw new IllegalArgumentException(ERROR_POINTS_SIZE);
        }
    }
}
