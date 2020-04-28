public class Game {
    private Board _board = new Board();
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

    public Symbol Winner() {
        if (firstRowPositionsAreTaken()) {
            if (firstRowHasSameSymbols()) {
                return _board.TileAt(0, 0).getSymbol();
            }
        }

        if (secondRowPositionsAreTaken()) {
            if (secondRowHasSameSymbols()) {
                return _board.TileAt(1, 0).getSymbol();
            }
        }

        if (thirdRowPositionsAreTaken()) {
            if (thirdRowHasSameSymbols()) {
                return _board.TileAt(2, 0).getSymbol();
            }
        }

        return Symbol.SPACE;
    }

    private boolean thirdRowHasSameSymbols() {
        return _board.TileAt(2, 0).getSymbol().equals(
                _board.TileAt(2, 1).getSymbol()) &&
                _board.TileAt(2, 2).getSymbol().equals(
                        _board.TileAt(2, 1).getSymbol());
    }

    private boolean thirdRowPositionsAreTaken() {
        return _board.tileIsAlreadyPlayed(2, 0) &&
                _board.tileIsAlreadyPlayed(2, 1) &&
                _board.tileIsAlreadyPlayed(2, 2);
    }

    private boolean secondRowHasSameSymbols() {
        return _board.TileAt(1, 0).getSymbol().equals(
                _board.TileAt(1, 1).getSymbol()) &&
                _board.TileAt(1, 2).getSymbol().equals(
                        _board.TileAt(1, 1).getSymbol());
    }

    private boolean secondRowPositionsAreTaken() {
        return _board.tileIsAlreadyPlayed(1, 0) &&
                _board.tileIsAlreadyPlayed(1, 1) &&
                _board.tileIsAlreadyPlayed(1, 2);
    }

    private boolean firstRowHasSameSymbols() {
        return _board.TileAt(0, 0).getSymbol().equals(
                _board.TileAt(0, 1).getSymbol()) &&
                _board.TileAt(0, 2).getSymbol().equals(_board.TileAt(0, 1).getSymbol());
    }

    private boolean firstRowPositionsAreTaken() {
        return _board.tileIsAlreadyPlayed(0, 0) &&
                _board.tileIsAlreadyPlayed(0, 1) &&
                _board.tileIsAlreadyPlayed(0, 2);
    }
}

