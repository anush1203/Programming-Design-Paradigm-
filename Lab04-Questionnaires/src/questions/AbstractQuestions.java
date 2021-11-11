package questions;

/**
 * An abstract class for all the question types. 
 * They all have few things in common such as,
 *      Question and
 *      Correct Answer for the question.
 * Implementation for these common functionalities done here to avoid code duplication.
 */
public class AbstractQuestions implements Question { 

  protected String question;
  
  /**
   * protected Questions constructor that can be used all types of questions. 
   * Every question type has 2 things in common which are questions and answer provided by user. 
   */
  protected AbstractQuestions(String question) {
    this.question = question;
  }
  
  @Override
  public int compareTo(Question o) {
    return 0;
  }
  
  @Override
  public String answer(String answer) {
    return null;
  }

  @Override
  public String getText() {
    return this.question;
  }
  
  protected int compareToTrueFalse() {
    return -1;
  }
  
  protected int compareToMultipleChoice() {
    return -1;
  }
  
  protected int compareToMultipleSelect() {
    return -1;
  }
  
  protected int compareToLikert() {
    return -1;
  }

  
  @Override
  public String[] getOptions() {
//    String[] tempOptions = {"The options are..."};
    return null; 
  }
 

}
