public class Symbol {
    public static final Symbol SPACE = new Symbol(' ');
    public static final Symbol O = new Symbol('O');
    public static final Symbol X = new Symbol('X');
    private char symbol;

    private Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }

    boolean isFirstMove() {
        return MoveValidator.getLastSymbol().equals(SPACE);
    }
}
