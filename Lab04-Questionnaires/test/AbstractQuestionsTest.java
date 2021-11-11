

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Testing class.
 */
public class AbstractQuestionsTest {

  /**
   * Testing the compareTrueFalse method using getText method.
   * Testing if the questions get ordered in lexicographical order.
   */
  @Test
  public void testCompareTrueFalse() {
    Question trueFalse1 =
        new TrueFalse("Roger Federer has won the most Wimbledon titles of any player", "false");
    Question trueFalse2 =
        new TrueFalse("Fruit flies were the first living creatures sent into space", "true");
    List<Question> questionnaire = new ArrayList<Question>();
    questionnaire.add(trueFalse2);
    questionnaire.add(trueFalse1);
    Collections.sort(questionnaire);

    assertEquals("Roger Federer has won the most Wimbledon titles of any player",
        questionnaire.get(1).getText());
    assertEquals("Fruit flies were the first living creatures sent into space",
        questionnaire.get(0).getText());
  }

  /**
   * Testing the compareMultipleChoice method using getText method.
   * Testing if the questions get ordered in lexicographical order.
   */
  @Test
  public void testCompareMultipleChoice() {
    Question multipleChoice1 = new MultipleChoice(
        "Which one of these characters is not friends with Harry Potter?", "3", "1", "2", "3", "4");
    Question multipleChoice2 = new MultipleChoice(
        "In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?", "2", "1", "2",
        "3", "4", "5");
    List<Question> questionnaire = new ArrayList<Question>();
    questionnaire.add(multipleChoice1);
    questionnaire.add(multipleChoice2);
    Collections.sort(questionnaire);

    assertEquals("Which one of these characters is not friends with Harry Potter?",
        questionnaire.get(1).getText());
    assertEquals("In Pirates of the Caribbean, what was Captain Jack Sparrows ships name?",
        questionnaire.get(0).getText());
  }
  
  /**
   * Testing the compareMultipleSelect method using getText method.
   * Testing if the questions get ordered in lexicographical order.
   */
  @Test
  public void testCompareMultipleSelect() {
    Question multipleSelect1 = new MultipleSelect(
        "Which of these are Gokus forms?", "1 3", "1", "2", "3", "4", "5", "6");
    Question multipleSelect2 = new MultipleSelect(
        "Who among the following are saiyans?", "2 3 4", "1", "2",
        "3", "4", "5");
    List<Question> questionnaire = new ArrayList<Question>();
    questionnaire.add(multipleSelect1);
    questionnaire.add(multipleSelect2);
    Collections.sort(questionnaire);

    assertEquals("Which of these are Gokus forms?",
        questionnaire.get(0).getText());
    assertEquals("Who among the following are saiyans?",
        questionnaire.get(1).getText());
  }
  
  /**
   * Testing the compareLikert method using getText method.
   * Testing if the questions get ordered in lexicographical order.
   */
  @Test
  public void testCompareLikert() {
    Question likert1 = new Likert(
        "It was easy to navigate the website to find what I was looking for.");
    Question likert2 = new Likert(
        "The conference speakers were knowledgeable and informative.");
    List<Question> questionnaire = new ArrayList<Question>();
    questionnaire.add(likert1);
    questionnaire.add(likert2);
    Collections.sort(questionnaire);

    assertEquals("It was easy to navigate the website to find what I was looking for.",
        questionnaire.get(0).getText());
    assertEquals("The conference speakers were knowledgeable and informative.",
        questionnaire.get(1).getText());
  }
  
  /**
   * Testing if the questions in the questionnaire are ordered in the following order,
   * True/False, MultipleChoice, MultipleSelect, Likert.
   */
  @Test
  public void testCompareAll() {
    Question trueFalse =
        new TrueFalse("Roger Federer has won the most Wimbledon titles of any player", "false");
    Question trueFalse1 =
        new TrueFalse("Mt.Everest is the tallest mountain", "true");
    Question multipleChoice = new MultipleChoice(
        "Which one of these characters is not friends with Harry Potter?", "3", "1", "2", "3", "4");
    Question multipleChoice1 = new MultipleChoice(
        "Elon Musk is the owner of which automobile company?", "3", "1", "2", "3", "4");
    Question multipleSelect = new MultipleSelect(
        "Which of these are Gokus forms?", "1 3", "1", "2", "3", "4", "5", "6");
    Question multipleSelect1 = new MultipleSelect(
        "Which of these are Anushs forms?", "1 4", "1", "2", "3", "4", "5", "6");
    Question likert = new Likert(
        "The conference speakers were knowledgeable and informative.");
    Question likert1 = new Likert(
        "PDP is very important.");
    
    List<Question> questionnaire = new ArrayList<Question>();
    
    questionnaire.add(likert);
    questionnaire.add(trueFalse);
    questionnaire.add(trueFalse1);
    questionnaire.add(multipleChoice); 
    questionnaire.add(multipleSelect);
    questionnaire.add(multipleSelect1);
    questionnaire.add(likert1);
    questionnaire.add(multipleChoice1);
    
    
    Collections.sort(questionnaire);

    assertEquals("Mt.Everest is the tallest mountain",
        questionnaire.get(0).getText());
    assertEquals("Roger Federer has won the most Wimbledon titles of any player",
        questionnaire.get(1).getText());
    assertEquals("Elon Musk is the owner of which automobile company?",
        questionnaire.get(2).getText());
    assertEquals("Which one of these characters is not friends with Harry Potter?",
        questionnaire.get(3).getText());
    assertEquals("Which of these are Anushs forms?",
        questionnaire.get(4).getText());
    assertEquals("Which of these are Gokus forms?",
        questionnaire.get(5).getText());
    assertEquals("PDP is very important.",
        questionnaire.get(6).getText());
    assertEquals("The conference speakers were knowledgeable and informative.",
        questionnaire.get(7).getText());
  }
  

}
