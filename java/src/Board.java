import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        return Arrays.stream(ALL_ROW_COORDINATES)
                .filter(this::coordinatesAreAllTaken)
                .filter(this::coordinatesHaveSameSymbols)
                .map(coordinates -> symbolAt(coordinates[0]))
                .findFirst()
                .orElse(Symbol.SPACE);
    }

    private static final Coordinate[] THIRD_ROW_COORDINATES = {
            new Coordinate(2,0),
            new Coordinate(2, 1),
            new Coordinate(2,2)};

    private static final Coordinate[] SECOND_ROW_COORDINATES = {
            new Coordinate(1,0),
            new Coordinate(1, 1),
            new Coordinate(1,2)};

    private static final Coordinate[] FIRST_ROW_COORDINATES = {
            new Coordinate(0,0),
            new Coordinate(0, 1),
            new Coordinate(0,2)};

    private static final Coordinate[][] ALL_ROW_COORDINATES = {
            FIRST_ROW_COORDINATES, SECOND_ROW_COORDINATES, THIRD_ROW_COORDINATES
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
}