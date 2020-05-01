public class Game {
    Board _board = new Board();
    MoveValidator moveValidator = new MoveValidator();

    public void Play(Coordinate coordinate, Symbol symbol) throws Exception {
        validateMove(coordinate, symbol);
        updateGameState(symbol, coordinate);
    }

    private void validateMove(Coordinate coordinate, Symbol symbol) throws Exception {
        moveValidator.validateFirstMove(symbol, this);
        moveValidator.validateRepeatedMove(symbol);
        _board.validateTileAlreadyPlayed(coordinate);
    }

    private void updateGameState(Symbol symbol, Coordinate coordinate) {
        moveValidator.setLastSymbol(symbol);
        _board.AddTileAt(coordinate, symbol);
    }

}

