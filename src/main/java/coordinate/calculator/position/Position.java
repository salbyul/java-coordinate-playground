package coordinate.calculator.position;

import coordinate.calculator.Positions;

import java.util.List;

public class Position {

    private final X x;
    private final Y y;
    private static final PositionParser parser = new PositionParser();

    public Position(final int x, final int y) {
        this.x = new X(x);
        this.y = new Y(y);
    }

    public static Positions parsePosition(final String userInput) {
        return parser.parsePosition(userInput);
    }

    public int getX() {
        return x.value();
    }

    public int getY() {
        return y.value();
    }
}
