package coordinate.calculator.position;

public class Position {

    private final X x;
    private final Y y;
    private static final PositionParser parser = new PositionParser();

    public Position(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    public static Position parsePosition(final String userInput) {
        return parser.parsePosition(userInput);
    }

    public int getX() {
        return x.value();
    }

    public int getY() {
        return y.value();
    }
}
