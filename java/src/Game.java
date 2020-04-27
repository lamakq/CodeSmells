public class Game {
    public static final char SPACE = ' ';
    public static final char CHAR_O = 'O';
    private Board _board = new Board();
    Symbol lastSymbol = new Symbol();

    public void Play(char symbol, int x, int y) throws Exception {
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
        return _board.TileAt(x, y).Symbol != SPACE;
    }

    private boolean repeatedMove(char symbol) {
        return symbol == lastSymbol.get();
    }

    private boolean playerIsNotX(char symbol) {
        return symbol == CHAR_O;
    }

    private void updateGameState(char symbol, int x, int y) {
        lastSymbol.set(symbol);
        _board.AddTileAt(symbol, x, y);
    }

    private boolean isFirstMove() {
        return lastSymbol.get() == SPACE;
    }

    public char Winner() {
        //if the positions in first row are taken
        if (tileIsAlreadyPlayed(0, 0) &&
                tileIsAlreadyPlayed(0, 1) &&
                tileIsAlreadyPlayed(0, 2)) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (tileIsAlreadyPlayed(1, 0) &&
                tileIsAlreadyPlayed(1, 1) &&
                tileIsAlreadyPlayed(1, 2)) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (tileIsAlreadyPlayed(2, 0) &&
                tileIsAlreadyPlayed(2, 1) &&
                tileIsAlreadyPlayed(2, 2)) {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).Symbol ==
                    _board.TileAt(2, 1).Symbol &&
                    _board.TileAt(2, 2).Symbol ==
                            _board.TileAt(2, 1).Symbol) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return SPACE;
    }
}

