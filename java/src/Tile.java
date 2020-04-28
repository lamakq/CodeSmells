
public class Tile
{
    private int X;
    private int Y;
    private Symbol symbol;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public char getSymbol() {
        return symbol.get();
    }

    public Symbol getRealSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}