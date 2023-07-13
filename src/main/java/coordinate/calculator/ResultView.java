package coordinate.calculator;

import coordinate.calculator.figure.Figure;
import coordinate.calculator.figure.Line;
import coordinate.calculator.figure.Rectangle;
import coordinate.calculator.figure.Triangle;

public class ResultView {

    public void printResult(final Figure figure) {
        if (figure instanceof Line) {
            System.out.print("두 점 사이 거리는 " + figure.area());
        } else if (figure instanceof Rectangle) {
            System.out.print("사각형 넓이는 " + figure.area());
        } else if (figure instanceof Triangle) {
            System.out.print("삼각형 넓이는 " + figure.area());
        }
    }
}
