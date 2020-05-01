public class Game {
    Board _board = new Board();
    MoveValidator moveValidator = new MoveValidator();

    public Game() {
        MoveValidator.lastSymbol = Symbol.SPACE;
    }

    public void Play(Coordinate coordinate, Symbol symbol) throws Exception {
        validateMove(coordinate, symbol);
        updateGameState(symbol, coordinate);
    }

    private void validateMove(Coordinate coordinate, Symbol symbol) throws Exception {
        validateFirstMove(symbol);
        moveValidator.validateRepeatedMove(symbol);
        _board.validateTileAlreadyPlayed(coordinate);
    }

    private void validateFirstMove(Symbol symbol) throws Exception {
        if (moveValidator.lastSymbol.isFirstMove()) {
            if (playerIsNotX(symbol)) {
                throw new Exception("Invalid first player");
            }
        }
    }

    private boolean playerIsNotX(Symbol symbol) {
        return symbol.equals(Symbol.O);
    }

    private void updateGameState(Symbol symbol, Coordinate coordinate) {
        MoveValidator.setLastSymbol(symbol);
        _board.AddTileAt(coordinate, symbol);
    }

}

