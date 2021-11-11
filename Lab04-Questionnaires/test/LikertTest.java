

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.Question;

/**
 * Testing if the Likert Class not only works but works all the time.
 */
public class LikertTest {
  
  private Question likert1;
  
  /**
   * Efficient way of object creation.
   * @param question The likert question to be passed.
   * @return A likert object.
   */
  
  public Question makeLikert(String question) {
    return new Likert(question);
  }

  /**
   * Setting up object for testing.
   */
  @Before
  public void setUp() {
    likert1 = new Likert(
        "It was easy to navigate the website to find what I was looking for.");
  }
  
  /**
   * Testing when user forgets to enter the question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForNull() {
    makeLikert(null);
  }
  
  /**
   * Testing when user forgets to enter the question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testForEmpty() {
    makeLikert("");
  }
  
  /**
   * Testing if the user's input falls in the correct range of answers.
   */
  @Test
  public void testValidAnswer() {
    assertEquals("Correct", likert1.answer("2"));
  }
  
  /**
   * Testing when a user enters a number out of the expected range.
   */
  @Test
  public void testInvalidAnswer() {
    assertEquals("Incorrect", likert1.answer("6"));
  }
}
