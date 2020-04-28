import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game_Should {
    private Game game;

    @Before
    public void InitializeGame(){
        game = new Game();
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerOToPlayFirst() throws Exception {
        game.Play(new Coordinate(0, 0), Symbol.O);
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerXToPlayTwiceInARow() throws Exception
    {
        game.Play(new Coordinate(0, 0), Symbol.X);

        game.Play(new Coordinate(1, 0), Symbol.X);
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInLastPlayedPosition() throws Exception
    {
        game.Play(new Coordinate(0, 0), Symbol.X);

        game.Play(new Coordinate(0, 0), Symbol.O);
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInAnyPlayedPosition() throws Exception
    {
        game.Play(new Coordinate(0, 0), Symbol.X);
        game.Play(new Coordinate(1, 0), Symbol.O);

        game.Play(new Coordinate(0, 0), Symbol.X);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(new Coordinate(0, 0), Symbol.X);
        game.Play(new Coordinate(1, 0), Symbol.O);
        game.Play(new Coordinate(0, 1), Symbol.X);
        game.Play(new Coordinate(1, 1), Symbol.O);
        game.Play(new Coordinate(0, 2), Symbol.X);

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(new Coordinate(2, 2), Symbol.X);
        game.Play(new Coordinate(0, 0), Symbol.O);
        game.Play(new Coordinate(1, 0), Symbol.X);
        game.Play(new Coordinate(0, 1), Symbol.O);
        game.Play(new Coordinate(1, 1), Symbol.X);
        game.Play(new Coordinate(0, 2), Symbol.O);

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(new Coordinate(1, 0), Symbol.X);
        game.Play(new Coordinate(0, 0), Symbol.O);
        game.Play(new Coordinate(1, 1), Symbol.X);
        game.Play(new Coordinate(0, 1), Symbol.O);
        game.Play(new Coordinate(1, 2), Symbol.X);

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(new Coordinate(0, 0), Symbol.X);
        game.Play(new Coordinate(1, 0), Symbol.O);
        game.Play(new Coordinate(2, 0), Symbol.X);
        game.Play(new Coordinate(1, 1), Symbol.O);
        game.Play(new Coordinate(2, 1), Symbol.X);
        game.Play(new Coordinate(1, 2), Symbol.O);

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(new Coordinate(2, 0), Symbol.X);
        game.Play(new Coordinate(0, 0), Symbol.O);
        game.Play(new Coordinate(2, 1), Symbol.X);
        game.Play(new Coordinate(0, 1), Symbol.O);
        game.Play(new Coordinate(2, 2), Symbol.X);

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(new Coordinate(0, 0), Symbol.X);
        game.Play(new Coordinate(2, 0), Symbol.O);
        game.Play(new Coordinate(1, 0), Symbol.X);
        game.Play(new Coordinate(2, 1), Symbol.O);
        game.Play(new Coordinate(1, 1), Symbol.X);
        game.Play(new Coordinate(2, 2), Symbol.O);

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.O, winner);
    }
}
