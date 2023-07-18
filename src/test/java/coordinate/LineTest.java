package coordinate;

import coordinate.figure.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(Arrays.asList(new Point(1, 1), new Point(6, 6)));
    }

    @Test
    @DisplayName("직선 거리 계산")
    void getArea() {
        double area = line.getArea();
        assertThat(area).isEqualTo(Math.sqrt(50));
    }
}
