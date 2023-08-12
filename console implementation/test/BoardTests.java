package test;

import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import tictactoe.Board;
import tictactoe.Mark;

public class BoardTests {
    Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void shouldThrowExceptionIfMaxDimensionExceeded() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Board(9);
        });

        String expectedMessage = "Board dimensions must be in range 3-8";
        String exceptionMessage = exception.getMessage();

        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    public void shouldReturn3x3Board() {
        assertEquals(board.toString(), "   a     b     c  \n"
                + "      |     |     \n"
                + "1     |     |     \n"
                + " _____|_____|_____\n"
                + "      |     |     \n"
                + "2     |     |     \n"
                + " _____|_____|_____\n"
                + "      |     |     \n"
                + "3     |     |     \n"
                + "      |     |     \n");
    }

    @Test
    public void shouldReturnSpaceString() {
        assertEquals(board.markAt(0, 0), " ");
    }

    @Test
    public void shouldMarkPositionAndReturnMark() {
        board.mark(0, 1, Mark.O);
        assertEquals(board.markAt(0, 1), "O");
    }

    @Test
    public void shouldReturnOpenPositions() {
        board.mark(0, 0, Mark.X);
        board.mark(1, 0, Mark.O);
        board.mark(0, 1, Mark.X);
        board.mark(2, 0, Mark.O);
        board.mark(2, 2, Mark.X);
        board.mark(1, 1, Mark.O);

        TreeSet<String> expected = new TreeSet<String>();
        expected.add("b3");
        expected.add("c1");
        expected.add("c2");

        assertEquals(expected, board.openPositions());
    }
}
