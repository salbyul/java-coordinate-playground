package coordinate;

import java.util.Objects;

public class Point {

    private static final int MIN_POINT_SIZE = 1;
    private static final int MAX_POINT_SIZE = 24;
    public static final String ERROR_POINT_RANGE = "좌표는 1에서 24까지 가능합니다.";
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        if (x < MIN_POINT_SIZE || x > MAX_POINT_SIZE) {
            throw new IllegalArgumentException(ERROR_POINT_RANGE);
        }
        if (y < MIN_POINT_SIZE || y > MAX_POINT_SIZE) {
            throw new IllegalArgumentException(ERROR_POINT_RANGE);
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
