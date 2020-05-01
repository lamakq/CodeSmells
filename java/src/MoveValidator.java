public class MoveValidator {
    static Symbol lastSymbol = Symbol.SPACE;

    public static Symbol getLastSymbol() {
        return lastSymbol;
    }

    public static void setLastSymbol(Symbol last) {
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
}
