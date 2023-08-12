package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tictactoe.AI;
import tictactoe.Mark;
import tictactoe.TicTacToe;

public class AITests {
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    AI aiX, aiO;
    TicTacToe ticTacToe;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
        aiX = new AI(Mark.X);
        aiO = new AI(Mark.O);
        ticTacToe = new TicTacToe(aiX, aiO);
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
    
    @Test
    public void shouldDraw() {
        ticTacToe.play();

        String expected = "Draw!";

        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        String actual = lines[lines.length - 1]; 

        assertEquals(expected, actual);
    }
}
