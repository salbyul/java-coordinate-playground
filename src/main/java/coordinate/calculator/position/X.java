package coordinate.calculator.position;

public class X {

    private final int x;

    public X(final int x) {
        if (x < 0 || x > 24) {
            throw new IllegalArgumentException("숫자는 24이하의 자연수만 가능합니다.");
        }
        this.x = x;
    }
}
