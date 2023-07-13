package coordinate.calculator;

import coordinate.calculator.calculation.CalculationStrategy;
import coordinate.calculator.calculation.LineCalculationStrategy;
import coordinate.calculator.calculation.RectangleCalculationStrategy;
import coordinate.calculator.figure.Figure;
import coordinate.calculator.figure.Line;
import coordinate.calculator.figure.Rectangle;

public class FigureGenerator {

    private CalculationStrategy calculationStrategy;

    public Figure generate(final Positions positions) {
        if (positions.size() == 4) {
            return generateRectangle(positions);
        } else if (positions.size() == 2) {
            return generateLine(positions);
        }
        throw new IllegalArgumentException("좌표의 갯수가 적합하지 않습니다.");
    }

    private Figure generateRectangle(final Positions positions) {
        calculationStrategy = new RectangleCalculationStrategy();
        return new Rectangle(calculationStrategy.calculate(positions));
    }

    private Line generateLine(final Positions positions) {
        calculationStrategy = new LineCalculationStrategy();
        return new Line(calculationStrategy.calculate(positions));
    }
}
