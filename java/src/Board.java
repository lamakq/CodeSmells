import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        if (firstRowPositionsAreTaken()) {
            if (firstRowHasSameSymbols()) {
                return symbolAt(new Coordinate(0, 0));
            }
        }

        if (secondRowPositionsAreTaken()) {
            if (secondRowHasSameSymbols()) {
                return symbolAt(new Coordinate(1, 0));
            }
        }

        if (thirdRowPositionsAreTaken()) {
            if (thirdRowHasSameSymbols()) {
                return symbolAt(new Coordinate(2, 0));
            }
        }

        return Symbol.SPACE;
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

    private boolean coordinatesHaveSameSymbols(Coordinate[] coordinates) {
        return Arrays.stream(coordinates).map(plays::get).allMatch(plays.get(coordinates[0])::equals);
    }

    private boolean thirdRowHasSameSymbols() {
        return coordinatesHaveSameSymbols(THIRD_ROW_COORDINATES);
    }

    private boolean thirdRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(new Coordinate(2, 0)) &&
                tileIsAlreadyPlayed(new Coordinate(2, 1)) &&
                tileIsAlreadyPlayed(new Coordinate(2, 2));
    }

    private boolean secondRowHasSameSymbols() {
        return coordinatesHaveSameSymbols(SECOND_ROW_COORDINATES);
    }

    private boolean secondRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(new Coordinate(1, 0)) &&
                tileIsAlreadyPlayed(new Coordinate(1, 1)) &&
                tileIsAlreadyPlayed(new Coordinate(1, 2));
    }

    private boolean firstRowHasSameSymbols() {
        return coordinatesHaveSameSymbols(FIRST_ROW_COORDINATES);
    }

    private boolean firstRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(new Coordinate(0, 0)) &&
                tileIsAlreadyPlayed(new Coordinate(0, 1)) &&
                tileIsAlreadyPlayed(new Coordinate(0, 2));
    }
}