public class Game {
    Board _board = new Board();
    Symbol lastSymbol = Symbol.SPACE;

    public void Play(Symbol symbol, int x, int y) throws Exception {
        if (isFirstMove()) {
            if (playerIsNotX(symbol)) {
                throw new Exception("Invalid first player");
            }
        }
        else if (repeatedMove(symbol)) {
            throw new Exception("Invalid next player");
        }
        else if (_board.tileIsAlreadyPlayed(x, y)) {
            throw new Exception("Invalid position");
        }

        updateGameState(symbol, x, y);
    }

    private boolean repeatedMove(Symbol symbol) {
        return symbol.equals(lastSymbol);
    }

    private boolean playerIsNotX(Symbol symbol) {
        return symbol.equals(Symbol.O);
    }

    private void updateGameState(Symbol symbol, int x, int y) {
        lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    private boolean isFirstMove() {
        return lastSymbol.equals(Symbol.SPACE);
    }

}

