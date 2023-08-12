package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import tictactoe.Board;
import tictactoe.Mark;
import tictactoe.TicTacToe;

public class TicTacToeTests {
    Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void shouldReturnNullForWinner() {
        assertEquals(false, TicTacToe.getGameStatus(board).getGameOver());

        board.mark(2, 0, Mark.O);
        board.mark(2, 1, Mark.O);

        board.mark(0, 0, Mark.X);
        board.mark(1, 0, Mark.O);

        board.mark(0, 2, Mark.X);
        board.mark(1, 1, Mark.O);

        assertEquals(false, TicTacToe.getGameStatus(board).getGameOver());
    }

    @Test
    public void shouldReturnOCheckRowsForWinner() {
        board.mark(1, 0, Mark.O);
        board.mark(1, 1, Mark.O);
        board.mark(1, 2, Mark.O);
        assertEquals("O", TicTacToe.getGameStatus(board).getWinningMark());
    }

    @Test
    public void shouldReturnOCheckColumnsForWinner() {
        board.mark(0, 1, Mark.O);
        board.mark(1, 1, Mark.O);
        board.mark(2, 1, Mark.O);
        assertEquals("O", TicTacToe.getGameStatus(board).getWinningMark());
    }

    @Test
    public void shouldReturnOCheckDiagonalsForWinnerLeftToRight() {
        board.mark(0, 0, Mark.O);
        board.mark(1, 1, Mark.O);
        board.mark(2, 2, Mark.O);
        assertEquals("O", TicTacToe.getGameStatus(board).getWinningMark());
    }

    @Test
    public void shouldReturnOCheckDiagonalsForWinnerRightToLeft() {
        board.mark(0, 2, Mark.O);
        board.mark(1, 1, Mark.O);
        board.mark(2, 0, Mark.O);
        assertEquals("O", TicTacToe.getGameStatus(board).getWinningMark());
    }

    @Test
    public void shouldDraw() {
        board.mark(2, 2, Mark.X);
        board.mark(2, 1, Mark.O);
        board.mark(2, 0, Mark.X);
        board.mark(1, 1, Mark.O);
        board.mark(1, 2, Mark.X);
        board.mark(0, 2, Mark.O);
        board.mark(0, 0, Mark.X);
        board.mark(1, 0, Mark.O);
        board.mark(0, 1, Mark.X);

        assertEquals(true, TicTacToe.getGameStatus(board).getGameOver());
        assertEquals(null, TicTacToe.getGameStatus(board).getWinningMark());
    }
}
