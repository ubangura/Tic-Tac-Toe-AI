package tictactoe;

/**
 * Represents a player in a board game.
 */
public abstract class Player {
    private Mark mark;

    /**
     * Initializes this player's {@code Mark}.
     * 
     * @param mark
     */
    public Player(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    /**
     * Marks a position on the board with this player's {@code Mark}.
     * 
     * @param board
     */
    public abstract void move(Board board);
}