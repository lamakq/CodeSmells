public class Symbol {
    public char symbol = Game.SPACE;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char get() {
        return symbol;
    }

    public void set(char symbol) {
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
}
