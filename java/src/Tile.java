
public class Tile
{
    private int X;
    private int Y;
    private char Symbol;
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

    public void setSymbol(char symbol) {
        Symbol = symbol;
        this.symbol = new Symbol(symbol);
    }
}