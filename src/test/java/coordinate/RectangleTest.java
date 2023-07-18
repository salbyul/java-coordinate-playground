package coordinate;

import coordinate.figure.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {

    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        rectangle = new Rectangle(Arrays.asList(new Point(1, 1), new Point(1, 6), new Point(6, 1), new Point(6, 6)));
    }

    @Test
    @DisplayName("사각형 넓이 계산")
    void getArea() {
        double area = rectangle.getArea();
        assertThat(area).isEqualTo(25, offset(0.00099));
    }

    @Test
    @DisplayName("직사각형 제외한 입력 시")
    void validateRectangle() {
        assertThatThrownBy(() -> new Rectangle(Arrays.asList(new Point(1, 1), new Point(1, 7), new Point(6, 1), new Point(6, 3))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
