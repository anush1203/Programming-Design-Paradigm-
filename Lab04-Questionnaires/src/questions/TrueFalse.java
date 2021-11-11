package questions;

/**
 * A question type that takes only true or false as the answer.
 * Also tells if the answer provided by the user is correct or wrong.
 */
public class TrueFalse extends AbstractQuestions {
  private final String correctAnswer;

  /**
   * Constructing a True/ False Question. 
   * Makes sure all inputs are valid.
   * 
   * @param question The question as a String.
   * @param correctAnswer The correct answer for a particular question.
   * @throws IllegalArgumentException An exception is thrown when input is wrong.
   */
  public TrueFalse(String question, String correctAnswer) throws IllegalArgumentException {
    super(question);

    this.correctAnswer = correctAnswer;
    
    if (question == null || question.length() == 0) {
      throw new IllegalArgumentException("Enter a question!");
    }

    if (correctAnswer == null || correctAnswer.length() == 0) {
      throw new IllegalArgumentException("Provide the correct answer used to compare user answer");
    }

    if (!this.correctAnswer.equalsIgnoreCase("true")
        && !this.correctAnswer.equalsIgnoreCase("false")) {
      throw new IllegalArgumentException("Answers accepted are: true/false");
    }
  }
  
  @Override
  public String answer(String answer) {
    if (this.correctAnswer.equalsIgnoreCase(answer)) {
      return Question.CORRECT;
    }
    return Question.INCORRECT;
  }

  @Override
  protected int compareToTrueFalse() {
    return 0;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestions) {
      AbstractQuestions aQuestion = (AbstractQuestions) o;
      if (aQuestion.compareToTrueFalse() == 0) {
        return this.getText().compareTo(aQuestion.getText());
      }
    }
    return -1;
  }
  
  @Override
  public String[] getOptions() {
    String[] tempOptions = {"true", "false"};
    return tempOptions;
  }
}
