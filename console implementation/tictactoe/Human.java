package tictactoe;

import java.util.Scanner;

/**
 * Represents a human {@code Player}.
 */
public class Human extends Player {
    
    /**
     * Creates a human and initializes this human's {@code Mark}.
     * 
     * @param mark
     */
    public Human(Mark mark) {
        super(mark);
    }

    @Override
    public void move(Board board) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        String move;

        do {
            System.out.print(getMark() + "'s turn. Enter a move: ");
            move = scanner.nextLine();
            System.out.println();
        } while (!(isCorrectFormat(move) && isOpenPosition(board, move)));

        board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), getMark());
    }

    private boolean isCorrectFormat(String move) {
        String formatHint = "The move must be a column letter followed by a row number.";

        if (!(move.length() == 2)) {
            System.out.println(formatHint);
            return false;
        }

        if (!(Character.isLowerCase(move.charAt(0)) && Character.isDigit(move.charAt(1)))) {
            System.out.println(formatHint);
            return false;
        }

        return true;
    }

    private boolean isOpenPosition(Board board, String move) {
        int rowIndex = Board.getMoveRowIndex(move);
        int colIndex = Board.getMoveColumnIndex(move);
        int boardDimension = board.getDimension();

        if (!((rowIndex >= 0 && rowIndex < boardDimension) && colIndex < boardDimension)) {
            System.out.println("The move must be within the bounds of the board.");
            return false;
        }

        if (!(board.markAt(rowIndex, colIndex).equals(" "))) {
            System.out.println("The move must be to an open position.");
            return false;
        }

        return true;
    }
}