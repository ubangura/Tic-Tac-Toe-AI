package tictactoe;

/**
 * Represents a game of Tic Tac Toe.
 */
public class TicTacToe {
    private Board board;
    private Player playerX, playerO;

    /**
     * Creates a Tic Tac Toe game with a 3x3 {@code Board}.
     * 
     * @param playerX
     * @param playerO
     */
    public TicTacToe(Player playerX, Player playerO) {
        this(3, playerX, playerO);
    }

    /**
     * Creates a Tic Tac Toe game with the board dimensions equal to
     * {@code boardDimension}.
     * 
     * @param boardDimension
     * @param playerX
     * @param playerO
     */
    public TicTacToe(int boardDimension, Player playerX, Player playerO) {
        board = new Board(boardDimension);
        this.playerX = playerX;
        this.playerO = playerO;
    }

    /**
     * Starts this Tic Tac Toe game.
     */
    public void play() {
        GameStatus gameStatus = new GameStatus(false, null, 0);
        boolean playerXTurn = true;

        int totalMoves = 0;
        int minNumberOfMovesForWinner = (board.getDimension() * 2) - 1;

        do {
            System.out.println(board);

            if (playerXTurn) {
                playerX.move(board);
            } else {
                playerO.move(board);
            }
            playerXTurn = !playerXTurn;

            totalMoves++;

            if (totalMoves >= minNumberOfMovesForWinner) {
                gameStatus = TicTacToe.getGameStatus(board);
            }

        } while (gameStatus.getGameOver() != true);

        System.out.println(board);

        if (gameStatus.getWinningMark() == null) {
            System.out.println("Draw!");
        } else {
            System.out
                    .println(gameStatus.getWinningMark() + " wins! Plus " + gameStatus.getWinnerPoints() + " points.");
        }
    }

    /**
     * Returns a {@code GameStatus} for the current board. The default values for
     * the {@code gameOver}, {@code winningMark}, and {@code winnerPoints} fields
     * are {@code false}, {@code null}, and {@code 0} respectively if no winner is
     * found.
     * 
     * <p>
     * Points for the winning {@code Player} is calculated based on the {@code AI}
     * utility function.
     * <p>
     * 
     * @param board
     * @return {@code GameStatus} for the board game
     */
    public static GameStatus getGameStatus(Board board) {
        boolean gameOver = false;
        String winningMark;
        int winnerPoints = 0;

        int numOpenPositions = board.numberOfOpenPositions();

        if ((winningMark = TicTacToe.checkRowsForWinner(board)) != null
                || (winningMark = TicTacToe.checkColumnsForWinner(board)) != null
                || (winningMark = TicTacToe.checkDiagonalsForWinner(board)) != null) {
            gameOver = true;
            winnerPoints = numOpenPositions + 1;
        }

        if (numOpenPositions == 0) {
            gameOver = true;
        }

        return new GameStatus(gameOver, winningMark, winnerPoints);
    }

    /**
     * Determines if there is any {@code Mark} that occupies all positions in any
     * row, a winning {@code Mark}.
     * 
     * @param board
     * @return the winning mark's enum declaration if a winner is found;
     *         {@code null}
     *         otherwise
     */
    public static String checkRowsForWinner(Board board) {
        String winningMark = null, currentMark;

        for (int row = 0; row < board.getDimension(); row++) {
            winningMark = board.markAt(row, 0);

            for (int col = 1; col < board.getDimension(); col++) {
                currentMark = board.markAt(row, col);

                if (!isMatchingMark(winningMark, currentMark)) {
                    winningMark = null;
                    break; // No winner in this row
                }
            }

            if (winningMark != null) {
                break; // Found a winner in this row
            }
        }

        return winningMark;
    }

    /**
     * Determines if there is any {@code Mark} that occupies all positions in any
     * column, a winning {@code Mark}.
     * 
     * @param board
     * @return the winning mark's enum declaration if a winner is found;
     *         {@code null}
     *         otherwise
     */
    public static String checkColumnsForWinner(Board board) {
        String winningMark = null, currentMark;

        for (int col = 0; col < board.getDimension(); col++) {
            winningMark = board.markAt(0, col);

            for (int row = 1; row < board.getDimension(); row++) {
                currentMark = board.markAt(row, col);

                if (!isMatchingMark(winningMark, currentMark)) {
                    winningMark = null;
                    break; // No winner in this column
                }
            }

            if (winningMark != null) {
                break; // Found a winner in this column
            }
        }

        return winningMark;
    }

    /**
     * Determines if there is any {@code Mark} that occupies all positions in any
     * diagonal, a winning {@code Mark}.
     * 
     * @param board
     * @return the winning mark's enum declaration if a winner is found;
     *         {@code null}
     *         otherwise
     */
    public static String checkDiagonalsForWinner(Board board) {
        String winningMark = board.markAt(0, 0);
        String currentMark;

        for (int i = 1; i < board.getDimension(); i++) {
            currentMark = board.markAt(i, i);

            if (!isMatchingMark(winningMark, currentMark)) {
                winningMark = null;
                break; // No winner in the left to right diagonal
            }
        }

        if (winningMark != null) {
            return winningMark; // Found a winner in the left to right diagonal
        }

        int colIndexStart = board.getDimension() - 1;

        winningMark = board.markAt(0, colIndexStart);

        for (int i = 1; i < board.getDimension(); i++) {
            currentMark = board.markAt(i, colIndexStart - i);

            if (!isMatchingMark(winningMark, currentMark)) {
                winningMark = null;
                break; // No winner in the right to left diagonal
            }
        }

        return winningMark;
    }

    /**
     * Determines if {@code currentMark} is equal to {@code winningMark} with the
     * exception that {@code currentMark} is not a space.
     * 
     * @param winningMark
     * @param currentMark
     * @return {@code true} if the parameters are equal; {@code false} otherwise
     */
    private static boolean isMatchingMark(String winningMark, String currentMark) {
        if (currentMark.equals(" ") || !(winningMark.equals(currentMark))) {
            return false;
        }

        return true;
    }
}