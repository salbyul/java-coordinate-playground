package coordinate.calculator.position;

public class Point {

    private final int value;

    public Point(final int value) {
        if (value < 0 || value > 24) {
            throw new IllegalArgumentException("숫자는 24이하의 자연수만 가능합니다.");
        }
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
