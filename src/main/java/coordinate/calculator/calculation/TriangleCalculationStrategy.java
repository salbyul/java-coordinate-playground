package coordinate.calculator.calculation;

import coordinate.calculator.Positions;
import coordinate.calculator.position.Position;

public class TriangleCalculationStrategy implements CalculationStrategy {

    @Override
    public Double calculate(final Positions positions) {
        validatePositionLength(positions);
        Position firstPosition = positions.getPosition(0);
        Position secondPosition = positions.getPosition(1);
        Position thirdPosition = positions.getPosition(2);
        double firstLength = Math.sqrt(Math.pow(firstPosition.getX() - secondPosition.getX(), 2) + Math.pow(firstPosition.getY() - secondPosition.getY(), 2));
        double secondLength = Math.sqrt(Math.pow(firstPosition.getX() - thirdPosition.getX(), 2) + Math.pow(firstPosition.getY() - thirdPosition.getY(), 2));
        double thirdLength = Math.sqrt(Math.pow(secondPosition.getX() - thirdPosition.getX(), 2) + Math.pow(secondPosition.getY() - thirdPosition.getY(), 2));
        double s = (firstLength + secondLength + thirdLength) / 2;
        return Math.sqrt(s * (s - firstLength) * (s - secondLength) * (s - thirdLength));
    }

    private void validatePositionLength(final Positions positions) {
        if (positions.size() != 3) {
            throw new IllegalArgumentException("삼각형은 좌표가 세 쌍이어야 합니다.");
        }
    }
}
