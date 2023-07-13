package coordinate.calculator;

import coordinate.calculator.figure.Figure;
import coordinate.calculator.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class FigureGeneratorTest {

    @Test
    @DisplayName("두 좌표를 줄 경우 직선으로 계산하여 결과 계산")
    void calculateLine() {
        Positions positions = new Positions(Arrays.asList(new Position(10, 10), new Position(14, 15)));
        FigureGenerator figureGenerator = new FigureGenerator();
        Figure result = figureGenerator.generate(positions);
        assertThat(result.area()).isEqualTo(6.403124, offset(0.000009));
    }

    @Test
    @DisplayName("네 쌍의 좌표를 입력할 경우 사각형으로 가정하고 면적 계산")
    void calculateRectangle() {
        Positions positions = new Positions(Arrays.asList(new Position(10, 10), new Position(22, 10), new Position(22, 18), new Position(10, 18)));
        Positions positions2 = new Positions(Arrays.asList(new Position(10, 10), new Position(20, 17), new Position(20, 10), new Position(10, 17)));
        FigureGenerator figureGenerator = new FigureGenerator();
        Figure result = figureGenerator.generate(positions);
        Figure result2 = figureGenerator.generate(positions2);
        assertThat(result.area()).isEqualTo(96);
        assertThat(result2.area()).isEqualTo(70);
    }

    @Test
    @DisplayName("사다리꼴의 좌표를 준 경우 예외 발생")
    void calculateTrapezoid() {
        Positions positions = new Positions(Arrays.asList(new Position(12, 10), new Position(14, 10), new Position(22, 18), new Position(10, 18)));
        FigureGenerator generator = new FigureGenerator();
        assertThatThrownBy(() -> generator.generate(positions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정사각형이나 직사각형만 계산이 가능합니다.");
    }

    @Test
    @DisplayName("마름모의 좌표를 준 경우 예외 발생")
    void calculateDiamond() {
        Positions positions = new Positions(Arrays.asList(new Position(12, 4), new Position(12, 10), new Position(6, 8), new Position(14, 8)));
        FigureGenerator generator = new FigureGenerator();
        assertThatThrownBy(() -> generator.generate(positions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정사각형이나 직사각형만 계산이 가능합니다.");
    }

    @Test
    @DisplayName("세 쌍의 좌표를 입력할 경우 삼각형으로 가정하고 면적 계산")
    void calculateTriangle() {
        Positions positions = new Positions(Arrays.asList(new Position(14, 15), new Position(20, 8), new Position(10, 10)));
        Positions positions2 = new Positions(Arrays.asList(new Position(0, 0), new Position(10, 0), new Position(0, 10)));
        FigureGenerator generator = new FigureGenerator();
        Figure result = generator.generate(positions);
        Figure result2 = generator.generate(positions2);
        assertThat(result.area()).isEqualTo(29, offset(0.000009));
        assertThat(result2.area()).isEqualTo(50, offset(0.000009));
    }
}
