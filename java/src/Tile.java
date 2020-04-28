
public class Tile
{
    private int X;
    private int Y;
    private Symbol symbol;

    public Tile(int x, int y, Symbol symbol) {
        X = x;
        Y = y;
        this.symbol = symbol;
    }

    public boolean hasPosition(int x, int y) {
        return this.X == x && this.Y == y;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}