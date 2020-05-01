public class Game {
    Board _board = new Board();

    public Game() {
        MoveValidator.lastSymbol = Symbol.SPACE;
    }

    public void Play(Coordinate coordinate, Symbol symbol) throws Exception {
        validateMove(coordinate, symbol);
        updateGameState(symbol, coordinate);
    }

    private void validateMove(Coordinate coordinate, Symbol symbol) throws Exception {
        validateFirstMove(symbol);
        validateRepeatedMove(symbol);
        _board.validateTileAlreadyPlayed(coordinate);
    }

    private void validateRepeatedMove(Symbol symbol) throws Exception {
        if (repeatedMove(symbol)) {
            throw new Exception("Invalid next player");
        }
    }

    private void validateFirstMove(Symbol symbol) throws Exception {
        if (isFirstMove()) {
            if (playerIsNotX(symbol)) {
                throw new Exception("Invalid first player");
            }
        }
    }

    private boolean repeatedMove(Symbol symbol) {
        return symbol.equals(MoveValidator.getLastSymbol());
    }

    private boolean playerIsNotX(Symbol symbol) {
        return symbol.equals(Symbol.O);
    }

    private void updateGameState(Symbol symbol, Coordinate coordinate) {
        MoveValidator.setLastSymbol(symbol);
        _board.AddTileAt(coordinate, symbol);
    }

    private boolean isFirstMove() {
        return MoveValidator.getLastSymbol().equals(Symbol.SPACE);
    }

}

