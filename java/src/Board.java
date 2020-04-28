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
                Tile tile = new Tile();
                tile.setX(i);
                tile.setY(j);
                tile.setSymbol(Symbol.SPACE);
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.getX() == x && t.getY() == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(Symbol symbol, int x, int y)
    {
        Tile newTile = new Tile();
        newTile.setX(x);
        newTile.setY(y);
        newTile.setSymbol(symbol);

        TileAt(x, y).setSymbol(symbol);
    }
}