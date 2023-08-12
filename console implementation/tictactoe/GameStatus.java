package tictactoe;

/**
 * Represents the status of a board game.
 */
public class GameStatus {
    private final boolean gameOver;
    private final String winningMark;
    private final int winnerPoints;

    /**
     * Creates a current status for the board game.
     * 
     * @param gameOver     {@code true} if the game is over; {@code false} otherwise
     * @param winningMark  the {@code Mark} of the winning {@code Player}
     * @param winnerPoints the amount of points the {@code Player} with the winning
     *                     {@code Mark} earned
     */
    public GameStatus(boolean gameOver, String winningMark, int winnerPoints) {
        this.gameOver = gameOver;
        this.winningMark = winningMark;
        this.winnerPoints = winnerPoints;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public String getWinningMark() {
        return winningMark;
    }

    public int getWinnerPoints() {
        return winnerPoints;
    }
}
