package polynomial;

import java.util.Scanner;

/**
 * An implmentaion for the give Polynomial interface.
 */
public class PolynomialImpl implements Polynomial {
  
  private ListOfTerms head;
  
  /**
   * Creating a polynomial using the string input.
   * @param poly A string representing the polynomial expression.
   * @throws IllegalArgumentException if the input is invalid.
   */
  public PolynomialImpl(String poly) throws IllegalArgumentException {
    if (poly == null || poly.equals("")) {
      throw new IllegalArgumentException("Enter a valid polynomial as a string");
    }
    ListOfTerms tempHead = new EmptyNode();
    Scanner sc = new Scanner(poly);
    while (sc.hasNext()) {
      int coeff = 0;
      int pow = 0;
      String[] myTerm = sc.next().split("x\\^");
      if (myTerm.length == 0) {
        throw new IllegalArgumentException("invalid input");
      }
      if (myTerm.length == 1) {
        coeff = convertToInt(myTerm[0]);
        tempHead = tempHead.addTerm(coeff,pow);
      }
      else {
        coeff = convertToInt(myTerm[0]);
        pow = convertToInt(myTerm[1]);
        tempHead = tempHead.addTerm(coeff,pow);
      }
    }
    this.head = tempHead;
  }
  
  /**
   * Used to create a polynomial with no terms.
   */
  public PolynomialImpl() {
    this.head = new EmptyNode();
  }

  private int convertToInt(String string) {
    if (string.matches("^[+-]?\\d+$")) {
      Character sign = string.charAt(0);
      if (sign.equals('+')) {
        return (1 * Integer.parseInt(string));
      }
      else if (sign.equals('-')) {
        return (Integer.parseInt(string));
        
      }
      else {
        return Integer.parseInt(string);
      }
    }
    throw new IllegalArgumentException("Invalid input");
  }
  
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (other == null) {
      throw new IllegalArgumentException("Invalid input");
    }
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException();
    }
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException();
    }
    Polynomial poly3 = new PolynomialImpl();
    poly3 = this.addAllElements(poly3, this);
    poly3 = this.addAllElements(poly3, other);
    return poly3;
  }

  private Polynomial addAllElements(Polynomial poly1, Polynomial poly2) {
    for (int i = 0; i <= poly2.getDegree(); i++) {
      if (poly2.getCoefficient(i) != 0) {
        poly1.addTerm(poly2.getCoefficient(i), i);
      }
    }
    return poly1;
  }
  

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power can not be negative");
    }
    head =  this.head.addTerm(coefficient, power);
  }

  @Override
  public boolean isSame(Polynomial poly) {
    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    
    if (this.getDegree() != poly.getDegree()) {
      return false;
    }
    for (int i = 0; i <= head.getDegree(); i++) {
      if (this.getCoefficient(i) != poly.getCoefficient(i)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public double evaluate(double x) {
    return head.evaluate(x, 0);
  }

  @Override
  public int getCoefficient(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power can not be negative");
    }
    return head.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    return head.getDegree();
  }
  
  @Override
  public String toString() {
    if (head.toString().equals("")) {
      return "0";
    }
    if (head.toString().charAt(0) == '+') {
      return head.toString().substring(1).trim();
    }
    return head.toString().trim();
  }

}
