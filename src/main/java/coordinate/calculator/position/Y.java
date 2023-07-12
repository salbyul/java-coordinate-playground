package coordinate.calculator.position;

public class Y {

    private final int y;

    public Y(final int y) {
        if (y < 0 || y > 24) {
            throw new IllegalArgumentException("숫자는 24이하의 자연수만 가능합니다.");
        }
        this.y = y;
    }

    public int value() {
        return this.y;
    }
}
