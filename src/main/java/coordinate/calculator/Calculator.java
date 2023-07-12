package coordinate.calculator;

import coordinate.calculator.position.Position;

public class Calculator {

    public Line calculate(final Positions positions) {
        validatePositionLength(positions);
        Position position = positions.getPosition(0);
        Position position2 = positions.getPosition(1);
        double length = Math.sqrt(Math.pow(position.getX() - position2.getX(), 2) + Math.pow(position.getY() - position2.getY(), 2));
        return new Line(length);
    }

    private void validatePositionLength(final Positions positions) {
        if (positions.size() != 2) {
            throw new IllegalArgumentException("직선은 좌표가 두 쌍이어야 합니다.");
        }
    }
}
