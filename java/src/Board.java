import java.util.HashMap;
import java.util.Map;

public class Board
{
    private Map<Coordinate, Symbol> plays = new HashMap<>();

    private Symbol symbolAt(int x, int y)
    {
        return plays.get(new Coordinate(x, y));
    }

    public void AddTileAt(Symbol symbol, int x, int y)
    {
        plays.put(new Coordinate(x, y), symbol);
    }

    boolean tileIsAlreadyPlayed(int x, int y) {
        return plays.containsKey(new Coordinate(x, y));
    }

    public Symbol Winner() {
        if (firstRowPositionsAreTaken()) {
            if (firstRowHasSameSymbols()) {
                return symbolAt(0, 0);
            }
        }

        if (secondRowPositionsAreTaken()) {
            if (secondRowHasSameSymbols()) {
                return symbolAt(1, 0);
            }
        }

        if (thirdRowPositionsAreTaken()) {
            if (thirdRowHasSameSymbols()) {
                return symbolAt(2, 0);
            }
        }

        return Symbol.SPACE;
    }

    private boolean thirdRowHasSameSymbols() {
        return symbolAt(2, 0).equals(
                symbolAt(2, 1)) &&
                symbolAt(2, 2).equals(
                        symbolAt(2, 1));
    }

    private boolean thirdRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(2, 0) &&
                tileIsAlreadyPlayed(2, 1) &&
                tileIsAlreadyPlayed(2, 2);
    }

    private boolean secondRowHasSameSymbols() {
        return symbolAt(1, 0).equals(
                symbolAt(1, 1)) &&
                symbolAt(1, 2).equals(
                        symbolAt(1, 1));
    }

    private boolean secondRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(1, 0) &&
                tileIsAlreadyPlayed(1, 1) &&
                tileIsAlreadyPlayed(1, 2);
    }

    private boolean firstRowHasSameSymbols() {
        return symbolAt(0, 0).equals(
                symbolAt(0, 1)) &&
                symbolAt(0, 2).equals(symbolAt(0, 1));
    }

    private boolean firstRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(0, 0) &&
                tileIsAlreadyPlayed(0, 1) &&
                tileIsAlreadyPlayed(0, 2);
    }
}