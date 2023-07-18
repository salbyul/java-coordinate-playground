package coordinate;

import coordinate.figure.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle(Arrays.asList(new Point(1, 1), new Point(1, 7), new Point(7, 1)));
    }

    @Test
    @DisplayName("삼각형 넓이 계산")
    void getArea() {
        double area = triangle.getArea();
        assertThat(area).isEqualTo(18, offset(0.00099));
    }
}
