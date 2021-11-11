

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.MultipleChoice;
import questions.Question;

/**
 * Testing if the multiple choice questions not only work but they always work.
 */
public class MultipleChoiceTest {

  private Question multiChoice1;
  private Question multiChoice2;

  /**
   * Setting up objects which will be used to carry out tests.
   */
  @Before
  public void setUp() {
    multiChoice1 = new MultipleChoice(
        "Which one of these characters is not friends with Harry Potter?", "3", "1", "2", "3", "4");
    multiChoice2 = new MultipleChoice(
        "In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?", "2", "1", "2",
        "3", "4", "5");
  }

  /**
   * An efficient way for constructing objects for testing.
   * 
   * @param question The Question to be passed.
   * @param correctAnswer The correct answer for a particular question.
   * @param options The multiple options that are part of the question.
   * @return A true/false question type object.
   */
  public Question makeMcq(String question, String correctAnswer, String... options) {
    return new MultipleChoice(question, correctAnswer, options);
  }

  /**
   * Testing if we get an exception if question is not entered.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullQuestion() {
    makeMcq(null, "3", "1", "2", "3", "4");
  }

  /**
   * Testing if we get an exception if question is not entered.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestion() {
    makeMcq("", "3", "1", "2", "3", "4");
  }

  /**
   * Testing if question maker does not pass correct.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAnswer() {
    makeMcq("In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?", null, "1",
        "2", "3", "4");
  }

  /**
   * Testing if question maker does not pass correct.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnswer() {
    makeMcq("In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?", "", "1",
        "2", "3", "4");
  }

  /**
   * Testing if question maker passes less than 3 options.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLessThanThree() {
    makeMcq("In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?", "1", "1");
  }

  /**
   * Testing if question maker passes more than 8 options.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoreThanEight() {
    makeMcq("In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?", "1", "1",
        "2", "3", "4", "5", "6", "7", "8", "9");
  }
  
  /**
   * Testing if the answer entered by user is correct.
   */
  @Test
  public void testValidAnswer1() {
    String expected = "Correct";
    assertEquals(expected, multiChoice2.answer("2"));
  }
  
  /**
   * Testing if the answer entered by user is correct.
   */
  @Test
  public void testValidAnswer2() {
    String expected = "Correct";
    assertEquals(expected, multiChoice1.answer("3"));
  }
  
  /**
   * Testing if the answer entered by user is incorrect.
   */
  @Test
  public void testInValidAnswer1() {
    String expected = "Incorrect";
    assertEquals(expected, multiChoice1.answer("2"));
  }
  
  /**
   * Testing if the answer entered by user is incorrect.
   */
  @Test
  public void testInValidAnswer2() {
    String expected = "Incorrect";
    assertEquals(expected, multiChoice2.answer("3"));
  }
}
