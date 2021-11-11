

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Question;
import questions.TrueFalse;

/**
 * Testing if the TrueFalse not only works but always works.
 */
public class TrueFalseTest {

  private Question trueFalse1;
  private Question trueFalse2;
  
  /**
   * Setting up the trueFalse object which will be used for testing.
   */
  @Before
  public void setUp() {
    trueFalse1 = new TrueFalse(
        "Roger Federer has won the most Wimbledon titles of any player", "false");
    trueFalse2 = new TrueFalse(
        "Mt.Everest is the tallest mountain.","true");
  }
  
  /**
   * An efficient way for constructing objects for testing.
   * 
   * @param question The Question to be passed.
   * @param correctAnswer The correct answer for a particular question.
   * @return A true/false question type object.
   */
  public Question makeTf(String question, String correctAnswer) {
    return new TrueFalse(question, correctAnswer);
  }
  
  /**
   * Testing when question maker does not enter a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullQuestion() {
    makeTf(null,"false");
  }
  
  /**
   * Testing when question maker does not enter a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyQuestion() {
    makeTf("","false");
  }
  
  /**
   * Testing when question maker does not enter an answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAnswer() {
    makeTf("Mt.Everest is the tallest mountain.",null);
  }
  
  /**
   * Testing when question maker does not enter an answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAnswer() {
    makeTf("Mt.Everest is the tallest mountain.","");
  }
  
  /**
   * Testing when question maker enters a wrong spelling for answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongTrue() {
    makeTf("Mt.Everest is the tallest mountain.","truee");
  }
  
  /**
   * Testing when question maker enters a wrong spelling for answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWrongFalse() {
    makeTf("Mt.Everest is the tallest mountain.","Falses");
  }
  
  /**
   * Testing if the answer entered by user is same as the expected answer.
   */
  @Test
  public void testValidAnswer1() {
    assertEquals("Correct", trueFalse1.answer("False"));
  }
  
  /**
   * Testing if the answer entered by user is same as the expected answer.
   */
  @Test
  public void testValidAnswer2() {
    assertEquals("Correct", trueFalse2.answer("true"));
  }
  
  /**
   * Testing when the answer entered by user is not the same as the expected answer.
   */
  @Test
  public void testInvalidAnswer1() {
    assertEquals("Incorrect", trueFalse1.answer("True"));
  }
  
  /**
   * Testing when the answer entered by user is not the same as the expected answer.
   */
  @Test
  public void testInvalidAnswer2() {
    assertEquals("Incorrect", trueFalse2.answer("False"));
  }
}
