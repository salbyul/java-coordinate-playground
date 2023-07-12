package coordinate.calculator.position;

public class PositionParser {

    protected PositionParser() {
    }

    public Position parsePosition(final String userInput) {
        if (!surroundsBracket(userInput)) {
            throw new IllegalArgumentException("괄호안에 좌표를 입력해야 합니다.");
        }
        String[] split = getSplit(userInput);
        if (split.length != 2) {
            throw new IllegalArgumentException("x, y좌표 모두 입력해야 합니다.");
        }
        return new Position(new X(parseInt(split[0])), new Y(parseInt(split[1])));
    }

    private String[] getSplit(final String userInput) {
        StringBuilder stringBuilder = new StringBuilder(userInput);
        deleteBracket(stringBuilder);
        return stringBuilder.toString().split(",");
    }

    private int parseInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("좌표로 숫자를 입력해야 합니다.");
        }
    }

    private boolean surroundsBracket(final String userInput) {
        return userInput.startsWith("(") && userInput.charAt(userInput.length() - 1) == ')';
    }

    private void deleteBracket(final StringBuilder stringBuilder) {
        int indexOfOpenBracket = stringBuilder.indexOf("(");
        stringBuilder.delete(indexOfOpenBracket, indexOfOpenBracket + 1);
        int indexOfCloseBracket = stringBuilder.indexOf(")");
        stringBuilder.delete(indexOfCloseBracket, indexOfCloseBracket + 1);
    }
}
