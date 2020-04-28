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
        game.Play(Symbol.O, new Coordinate(0, 0));
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerXToPlayTwiceInARow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(0, 0));

        game.Play(Symbol.X, new Coordinate(1, 0));
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInLastPlayedPosition() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(0, 0));

        game.Play(Symbol.O, new Coordinate(0, 0));
    }

    @Test(expected=Exception.class)
    public void NotAllowPlayerToPlayInAnyPlayedPosition() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(0, 0));
        game.Play(Symbol.O, new Coordinate(1, 0));

        game.Play(Symbol.X, new Coordinate(0, 0));
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(0, 0));
        game.Play(Symbol.O, new Coordinate(1, 0));
        game.Play(Symbol.X, new Coordinate(0, 1));
        game.Play(Symbol.O, new Coordinate(1, 1));
        game.Play(Symbol.X, new Coordinate(0, 2));

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(2, 2));
        game.Play(Symbol.O, new Coordinate(0, 0));
        game.Play(Symbol.X, new Coordinate(1, 0));
        game.Play(Symbol.O, new Coordinate(0, 1));
        game.Play(Symbol.X, new Coordinate(1, 1));
        game.Play(Symbol.O, new Coordinate(0, 2));

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(1, 0));
        game.Play(Symbol.O, new Coordinate(0, 0));
        game.Play(Symbol.X, new Coordinate(1, 1));
        game.Play(Symbol.O, new Coordinate(0, 1));
        game.Play(Symbol.X, new Coordinate(1, 2));

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(0, 0));
        game.Play(Symbol.O, new Coordinate(1, 0));
        game.Play(Symbol.X, new Coordinate(2, 0));
        game.Play(Symbol.O, new Coordinate(1, 1));
        game.Play(Symbol.X, new Coordinate(2, 1));
        game.Play(Symbol.O, new Coordinate(1, 2));

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(2, 0));
        game.Play(Symbol.O, new Coordinate(0, 0));
        game.Play(Symbol.X, new Coordinate(2, 1));
        game.Play(Symbol.O, new Coordinate(0, 1));
        game.Play(Symbol.X, new Coordinate(2, 2));

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.Play(Symbol.X, new Coordinate(0, 0));
        game.Play(Symbol.O, new Coordinate(2, 0));
        game.Play(Symbol.X, new Coordinate(1, 0));
        game.Play(Symbol.O, new Coordinate(2, 1));
        game.Play(Symbol.X, new Coordinate(1, 1));
        game.Play(Symbol.O, new Coordinate(2, 2));

        Symbol winner = game._board.Winner();

        assertEquals(Symbol.O, winner);
    }
}
