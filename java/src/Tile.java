
public class Tile
{
    private Symbol symbol;
    private Coordinate coordinate;

    public Tile(int x, int y, Symbol symbol) {
        coordinate = new Coordinate(x, y);
        this.symbol = symbol;
    }

    public boolean hasPosition(int x, int y) {
        return new Coordinate(x, y).equals(coordinate);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}