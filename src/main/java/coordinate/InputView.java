package coordinate;

import coordinate.figure.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String HYPHEN = "-";
    private static final String ERROR_POINT_MESSAGE = "좌표를 올바르게 입력해주세요.";
    public static final String INPUT_MESSAGE = "좌표를 입력해주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public Figure generateFigure() {
        try {
            System.out.println(INPUT_MESSAGE);
            return generateFigure(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateFigure();
        }
    }

    public Figure generateFigure(String input) {
        input = input.replaceAll(" ", "");
        validateInput(input);

        List<Point> points = new ArrayList<>();
        String[] separatedInputs = input.split(HYPHEN);
        for (String separatedInput : separatedInputs) {
            points.add(new Point(extractX(separatedInput), extractY(separatedInput)));
        }
        return FigureFactory.create(points);
    }

    private void validateInput(final String input) {
        Pattern compile = Pattern.compile("\\(\\d{1,2},\\d{1,2}\\)(-(\\(\\d{1,2},\\d{1,2}\\))){0,3}");
        Matcher matcher = compile.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_POINT_MESSAGE);
        }
    }

    private int extractX(final String separatedInput) {
        return Integer.parseInt(separatedInput.substring(1, separatedInput.indexOf(',')));
    }

    private int extractY(final String separatedInput) {
        int indexOfAfterComma = separatedInput.indexOf(',') + 1;
        int indexOfBeforeClosedParenthesis = separatedInput.indexOf(')');
        return Integer.parseInt(separatedInput.substring(indexOfAfterComma, indexOfBeforeClosedParenthesis));
    }
}
