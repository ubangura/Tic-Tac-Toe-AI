package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import tictactoe.Board;
import tictactoe.Human;
import tictactoe.Mark;

public class HumanTests {
    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private ByteArrayInputStream inputStreamCaptor; // NullPointerException if reassigning standard in to this in
                                                    // setup()
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Board board;
    Human human;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
        board = new Board();
        human = new Human(Mark.O);
    }

    @After
    public void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    public void shouldMarkPosition() {
        String userInput = "b2";
        inputStreamCaptor = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStreamCaptor);

        human.move(board);

        assertEquals("O", board.markAt(1, 1));
    }

    @Test
    public void shouldFailFormatCheck() {
        String userInput = String.format("1a%sa1", System.lineSeparator());
        inputStreamCaptor = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStreamCaptor);

        human.move(board);

        String expected = "The move must be a column letter followed by a row number.";
        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        String actual = lines[1];

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFailIsOpenPositionAlreadyMarkedPosition() {
        board.mark(0, 0, Mark.X);

        String userInput = String.format("a1%sc3", System.lineSeparator());
        inputStreamCaptor = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStreamCaptor);

        human.move(board);

        String expected = "The move must be to an open position.";
        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        String actual = lines[1];

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFailIsOpenPositionOutOfBoundsRow() {
        board.mark(0, 0, Mark.X);

        String userInput = String.format("b0%sc3", System.lineSeparator());
        inputStreamCaptor = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStreamCaptor);

        human.move(board);

        String expected = "The move must be within the bounds of the board.";
        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        String actual = lines[1];

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFailIsOpenPositionOutOfBoundsColumn() {
        board.mark(0, 0, Mark.X);

        String userInput = String.format("d1%sc3", System.lineSeparator());
        inputStreamCaptor = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStreamCaptor);

        human.move(board);

        String expected = "The move must be within the bounds of the board.";
        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        String actual = lines[1];

        assertEquals(expected, actual);
    }
}
