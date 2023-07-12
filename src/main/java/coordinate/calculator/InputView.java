package coordinate.calculator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInputPosition() {
        System.out.println("좌표를 입력하세요.");
        return scanner.next();
    }
}
