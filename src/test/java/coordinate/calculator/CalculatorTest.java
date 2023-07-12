package coordinate.calculator;

import coordinate.calculator.position.Position;
import coordinate.calculator.position.X;
import coordinate.calculator.position.Y;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 좌표를 줄 경우 직선으로 계산하여 결과 계산")
    void calculateLine() {
        Calculator calculator = new Calculator();
        Positions positions = new Positions(Arrays.asList(new Position(new X(10), new Y(10)), new Position(new X(14), new Y(15))));
        Line result = calculator.calculate(positions);
        assertThat(result.length()).isEqualTo(6.403124, offset(0.000009));
    }
}
