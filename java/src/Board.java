import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.Boolean.TRUE;

public class Board {
    private Map<Coordinate, Symbol> plays = new HashMap<>();

    private Symbol symbolAt(Coordinate coordinate) {
        return plays.get(coordinate);
    }

    public void AddTileAt(Coordinate coordinate, Symbol symbol) {
        plays.put(coordinate, symbol);
    }

    boolean tileIsAlreadyPlayed(Coordinate coordinate) {
        return plays.containsKey(coordinate);
    }

    public Symbol Winner() {
        return filterWinningRows()
                .map(row -> symbolAt(row.getFirstCoordinate()))
                .findFirst()
                .orElse(Symbol.SPACE);
    }

    private Stream<Row> filterWinningRows() {
        return Arrays.stream(ALL_ROWS)
                .filter(this::areWinningCoordinates);
    }

    private boolean areWinningCoordinates(Row row) {
        return coordinatesAreAllTaken(row) && coordinatesHaveSameSymbols(row);
    }

    private static final Row[] ALL_ROWS = {
            new Row(0), new Row(1), new Row(2)
    };

    private boolean coordinatesHaveSameSymbols(Row row) {
        return row.getCoordinatesStream()
                .map(plays::get)
                .allMatch(plays.get(getFirstCoordinate(row.getFirstCoordinate()))::equals);
    }

    private Coordinate getFirstCoordinate(Coordinate key) {
        return key;
    }

    private boolean coordinatesAreAllTaken(Row row) {
        return row.getCoordinatesStream()
                .map(this::tileIsAlreadyPlayed)
                .allMatch(TRUE::equals);
    }

    void validateTileAlreadyPlayed(Coordinate coordinate) throws Exception {
        if (tileIsAlreadyPlayed(coordinate)) {
            throw new Exception("Invalid position");
        }
    }
}