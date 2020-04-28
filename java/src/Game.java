public class Game {
    Board _board = new Board();
    Symbol lastSymbol = Symbol.SPACE;

    public void Play(Coordinate coordinate, Symbol symbol) throws Exception {
        validateMove(coordinate, symbol);

        updateGameState(symbol, coordinate);
    }

    private void validateMove(Coordinate coordinate, Symbol symbol) throws Exception {
        if (isFirstMove()) {
            if (playerIsNotX(symbol)) {
                throw new Exception("Invalid first player");
            }
        }
        else if (repeatedMove(symbol)) {
            throw new Exception("Invalid next player");
        }
        else if (_board.tileIsAlreadyPlayed(coordinate)) {
            throw new Exception("Invalid position");
        }
    }

    private boolean repeatedMove(Symbol symbol) {
        return symbol.equals(lastSymbol);
    }

    private boolean playerIsNotX(Symbol symbol) {
        return symbol.equals(Symbol.O);
    }

    private void updateGameState(Symbol symbol, Coordinate coordinate) {
        lastSymbol = symbol;
        _board.AddTileAt(coordinate, symbol);
    }

    private boolean isFirstMove() {
        return lastSymbol.equals(Symbol.SPACE);
    }

}

