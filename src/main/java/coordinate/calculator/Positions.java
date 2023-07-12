package coordinate.calculator;

import coordinate.calculator.position.Position;

import java.util.List;

public class Positions {

    private final List<Position> positions;

    public Positions(final List<Position> positions) {
        this.positions = positions;
    }

    public Position getPosition(final int index) {
        return positions.get(index);
    }

    public int size() {
        return positions.size();
    }
}
