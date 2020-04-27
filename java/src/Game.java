public class Game {
    public static final char SPACE = ' ';
    public static final char CHAR_O = 'O';
    private Board _board = new Board();
    Symbol lastSymbol = new Symbol();

    public Game() {
        this._board = new Board();
    }

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (lastSymbol.get_lastSymbol() == SPACE) {
            //if player is X
            if (symbol == CHAR_O) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == lastSymbol.get_lastSymbol()) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != SPACE) {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol.set_lastSymbol(symbol);
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (_board.TileAt(0, 0).Symbol != SPACE &&
                _board.TileAt(0, 1).Symbol != SPACE &&
                _board.TileAt(0, 2).Symbol != SPACE) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(1, 0).Symbol != SPACE &&
                _board.TileAt(1, 1).Symbol != SPACE &&
                _board.TileAt(1, 2).Symbol != SPACE) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(2, 0).Symbol != SPACE &&
                _board.TileAt(2, 1).Symbol != SPACE &&
                _board.TileAt(2, 2).Symbol != SPACE) {
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

