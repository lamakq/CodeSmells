
public class Tile
{
    private Symbol symbol;
    private Coordinate coordinate;

    public Tile(Coordinate coordinate, Symbol symbol) {
        this.symbol = symbol;
        this.coordinate = coordinate;
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