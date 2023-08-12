package tictactoe;

import java.util.TreeSet;

/**
 * Represents a NxN game board. The columns are enumerated with letters
 * and the rows numbers.
 */
public class Board {
    private Mark[][] board;
    private int dimension;
    private String columnLetters = "", rowStart = "", rowEnd = "";
    public final static int MAXIMUM_BOARD_DIMENSION = 8, MINIMUM_BOARD_DIMENSION = 3;

    /**
     * Default constructor which creates a 3x3 board.
     */
    public Board() {
        this(3);
    }

    /**
     * Creates a board with dimensions equal to {@code dimension}
     * 
     * @param dimension specifies the side length of the board
     */
    public Board(int dimension) {
        if (!(isValidDimension(dimension))) {
            throw new IllegalArgumentException(
                    "Board dimensions must be in range " + MINIMUM_BOARD_DIMENSION + "-" + MAXIMUM_BOARD_DIMENSION);
        }

        this.dimension = dimension;
        board = new Mark[dimension][dimension];
        setupBoardConstants();
    }

    public int getDimension() {
        return dimension;
    }

    /**
     * Returns the row index where a move is located.
     * 
     * @param move a {@code String} in the form of a columnLetter followed by a
     *             rowNumber
     * @return the corresponding row index on a board
     */
    public static int getMoveRowIndex(String move) {
        return Character.getNumericValue(move.charAt(1)) - 1;
    }

    /**
     * Returns the column index where a move is located.
     * 
     * @param move a {@code String} in the form of a columnLetter followed by a
     *             rowNumber
     * @return the corresponding column index on a board
     */
    public static int getMoveColumnIndex(String move) {
        return move.charAt(0) - 'a';
    }

    public static boolean isValidDimension(int dimension) {
        // Dimensions greater than 8 cause exponentially longer wait times for the AI
        // move
        return dimension >= MINIMUM_BOARD_DIMENSION && dimension <= MAXIMUM_BOARD_DIMENSION;
    }

    /**
     * Returns the {@code Mark} at the specified position on the board.
     * 
     * @param rowIndex
     * @param colIndex
     * @return the mark's enum declaration if the position is marked, a space
     *         otherwise
     */
    public String markAt(int rowIndex, int colIndex) {
        Mark mark = board[rowIndex][colIndex];

        if (mark == null) {
            return " ";
        }

        return mark.name();
    }

    /**
     * Marks this board at the specified position with the mark.
     * 
     * @param rowIndex
     * @param colIndex
     * @param mark
     */
    public void mark(int rowIndex, int colIndex, Mark mark) {
        board[rowIndex][colIndex] = mark;
    }

    /**
     * Returns all unmarked positions on this board. Positions are defined in the
     * form of columnLetter followed by rowNumber. For example,
     * {@code [a0, a1, a2, a3]}.
     * 
     * @return open positions on this board
     */
    public TreeSet<String> openPositions() {
        TreeSet<String> openPositions = new TreeSet<String>();

        for (int row = 0; row < dimension; row++) {
            char nextLetter = 'a';
            for (int col = 0; col < dimension; col++) {
                if (board[row][col] == null) {
                    openPositions.add("" + nextLetter + (row + 1));
                }
                nextLetter++;
            }
        }

        return openPositions;
    }

    /**
     * Returns a count of all unmarked positions on this board.
     * 
     * @return count of open positions on this board
     */
    public int numberOfOpenPositions() {
        int count = 0;

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (markAt(row, col).equals(" ")) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Removes all marks from this board.
     */
    public void clear() {
        board = new Mark[dimension][dimension];
    }

    @Override
    public String toString() {
        String boardStr = columnLetters;

        for (int row = 0; row < dimension; row++) {
            boardStr += " " + rowStart + (row + 1);

            for (int col = 0; col < dimension; col++) {
                boardStr += "  " + markAt(row, col) + "  ";
                boardStr += col != dimension - 1 ? "|" : "\n";
            }

            boardStr += " " + (row != dimension - 1 ? rowEnd : rowStart);
        }

        return boardStr;
    }

    /**
     * Defines the three unchanging parts of this board based on this board's
     * dimensions: the enumerated columns, the
     * first line of each row, and the last line of each row.
     */
    private void setupBoardConstants() {
        char nextLetter = 'a';
        int lastCol = dimension - 1;

        for (int col = 0; col < dimension; col++) {
            columnLetters += "   " + nextLetter++ + "  ";
            rowStart += "     ";
            rowEnd += "_____";

            columnLetters += (col == lastCol) ? "\n" : "";
            rowStart += (col != lastCol) ? "|" : "\n";
            rowEnd += (col != lastCol) ? "|" : "\n";
        }
    }
}