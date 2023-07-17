package coordinate;

import coordinate.figure.Figure;
import coordinate.figure.Line;
import coordinate.figure.Rectangle;
import coordinate.figure.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("좌표 두 개 입력 시 직선 생성")
    void generateLine() {
        Figure figure = inputView.generateFigure("(1,2)-(3,4)");
        assertThat(figure).isEqualTo(new Line(Arrays.asList(new Point(1, 2), new Point(3, 4))));
    }

    @Test
    @DisplayName("좌표 세 개 입력 시 삼각형 생성")
    void generateTriangle() {
        Figure figure = inputView.generateFigure("(1,2)-(3,4)-(5,6)");
        assertThat(figure).isEqualTo(new Triangle(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(5, 6))));
    }

    @Test
    @DisplayName("좌표 네 개 입력 시 사각형 생성")
    void generateRectangle() {
        Figure figure = inputView.generateFigure("(1,2)-(3,4)-(5,6)-(7,8)");
        assertThat(figure).isEqualTo(new Rectangle(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(5, 6), new Point(7, 8))));
    }

    @ParameterizedTest
    @DisplayName("좌표 갯수 검증")
    @ValueSource(strings = {"(1,2)-(3,4)-(5,6)-(7,8)-(9,10)", "(1,2)"})
    void validatePointSize(String input) {
        assertThatThrownBy(() -> inputView.generateFigure(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 좌표 입력 시 검증")
    @ValueSource(strings = {"(1,2)-(3,4)-(5,6)-(7,8)-9,10", "1,2", "(0,1)-(1, 2)", "(1,0)-(2,1)", "(25,0)-(5,2)", "(0,25)-(10,20)", "(1, -20)-(-1,-2)"})
    void validateUserInput(String input) {
        assertThatThrownBy(() -> inputView.generateFigure(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
