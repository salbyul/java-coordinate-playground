package coordinate.calculator.position;

import coordinate.calculator.Positions;

public class Position {

    private final Point x;
    private final Point y;
    private static final PositionParser parser = new PositionParser();

    public Position(final int x, final int y) {
        this.x = new Point(x);
        this.y = new Point(y);
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
