
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

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}