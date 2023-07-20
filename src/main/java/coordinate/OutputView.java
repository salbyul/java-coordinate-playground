package coordinate;

import coordinate.figure.Figure;
import coordinate.figure.Line;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class OutputView {

    public static final int MAX_POINT_VALUE = 24;
    public static final int MIN_POINT_VALUE = 0;
    public static final String Y_AXIS = "|";
    public static final String X_AXIS = "-";
    public static final String FOUR_BLANK = "    ";
    public static final String DOT = ".";

    public static void printResult(Figure figure) {
        for (int y = MAX_POINT_VALUE; y > MIN_POINT_VALUE; y--) {
            printTableAfterX(figure, y);
        }
        printXAxis();
        nextLine();
        printXNumber();
        nextLine();
        nextLine();
        printArea(figure);
    }

    private static void printTableAfterX(final Figure figure, final int y) {
        if (y % 2 == 0) {
            System.out.printf("%4d", y);
            System.out.print(Y_AXIS);
            printPoint(figure.getPoints(), y);
            nextLine();
            return;
        }
        System.out.printf("%5s", Y_AXIS);
        printPoint(figure.getPoints(), y);
        nextLine();
    }

    private static void printPoint(final List<Point> points, final int y) {
        Queue<Integer> queue = points.stream()
                .filter(point -> point.getY() == y)
                .map(Point::getX)
                .collect(Collectors.toCollection(PriorityQueue::new));
        int cursor = 0;
        while (!queue.isEmpty()) {
            Integer valueOfX = queue.poll();
            printBlank(cursor, valueOfX);
            System.out.print(DOT);
            cursor = valueOfX;
        }
    }

    private static void printBlank(final int cursor, final Integer valueOfX) {
        for (int x = cursor; x < valueOfX; x++) {
            System.out.print(FOUR_BLANK);
        }
    }

    private static void nextLine() {
        System.out.println();
    }

    private static void printXNumber() {
        System.out.print(FOUR_BLANK);
        System.out.print(MIN_POINT_VALUE);
        for (int x = MIN_POINT_VALUE + 2; x <= MAX_POINT_VALUE; x += 2) {
            System.out.printf("%8d", x);
        }
    }

    private static void printXAxis() {
        System.out.print(FOUR_BLANK + "+");
        for (int i = MIN_POINT_VALUE; i < MAX_POINT_VALUE; i++) {
            System.out.printf("%4s", X_AXIS);
        }
    }

    private static void printArea(final Figure figure) {
        System.out.print(getCommentOfArea(figure));
        System.out.printf("%2.1f", figure.getArea());
    }

    private static String getCommentOfArea(final Figure figure) {
        if (figure instanceof Line) {
            return "두 점 사이의 거리는 ";
        }
        return figure.getName() + "의 넓이는 ";
    }
}
