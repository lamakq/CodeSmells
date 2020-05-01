
public class MoveValidator {
    Symbol lastSymbol = Symbol.SPACE;

    public void setLastSymbol(Symbol last) {
        lastSymbol = last;
    }

    void validateRepeatedMove(Symbol symbol) throws Exception {
        if (symbol.equals(lastSymbol)) {
            throw new Exception("Invalid next player");
        }
    }

    void validateFirstMove(Symbol symbol) throws Exception {
        if (isFirstMove()) {
            if (symbol.isO()) {
                throw new Exception("Invalid first player");
            }
        }
    }

    boolean isFirstMove() {
        return lastSymbol.equals(Symbol.SPACE);
    }
}
