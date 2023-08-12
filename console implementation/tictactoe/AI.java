package tictactoe;

import java.util.TreeSet;

/**
 * Represents an AI {@code Player}.
 */
public class AI extends Player {
    private int depth;

    /**
     * Creates an AI and initializes this AI's {@code Mark}.
     * 
     * @param mark
     */
    public AI(Mark mark) {
        this(mark, Integer.MAX_VALUE);
    }

    /**
     * Creates an AI and initializes this AI's {@code Mark} and searching depth.
     * 
     * @param mark
     * @param depth specifies the number of moves this AI can look ahead in
     *              {@code minimax}
     */
    public AI(Mark mark, int depth) {
        super(mark);
        this.depth = depth;
    }

    @Override
    public void move(Board board) {
        TreeSet<String> openPositions = board.openPositions();
        String bestMove = openPositions.first();

        int maxEvaluation = Integer.MIN_VALUE;

        Mark opponentMark = getOpponentMark();

        for (String move : openPositions) {
            board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), getMark());

            int evaluation = minimax(board, depth - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, false, opponentMark);
            if (evaluation > maxEvaluation) {
                maxEvaluation = evaluation;
                bestMove = move;
            }

            board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), null);
        }

        board.mark(Board.getMoveRowIndex(bestMove), Board.getMoveColumnIndex(bestMove), getMark());
    }

    /**
     * Returns the utility value of the best sequence of moves derived from the
     * current state of the board from the perspective of this AI.
     * 
     * @param board
     * @param depth
     * @param maximizerBestScore
     * @param minimzerBestScore
     * @param maximizingPlayer
     * @param opponentMark
     * @return the utility value of the board
     */
    private int minimax(Board board, int depth, int maximizerBestScore, int minimzerBestScore, boolean maximizingPlayer,
            Mark opponentMark) {
        GameStatus gameStatus = TicTacToe.getGameStatus(board);
        if (depth == 0 || gameStatus.getGameOver() == true) {
            return utility(gameStatus);
        }

        TreeSet<String> openPositions = board.openPositions();

        if (maximizingPlayer) {
            int maxEvaluation = Integer.MIN_VALUE;

            for (String move : openPositions) {
                board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), getMark());

                int evaluation = minimax(board, depth - 1, maximizerBestScore, minimzerBestScore, false, opponentMark);
                maxEvaluation = Math.max(maxEvaluation, evaluation);
                maximizerBestScore = Math.max(maximizerBestScore, evaluation);

                board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), null);

                if (minimzerBestScore <= maximizerBestScore) {
                    break; // The maximizer has a better sequence of moves elsewhere in the tree
                }
            }

            return maxEvaluation;
        } else {
            int minEvaluation = Integer.MAX_VALUE;

            for (String move : openPositions) {
                board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), opponentMark);

                int evaluation = minimax(board, depth - 1, maximizerBestScore, minimzerBestScore, true, opponentMark);
                minEvaluation = Math.min(minEvaluation, evaluation);
                minimzerBestScore = Math.min(minimzerBestScore, evaluation);

                board.mark(Board.getMoveRowIndex(move), Board.getMoveColumnIndex(move), null);

                if (minimzerBestScore <= maximizerBestScore) {
                    break; // The maximizer has a better sequence of moves elsewhere in the tree
                }
            }

            return minEvaluation;
        }
    }

    /**
     * Returns the utility value of the current state of the board from the
     * perspective of this AI.
     * 
     * <p>
     * A utility function will define an order of preferences of various game
     * states. This AI prefers first positive values (this AI has won
     * the game), second 0 (this AI has drawn the game), and lastly a negative value
     * (this AI has lost).
     * <p>
     * 
     * @param gameStatus
     * @return the utility value
     */
    private int utility(GameStatus gameStatus) {
        if (gameStatus.getWinningMark() == null) {
            return 0;
        } else if (gameStatus.getWinningMark().equals(getMark().name())) {
            return gameStatus.getWinnerPoints();
        }

        return gameStatus.getWinnerPoints() * -1;
    }

    private Mark getOpponentMark() {
        Mark[] marks = Mark.values();

        Mark opponentMark = null;

        for (int i = 0; i < marks.length; i++) {
            if (!marks[i].equals(getMark())) {
                opponentMark = marks[i];
            }
        }

        return opponentMark;
    }
}