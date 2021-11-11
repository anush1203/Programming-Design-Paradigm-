package polynomial;

/**
 * An empty node indicating the end of our list.
 * @author anush
 *
 */
public class EmptyNode implements ListOfTerms {

  @Override
  public ListOfTerms addTerm(int coefficient, int power) {
    return new ElementNode(new Term(coefficient,power), this);
  }

  @Override
  public double evaluate(double x, double i) {
    return i;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public int getDegree() {
    return 0;
  }
  
  @Override
  public String toString() {
    return "";
  }

}
