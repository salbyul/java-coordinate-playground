package coordinate;

import coordinate.figure.Figure;

public class Calculator {

    public static void run() {
        InputView inputView = new InputView();
        Figure figure = inputView.generateFigure();
        OutputView.printResult(figure);
    }
}
