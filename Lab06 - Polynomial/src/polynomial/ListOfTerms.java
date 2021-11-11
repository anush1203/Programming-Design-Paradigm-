package polynomial;

/**
 * A list representation for all the individual terms.
 */
public interface ListOfTerms {

  /**
   * Add a term to the polynomial with the specified coefficient and power.
   *
   * @param coefficient the coefficient of the term to be added.
   * @param power       the power of the term to be added.
   * @return List of terms in the List.
   */
  ListOfTerms addTerm(int coefficient, int power);

  /**
   * Computing the value of the polynomial by substituting the value of x.
   * @param x the value to be substituted.
   * @param i stores the result.
   * @return a value after computing the value a polynomial.
   */
  double evaluate(double x, double i);

  /**
   * In a polynomial we return the coefficient of the term with the given power.
   * @param power the power whose coefficient is sought.
   * @return the coefficient at the given power.
   */
  int getCoefficient(int power);

  /**
   * Returns the highest power in the polynomial.
   * @return degree of the polynomial.
   */
  int getDegree();

}
