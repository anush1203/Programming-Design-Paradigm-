package polynomial;

/**
 * A class that is used to create a Term in a polynomial.
 */
public class Term {

  int coefficient;
  double variable = 1;
  int power;
  
  /**
   * Constructor to create the term object.
   * 
   * @param coefficient It is the co-efficient of the term.
   * @param power It is the power of the term.
   * @throws IllegalArgumentException If power is less than 0 we throw an exception.
   */
  public Term(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power can not be negative.");
    }
    this.coefficient = coefficient;
    this.power = power;
  }
  
  /**
   * Get the coefficient value from the term.
   * @return The coefficient of a term.
   */
  public int getCoefficient() {
    return this.coefficient;
  }
  
  /**
   * Get the power value from the term.
   * @return The power of the term.
   */
  public int getPower() {
    return this.power;
  }
  
  @Override
  public String toString() {
    if (power == 0) {
      if (coefficient > 0) {
        return String.format("+%d", coefficient);
      }
      return String.valueOf(coefficient);
    }
    if (power > 0) {
      if (coefficient > 0) {
        return String.format("+%dx^%d", coefficient, power);
      }
    }
    return String.format("%dx^%d", coefficient, power);
  }
}
