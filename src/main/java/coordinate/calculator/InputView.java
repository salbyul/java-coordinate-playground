package coordinate.calculator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getInputPositions() {
        String firstInput = getInputPosition();
        System.out.print("-");
        String secondInput = getInputPosition();
        return new String[]{firstInput, secondInput};
    }

    public String getInputPosition() {
        return scanner.next();
    }
}
