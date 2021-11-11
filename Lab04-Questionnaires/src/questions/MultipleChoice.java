package questions;

/**
 * Multiple choice type is where a question will be given many options and out off all the options
 * provided only 1 answer will be correct.
 */
public class MultipleChoice extends AbstractQuestions {
  private final String[] options;
  private final String correctAnswer;

  /**
   * Constructing a Multiple choice Question. Makes sure all inputs are valid.
   * 
   * @param question The question as a String.
   * @param correctAnswer The correct answer for a particular question.
   * @param options They are multiple options which has 1 correct answer.
   * @throws IllegalArgumentException An exception is thrown when input is wrong.
   */
  public MultipleChoice(String question, String correctAnswer, String... options) {
    super(question);
    this.options = options;
    this.correctAnswer = correctAnswer;

    if (question == null || question.length() == 0) {
      throw new IllegalArgumentException("Enter a question!");
    }

    if (correctAnswer == null || correctAnswer.length() == 0) {
      throw new IllegalArgumentException("Provide the correct answer used to compare user answer");
    }

    if (options.length < 3) {
      throw new IllegalArgumentException("Provide atleast 3 options");
    }

    if (options.length > 8) {
      throw new IllegalArgumentException(
          "A multiplechoice question can have a maximum of 8 options");
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
  protected int compareToMultipleChoice() {
    return 0;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestions) {
      AbstractQuestions aQuestion = (AbstractQuestions) o;
      if (aQuestion.compareToMultipleChoice() == 0) {
        return this.getText().compareTo(aQuestion.getText());
      } else if (aQuestion.compareToTrueFalse() == 0) {
        return +1;
      }
    }
    return -1;
  }

  @Override
  public String[] getOptions() {
    return options;
  }
}
