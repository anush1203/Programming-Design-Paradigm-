

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.MultipleSelect;
import questions.Question;

/**
 * Testing if Multiple Select class not only works but always works.
 */
public class MultipleSelectTest {

  private Question multiSelect1;
  private Question multiSelect2;
  
  /**
   * Testing if the multiple choice questions not only work but they always work.
   */
  @Before
  public void setUp() {
    multiSelect1 = new MultipleSelect(
        "Which of these are Gokus forms?", "1 3", "1", "2", "3", "4", "5", "6");
    multiSelect2 = new MultipleSelect(
        "Who among the following are saiyans?", "2 3 4", "1", "2",
        "3", "4", "5");
  }
  
  /**
   * An efficient way for constructing objects for testing.
   * 
   * @param question The Question to be passed.
   * @param correctAnswer The correct answer for a particular question. Can be multiple options.
   * @param options The multiple options that are part of the question.
   * @return A true/false question type object.
   */
  public Question makeMsc(String question, String correctAnswer, String... options) {
    return new MultipleSelect(question, correctAnswer, options);
  }
  
  /**
   * Testing if we get an exception if question is not entered.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullQuestion() {
    makeMsc(null, "1 3", "1", "2", "3", "4");
  }

  /**
   * Testing if we get an exception if question is not entered.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestion() {
    makeMsc("", "1 3", "1", "2", "3", "4");
  }

  /**
   * Testing if question maker does not pass correct.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAnswer() {
    makeMsc("Which of these are Gokus forms?", null, "1", "2", "3", "4");
  }

  /**
   * Testing if question maker does not pass correct.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnswer() {
    makeMsc("Which of these are Gokus forms?", "", "1", "2", "3", "4");
  }

  /**
   * Testing if question maker passes less than 3 options.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLessThanThree() {
    makeMsc("Which of these are Gokus forms?", "1 3", "1");
  }

  /**
   * Testing if question maker passes more than 8 options.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoreThanEight() {
    makeMsc("Which of these are Gokus forms?", "1 3", "1",
        "2", "3", "4", "5", "6", "7", "8", "9");
  }
  
  /**
   * Testing if the answer entered by user does not match the length of the expected answer.
   */
  @Test
  public void testLengthUnmatched() {
    String expected = "Incorrect";
    assertEquals(expected, multiSelect1.answer("1 3 4"));
  }
  
  /**
   * Testing if the answer entered by user does not the expected answer.
   */
  @Test
  public void testWrongAnswer() {
    String expected = "Incorrect";
    assertEquals(expected, multiSelect1.answer("1 4"));
  }
  
  /**
   * Testing if the answer entered by user is the expected answer.
   */
  @Test
  public void testValidAnswer1() {
    String expected = "Correct";
    assertEquals(expected, multiSelect1.answer("1 3"));
  }
  
  /**
   * Testing if the answer entered by user is the expected answer.
   */
  @Test
  public void testValidAnswer2() {
    String expected = "Correct";
    assertEquals(expected, multiSelect2.answer("2 3 4"));
  }

}
