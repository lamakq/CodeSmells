public class Game {
    public static final char SPACE = ' ';
    private Board _board = new Board();
    Symbol lastSymbol = new Symbol(Game.SPACE);

    public void Play(Symbol symbol, int x, int y) throws Exception {
        if (isFirstMove()) {
            if (playerIsNotX(symbol)) {
                throw new Exception("Invalid first player");
            }
        }
        else if (repeatedMove(symbol)) {
            throw new Exception("Invalid next player");
        }
        else if (tileIsAlreadyPlayed(x, y)) {
            throw new Exception("Invalid position");
        }

        updateGameState(symbol, x, y);
    }

    private boolean tileIsAlreadyPlayed(int x, int y) {
        return !_board.TileAt(x, y).getSymbol().equals(Symbol.SPACE);
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
        //if the positions in first row are taken
        if (tileIsAlreadyPlayed(0, 0) &&
                tileIsAlreadyPlayed(0, 1) &&
                tileIsAlreadyPlayed(0, 2)) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).getSymbol().equals(
                    _board.TileAt(0, 1).getSymbol()) &&
                    _board.TileAt(0, 2).getSymbol().equals(_board.TileAt(0, 1).getSymbol())) {
                return _board.TileAt(0, 0).getSymbol();
            }
        }

        //if the positions in first row are taken
        if (tileIsAlreadyPlayed(1, 0) &&
                tileIsAlreadyPlayed(1, 1) &&
                tileIsAlreadyPlayed(1, 2)) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).getSymbol().equals(
                    _board.TileAt(1, 1).getSymbol()) &&
                    _board.TileAt(1, 2).getSymbol().equals(
                            _board.TileAt(1, 1).getSymbol())) {
                return _board.TileAt(1, 0).getSymbol();
            }
        }

        //if the positions in first row are taken
        if (tileIsAlreadyPlayed(2, 0) &&
                tileIsAlreadyPlayed(2, 1) &&
                tileIsAlreadyPlayed(2, 2)) {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).getSymbol().equals(
                    _board.TileAt(2, 1).getSymbol()) &&
                    _board.TileAt(2, 2).getSymbol().equals(
                            _board.TileAt(2, 1).getSymbol())) {
                return _board.TileAt(2, 0).getSymbol();
            }
        }

        return Symbol.SPACE;
    }
}

