package coordinate.figure;

import coordinate.Point;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {

    private final List<Point> points;

    public AbstractFigure(List<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
