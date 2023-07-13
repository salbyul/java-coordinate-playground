package coordinate.calculator.position;

import coordinate.calculator.Positions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PositionParser {

    private static final String SEPARATED_REGEX = "(\\([^,]*,[^,]*\\))";

    protected PositionParser() {
    }

    public Positions parsePositions(final String userInput) {
        Positions positions = new Positions();

        List<String> separatedInputs = separateInput(userInput);
        validateSeparatedSize(separatedInputs);
        for (String separatedInput : separatedInputs) {
            String removed = removeBracket(separatedInput);
            int[] parsedInput = parseInt(removed);
            positions.addPosition(new Position(parsedInput[0], parsedInput[1]));
        }
        return positions;
    }

    private List<String> separateInput(final String userInput) {
        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile(SEPARATED_REGEX).matcher(userInput);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    private void validateSeparatedSize(final List<String> separatedInputs) {
        if (separatedInputs.isEmpty()) {
            throw new IllegalArgumentException("(10,20)-(0,1)의 형식으로 입력해야 합니다.");
        }
    }

    private String removeBracket(final String separatedInput) {
        return separatedInput.substring(1).substring(0, separatedInput.length() - 2);
    }

    private int[] parseInt(final String removed) {
        try {
            return translateToIntArray(removed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("좌표로 숫자를 입력해야 합니다.");
        }
    }

    private int[] translateToIntArray(final String removed) {
        String[] split = removed.split(",");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }
}
