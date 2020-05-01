
public class MoveValidator {
    Symbol lastSymbol = Symbol.SPACE;

    public Symbol getLastSymbol() {
        return lastSymbol;
    }

    public void setLastSymbol(Symbol last) {
        lastSymbol = last;
    }

    boolean repeatedMove(Symbol symbol) {
        return symbol.equals(getLastSymbol());
    }

    void validateRepeatedMove(Symbol symbol) throws Exception {
        if (repeatedMove(symbol)) {
            throw new Exception("Invalid next player");
        }
    }

    boolean playerIsNotX(Symbol symbol) {
        return symbol.equals(Symbol.O);
    }

    void validateFirstMove(Symbol symbol, Game game) throws Exception {
        if (isFirstMove()) {
            if (playerIsNotX(symbol)) {
                throw new Exception("Invalid first player");
            }
        }
    }

    boolean isFirstMove() {
        return getLastSymbol().equals(Symbol.SPACE);
    }
}
