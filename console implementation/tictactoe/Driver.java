package tictactoe;

public class Driver {
  public static void main(String[] args) {
    Player humanX = new Human(Mark.X);
    Player humanO = new Human(Mark.O);
    Player aiX = new AI(Mark.X);
    Player aiO = new AI(Mark.O, 2);
    TicTacToe ticTacToe = new TicTacToe(3, aiX, aiO);
    ticTacToe.play();
  }
}