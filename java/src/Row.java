import java.util.Arrays;
import java.util.stream.Stream;

class Row {
    private final Coordinate[] coordinates;

    public Row(int row) {
        coordinates = new Coordinate[3];
        for (int column = 0; column < 3; column++)
            coordinates[column] = new Coordinate(row, column);
    }

    public Stream<Coordinate> getCoordinatesStream() {
        return Arrays.stream(coordinates);
    }

    public Coordinate getFirstCoordinate() {
        return coordinates[0];
    }
}
