import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.Boolean.TRUE;

public class Board
{
    private Map<Coordinate, Symbol> plays = new HashMap<>();

    private Symbol symbolAt(Coordinate coordinate)
    {
        return plays.get(coordinate);
    }

    public void AddTileAt(Coordinate coordinate, Symbol symbol)
    {
        plays.put(coordinate, symbol);
    }

    boolean tileIsAlreadyPlayed(Coordinate coordinate) {
        return plays.containsKey(coordinate);
    }

    public Symbol Winner() {
        return filterWinningRows()
                .map(row -> symbolAt(row.getCoordinates()[0]))
                .findFirst()
                .orElse(Symbol.SPACE);
    }

    private Stream<Row> filterWinningRows() {
        return Arrays.stream(ALL_ROWS)
                .filter(this::areWinningCoordinates);
    }

    private boolean areWinningCoordinates(Row row) {
        return coordinatesAreAllTaken(row.getCoordinates()) && coordinatesHaveSameSymbols(row.getCoordinates());
    }

    private static final Row[] ALL_ROWS = {
            new Row(0), new Row(1), new Row(2)
    };

    private boolean coordinatesHaveSameSymbols(Coordinate[] coordinates) {
        return Arrays.stream(coordinates)
                .map(plays::get)
                .allMatch(plays.get(coordinates[0])::equals);
    }

    private boolean coordinatesAreAllTaken(Coordinate[] coordinates) {
        return Arrays.stream(coordinates)
                .map(this::tileIsAlreadyPlayed)
                .allMatch(TRUE::equals);
    }

    void validateTileAlreadyPlayed(Coordinate coordinate) throws Exception {
        if (tileIsAlreadyPlayed(coordinate)) {
            throw new Exception("Invalid position");
        }
    }
}