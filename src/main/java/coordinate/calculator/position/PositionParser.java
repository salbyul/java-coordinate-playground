package coordinate.calculator.position;

import coordinate.calculator.Positions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PositionParser {

    protected PositionParser() {
    }

    public Positions parsePosition(final String userInput) {
        List<String> separatedInputs = separateInput(userInput);
        Positions positions = new Positions();
        if (separatedInputs.isEmpty()) {
            throw new IllegalArgumentException("(10,20)-(0,1)의 형식으로 입력해야 합니다.");
        }
        for (String separatedInput : separatedInputs) {
            String removed = removeBracket(separatedInput);
            int[] parsedInput = parseInt(removed);
            Position position = new Position(parsedInput[0], parsedInput[1]);
            positions.addPosition(position);
        }
        return positions;
    }

    private int[] parseInt(final String removed) {
        String[] split = removed.split(",");
        int[] result = new int[2];
        try {
            result[0] = Integer.parseInt(split[0]);
            result[1] = Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("좌표로 숫자를 입력해야 합니다.");
        }
        return result;
    }

    private String removeBracket(final String separatedInput) {
        return separatedInput.substring(1).substring(0, separatedInput.length() - 2);
    }

    private List<String> separateInput(final String userInput) {
        List<String> result = new ArrayList<>();
        String regex = "(\\([^,]*,[^,)]*\\))";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(userInput);
        String input = userInput;

        while (matcher.find()) {
            String group = matcher.group();
            result.add(group);
            if (input.length() < group.length() + 1) {
                break;
            }
            input = input.substring(input.indexOf(group) + group.length());
            matcher = compile.matcher(input);
        }
        return result;
    }
}
