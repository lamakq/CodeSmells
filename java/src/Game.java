public class Game {
    Board _board = new Board();
    Symbol lastSymbol = Symbol.SPACE;

    public void Play(Symbol symbol, int x, int y) throws Exception {
        Play(symbol, new Coordinate(x, y));
    }

    public void Play(Symbol symbol, Coordinate coordinate) throws Exception {
        validateMove(symbol, coordinate);

        updateGameState(symbol, coordinate);
    }

    private void validateMove(Symbol symbol, Coordinate coordinate) throws Exception {
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
        _board.AddTileAt(symbol, coordinate);
    }

    private boolean isFirstMove() {
        return lastSymbol.equals(Symbol.SPACE);
    }

}

