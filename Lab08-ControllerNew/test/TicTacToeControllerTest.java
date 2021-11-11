
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

import java.io.StringReader;


/**
 * Test cases for the tic tac toe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  private TicTacToe m;
  
  @Before
  public void setU() {
    m = new TicTacToeModel();
  }
  // Providing this shell for you to write your
  // own test cases for the TicTacToe controller
  // You DO NOT NEED to implement tests for the provided model
  
  // TODO: Implement your own tests cases for the controller

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(null);
  }
  
  @Test
  public void testInvaildRowInput() {
    StringReader input = new StringReader("-1 1 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Not a valid move: -1, 1\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testInvaildColInput() {
    StringReader input = new StringReader("1 -1 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Not a valid move: 1, -1\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testRowOutOfBounds() {
    StringReader input = new StringReader("8 1 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Not a valid move: 8, 1\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testColOutOfBounds() {
    StringReader input = new StringReader("1 7 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Not a valid move: 1, 7\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testGameQuitRow() {
    StringReader input = new StringReader("q 1");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testGameQuitCol() {
    StringReader input = new StringReader("1 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testValidMove() {
    StringReader input = new StringReader("1 1 2 2 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Game quit! Ending game state:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testOverlapMove() {
    StringReader input = new StringReader("1 1 1 1 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + "Not a valid move: 1, 1\n"
        + "Game quit! Ending game state:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testInValidMoveContinue() {
    StringReader input = new StringReader("1 1 1 1 2 2 q");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + "Not a valid move: 1, 1\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Game quit! Ending game state:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + "   |   |  \n", g.toString());
  }
  
  @Test
  public void testXWins() {
    StringReader input = new StringReader("1 1 2 2 3 1 2 1 2 3 1 3 3 2 1 2 3 3");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + " X |   |  \n"
        + "Enter a move for O:\n"
        + " X |   |  \n"
        + "-----------\n"
        + " O | O |  \n"
        + "-----------\n"
        + " X |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X |   |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X |   |  \n"
        + "Enter a move for X:\n"
        + " X |   | O\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X |  \n"
        + "Enter a move for O:\n"
        + " X | O | O\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X |  \n"
        + "Enter a move for X:\n"
        + " X | O | O\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | X\n"
        + "Game is over! X wins.", g.toString());
  }
  
  @Test
  public void testTie() {
    StringReader input = new StringReader("2 2 1 1 2 1 3 1 1 3 2 3 1 2 3 2 3 3");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " O |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " O |   |  \n"
        + "-----------\n"
        + " X | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " O |   |  \n"
        + "-----------\n"
        + " X | X |  \n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for X:\n"
        + " O |   | X\n"
        + "-----------\n"
        + " X | X |  \n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for O:\n"
        + " O |   | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for X:\n"
        + " O | X | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for O:\n"
        + " O | X | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O | O |  \n"
        + "Enter a move for X:\n"
        + " O | X | X\n"
        + "-----------\n"
        + " X | X | O\n"
        + "-----------\n"
        + " O | O | X\n"
        + "Game is over! Tie game.", g.toString());
  }
  
  @Test
  public void testYWins() {
    StringReader input = new StringReader("1 1 1 3 2 2 2 3 3 1 3 3");
    Appendable g = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, g);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + " X |   |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + " X |   | O\n"
        + "Game is over! O wins.", g.toString());
  }
}
