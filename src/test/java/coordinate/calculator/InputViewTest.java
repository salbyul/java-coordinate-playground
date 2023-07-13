package coordinate.calculator;

import coordinate.calculator.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @ParameterizedTest
    @DisplayName("유저가 입력한 좌표 확인")
    @ValueSource(strings = {"(10,10)", "(0,8)"})
    void getInputPosition(String input) {
        setSystemIn(input);
        InputView inputView = new InputView();
        String userInput = inputView.getInputPosition();
        assertThat(userInput).isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("괄호로 둘러쌓여 있는지")
    @ValueSource(strings = {"{10,1}", "0,8", "(2,3", "1,3)"})
    void surroundsBracket(String input) {
        setSystemIn(input);
        InputView inputView = new InputView();
        String userInput = inputView.getInputPosition();
        assertThatThrownBy(() -> Position.parsePosition(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("(10,20)-(0,1)의 형식으로 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("좌표로 숫자를 입력했는지")
    @ValueSource(strings = {"(a,4)", "(3,b)", "(a,b)"})
    void inputIsNumber(String input) {
        setSystemIn(input);
        InputView inputView = new InputView();
        String userInput = inputView.getInputPosition();
        assertThatThrownBy(() -> Position.parsePosition(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표로 숫자를 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("좌표로 숫자 2개를 입력했는지")
    @ValueSource(strings = {"()", "(1)", "(1,2,3)"})
    void InputNumberCounts(String input) {
        setSystemIn(input);
        InputView inputView = new InputView();
        String userInput = inputView.getInputPosition();
        assertThatThrownBy(() -> Position.parsePosition(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("(10,20)-(0,1)의 형식으로 입력해야 합니다.");
    }


    @ParameterizedTest
    @DisplayName("0이상 24이하의 좌표를 입력했는지")
    @ValueSource(strings = {"(-1,4)", "(1,25)", "(-1,25)"})
    void positionVolume(String input) {
        setSystemIn(input);
        InputView inputView = new InputView();
        String userInput = inputView.getInputPosition();
        assertThatThrownBy(() -> Position.parsePosition(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 24이하의 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("한개 이상의 좌표를 입력받을 시")
    @CsvSource(value = {"(10,10)-(0,8)=2", "(10,10)=1", "(10,8)-(0,3)-(1,7)=3", "(5,10)-(10,10)-(13,16)-(19,20)=4"}, delimiter = '=')
    void getTwoInput(String input, int size) {
        setSystemIn(input);
        InputView inputView = new InputView();
        String userInput = inputView.getInputPosition();
        Positions position = Position.parsePosition(userInput);
        assertThat(position.size()).isEqualTo(size);
    }

    private void setSystemIn(final String expectedInput) {
        System.setIn(generateInputStream(expectedInput));
    }

    InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
