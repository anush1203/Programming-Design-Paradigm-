package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the TicTacToe MVC
 * assignment.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param in the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    boolean temp;
    if (m == null) {
      throw new IllegalArgumentException("Not a valid model");
    }
    temp = true;
    while (!m.isGameOver()) {
      int row = 0;
      int col = 0;
      try {
        if (temp) {
          out.append(m.toString() + "\n");
          out.append("Enter a move for " + m.getTurn().toString() + ":\n");
          temp = false;
        }

        String input = scan.next();
        if (input.equalsIgnoreCase("q")) {
          out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
          break;
        }
        try {
          row = Integer.parseInt(input) - 1;
          input = scan.next();
          if (input.equalsIgnoreCase("q")) {
            out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
            break;
          }
          col = Integer.parseInt(input) - 1;
          m.move(row, col);
          temp = true;
        } catch (NumberFormatException e) {
          out.append("Not a valid number: " + input + "\n");
        } catch (IllegalArgumentException i) {
          out.append("Not a valid move: " + (row + 1) + ", " + (col + 1) + "\n");
        }
      } catch (IOException e) {
        throw new IllegalStateException("Append failed");
      }
    }

    if (m.isGameOver()) {
      try {
        out.append(m.toString() + "\n");
        if (m.getWinner() == Player.X) {
          out.append("Game is over! X wins.");
        } else if (m.getWinner() == Player.O) {
          out.append("Game is over! O wins.");
        } else {
          out.append("Game is over! Tie game.");
        }
      } catch (IOException e) {
        throw new IllegalStateException("Append failed", e);
      }
    }
  }
}
