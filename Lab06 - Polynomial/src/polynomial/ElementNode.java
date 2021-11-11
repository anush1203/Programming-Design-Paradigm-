package polynomial;

/**
 * A part of the listOfTerms. 
 * It holds individual terms along with the rest of the terms.
 */
public class ElementNode implements ListOfTerms {
  
  private Term term;
  private ListOfTerms rest;
  
  /**
   * A constructor to create an elementNode that holds a term and rest.
   * @param term One single element in the node of type Term.
   * @param rest Rest of the elements of type ListOfTerms.
   */
  public ElementNode(Term term, ListOfTerms rest) {
    this.term = term;
    this.rest = rest;
  }

  @Override
  public ListOfTerms addTerm(int coefficient, int power) {
    if (power > term.getPower()) {
      return new ElementNode(new Term(coefficient, power), this);
    }
    if (power == term.getPower()) {
      int val = term.getCoefficient() + coefficient;
      if (val == 0) {
        return rest;
      }
      return new ElementNode(new Term(val, term.getPower()), rest);
    }
    this.rest = this.rest.addTerm(coefficient, power);
    return this;
  }

  @Override
  public double evaluate(double x, double i) {
    i += (term.getCoefficient() * Math.pow(x, term.getPower()));
    return rest.evaluate(x, i);
  }

  @Override
  public int getCoefficient(int power) {
    if (power == term.power) {
      return this.term.getCoefficient();
    }
    return rest.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    if (this.term.getPower() > this.rest.getDegree()) {
      return this.term.getPower();
    }
    else {
      return rest.getDegree();
    }
  }
  
  @Override
  public String toString() {
    String termS = term.toString();
    String restS = rest.toString();
    if (rest.equals("")) {
      return termS;
    }
    else {
      return termS + " " + restS;
    }
  }
}
