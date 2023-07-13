package coordinate.calculator.calculation;

import coordinate.calculator.Positions;

public class RectangleCalculationStrategy implements CalculationStrategy {

    @Override
    public Double calculate(final Positions positions) {
        validatePositionLength(positions);
        validateRectangle(positions);
        return getArea(positions);
    }

    private Double getArea(final Positions positions) {
        double xLength = 0;
        double yLength = 0;

        for (int i = 0; i < 2; i++) {
            int x = Math.abs(positions.getPosition(i).getX() - positions.getPosition(i + 1).getX());
            int y = Math.abs(positions.getPosition(i).getY() - positions.getPosition(i + 1).getY());
            xLength = setLength(x, xLength);
            yLength = setLength(y, yLength);
        }
        return xLength * yLength;
    }

    private double setLength(final int length, final double line) {
        if (length != 0 && line != length) {
            return length;
        }
        return line;
    }

    private void validatePositionLength(final Positions positions) {
        if (positions.size() != 4) {
            throw new IllegalArgumentException("사각형은 좌표가 네 쌍이어야 합니다.");
        }
    }

    private void validateRectangle(final Positions positions) {
        for (int i = 0; i < 3; i++) {
            validateRectangle(positions, i);
        }
    }

    private void validateRectangle(final Positions positions, final int i) {
        if (comparePosition(positions, i)) {
            throw new IllegalArgumentException("정사각형이나 직사각형만 계산이 가능합니다.");
        }
    }

    private boolean comparePosition(final Positions positions, final int index) {
        int flag = 0;
        for (int j = index + 1; j < 4; j++) {
            int xLength = positions.getPosition(index).getX() - positions.getPosition(j).getX();
            int yLength = positions.getPosition(index).getY() - positions.getPosition(j).getY();
            flag = validateLength(flag, xLength, yLength);
        }
        return flag > 1;
    }

    private int validateLength(final int flag, final int xLength, final int yLength) {
        if (xLength != 0 && yLength != 0) {
            return flag + 1;
        }
        return flag;
    }
}
