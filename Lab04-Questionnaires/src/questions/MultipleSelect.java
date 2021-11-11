package questions;

/**
 * Multiple Select is a type of questions with many options and multiple correct answers.
 */
public class MultipleSelect extends AbstractQuestions {
  private final String[] options;
  private final String correctAnswer;

  /**
   * Constructor.
   * @param question Question.
   * @param correctAnswer Correct Answer.
   * @throws IllegalArgumentException wrong.
   */
  public MultipleSelect(String question, String correctAnswer, String... options) {
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
    String[] tempCorrectAnswer = this.correctAnswer.split(" ");
    String[] tempUserAnswer = answer.split(" ");
    if (tempCorrectAnswer.length != tempUserAnswer.length) {
      return Question.INCORRECT;
    }
    for (int i = 0; i < tempCorrectAnswer.length; i++) {
      if (!correctAnswer.contains(tempUserAnswer[i])) {
        return Question.INCORRECT;
      }
    }
    return Question.CORRECT;
  }


  @Override
  protected int compareToMultipleSelect() {
    return 0;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestions) {
      AbstractQuestions aQuestion = (AbstractQuestions) o;
      if (aQuestion.compareToMultipleSelect() == 0) {
        return this.getText().compareTo(aQuestion.getText()); 
      } else if (aQuestion.compareToLikert() == 0) {
        return -1;
      } else if (aQuestion.compareToTrueFalse() == 0) {
        return +1;
      } else if (aQuestion.compareToMultipleChoice() == 0) {
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
