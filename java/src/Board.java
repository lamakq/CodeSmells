import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile tile = new Tile(new Coordinate(i, j), Symbol.SPACE);
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.hasPosition(x, y)){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(Symbol symbol, int x, int y)
    {
        TileAt(x, y).setSymbol(symbol);
    }

    boolean tileIsAlreadyPlayed(int x, int y) {
        return !TileAt(x, y).getSymbol().equals(Symbol.SPACE);
    }

    public Symbol Winner(Game game) {
        if (firstRowPositionsAreTaken()) {
            if (firstRowHasSameSymbols()) {
                return TileAt(0, 0).getSymbol();
            }
        }

        if (secondRowPositionsAreTaken()) {
            if (secondRowHasSameSymbols()) {
                return TileAt(1, 0).getSymbol();
            }
        }

        if (thirdRowPositionsAreTaken()) {
            if (thirdRowHasSameSymbols()) {
                return TileAt(2, 0).getSymbol();
            }
        }

        return Symbol.SPACE;
    }

    private boolean thirdRowHasSameSymbols() {
        return TileAt(2, 0).getSymbol().equals(
                TileAt(2, 1).getSymbol()) &&
                TileAt(2, 2).getSymbol().equals(
                        TileAt(2, 1).getSymbol());
    }

    private boolean thirdRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(2, 0) &&
                tileIsAlreadyPlayed(2, 1) &&
                tileIsAlreadyPlayed(2, 2);
    }

    private boolean secondRowHasSameSymbols() {
        return TileAt(1, 0).getSymbol().equals(
                TileAt(1, 1).getSymbol()) &&
                TileAt(1, 2).getSymbol().equals(
                        TileAt(1, 1).getSymbol());
    }

    private boolean secondRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(1, 0) &&
                tileIsAlreadyPlayed(1, 1) &&
                tileIsAlreadyPlayed(1, 2);
    }

    private boolean firstRowHasSameSymbols() {
        return TileAt(0, 0).getSymbol().equals(
                TileAt(0, 1).getSymbol()) &&
                TileAt(0, 2).getSymbol().equals(TileAt(0, 1).getSymbol());
    }

    private boolean firstRowPositionsAreTaken() {
        return tileIsAlreadyPlayed(0, 0) &&
                tileIsAlreadyPlayed(0, 1) &&
                tileIsAlreadyPlayed(0, 2);
    }
}