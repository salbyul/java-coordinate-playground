package coordinate.calculator;

import coordinate.calculator.figure.Figure;
import coordinate.calculator.position.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ResultViewTest {

    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("직선 결과 출력 확인")
    void printLengthOfLine() {
        Positions positions = new Positions(Arrays.asList(new Position(0, 0), new Position(10, 10)));
        FigureGenerator generator = new FigureGenerator();
        Figure figure = generator.generate(positions);
        ResultView resultView = new ResultView();
        resultView.printResult(figure);
        assertThat(outputStream.toString()).isEqualTo("두 점 사이 거리는 " + Math.sqrt(200));
    }

    @Test
    @DisplayName("사각형 면적 출력 확인")
    void printAreaOfRectangle() {
        Positions positions = new Positions(Arrays.asList(new Position(10, 10), new Position(20, 17), new Position(20, 10), new Position(10, 17)));
        FigureGenerator generator = new FigureGenerator();
        Figure figure = generator.generate(positions);
        ResultView resultView = new ResultView();
        resultView.printResult(figure);
        assertThat(outputStream.toString()).isEqualTo("사각형 넓이는 70.0");
    }

    @Test
    @DisplayName("삼각형 면적 출력 확인")
    void printAreaOfTriangle() {
        Positions positions = new Positions(Arrays.asList(new Position(0, 0), new Position(0, 10), new Position(10, 10)));
        FigureGenerator generator = new FigureGenerator();
        Figure figure = generator.generate(positions);
        ResultView resultView = new ResultView();
        resultView.printResult(figure);
        assertThat(outputStream.toString()).isEqualTo("삼각형 넓이는 50.0");
    }
}
