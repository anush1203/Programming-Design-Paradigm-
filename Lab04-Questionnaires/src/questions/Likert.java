package questions;

import java.util.Arrays;

/**
 * Likert is a type of question that can be answered on a fixed 5-point scale. (Strongly Agree,
 * Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree) There is no wrong answer in this
 * type of question. Just make sure to enter valid option number.
 */
public class Likert extends AbstractQuestions {

  /**
   * Constructor.
   * 
   * @param question Question.
   * @throws IllegalArgumentException wrong.
   */
  public Likert(String question) {
    super(question);

    if (question == null || question.length() == 0) {
      throw new IllegalArgumentException("Enter a question!");
    }
  }

  @Override
  public String answer(String answer) {
    String[] validInputs = {"1", "2", "3", "4", "5"};
    for (int i = 0; i < validInputs.length; i++) {
      if (Arrays.asList(validInputs).contains(answer)) {
        return Question.CORRECT;
      }
    }
    return Question.INCORRECT;
  }

  @Override
  protected int compareToLikert() {
    return 0;
  } 

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestions) {
      AbstractQuestions aQuestion = (AbstractQuestions) o;
      if (aQuestion.compareToLikert() == 0) {
        return this.getText().compareTo(aQuestion.getText());
      }
    }
    return 1;
  }

  @Override
  public String[] getOptions() {
    String[] tempOptions =
        {"Strongly Agree", "Agree", "Neither Agree nor Disagree", "Disagree", "Strongly Disagree"};
    return tempOptions;
  }

}
