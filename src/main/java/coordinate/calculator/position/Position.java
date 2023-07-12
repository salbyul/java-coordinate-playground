package coordinate.calculator.position;

import coordinate.calculator.Positions;

public class Position {

    private final X x;
    private final Y y;
    private static final PositionParser parser = new PositionParser();

    public Position(final int x, final int y) {
        this.x = new X(x);
        this.y = new Y(y);
    }

    public static Positions parsePosition(final String userInput) {
        return parser.parsePositions(userInput);
    }

    public int getX() {
        return x.value();
    }

    public int getY() {
        return y.value();
    }
}
