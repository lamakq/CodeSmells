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

    private boolean thirdRowHasSameSymbols() {
        return symbolAt(new Coordinate(2, 0)).equals(
                symbolAt(new Coordinate(2, 1))) &&
                symbolAt(new Coordinate(2, 2)).equals(
                        symbolAt(new Coordinate(2, 1)));
    }

    private boolean thirdRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(new Coordinate(2, 0)) &&
                tileIsAlreadyPlayed(new Coordinate(2, 1)) &&
                tileIsAlreadyPlayed(new Coordinate(2, 2));
    }

    private boolean secondRowHasSameSymbols() {
        return symbolAt(new Coordinate(1, 0)).equals(
                symbolAt(new Coordinate(1, 1))) &&
                symbolAt(new Coordinate(1, 2)).equals(
                        symbolAt(new Coordinate(1, 1)));
    }

    private boolean secondRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(new Coordinate(1, 0)) &&
                tileIsAlreadyPlayed(new Coordinate(1, 1)) &&
                tileIsAlreadyPlayed(new Coordinate(1, 2));
    }

    private boolean firstRowHasSameSymbols() {
        return symbolAt(new Coordinate(0, 0)).equals(
                symbolAt(new Coordinate(0, 1))) &&
                symbolAt(new Coordinate(0, 2))
                        .equals(symbolAt(new Coordinate(0, 1)));
    }

    private boolean firstRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(new Coordinate(0, 0)) &&
                tileIsAlreadyPlayed(new Coordinate(0, 1)) &&
                tileIsAlreadyPlayed(new Coordinate(0, 2));
    }
}