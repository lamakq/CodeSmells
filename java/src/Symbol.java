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
}
