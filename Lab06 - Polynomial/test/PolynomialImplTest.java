

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import polynomial.Polynomial;
import polynomial.PolynomialImpl;

/**
 * A class to test if the implementation is working correctly always.
 */
public class PolynomialImplTest {

  private Polynomial p;

  /**
   * Setting up a polynomial.
   */
  @Before
  public void setUp() {
    p = new PolynomialImpl("3x^2 -2x^1 +4");
  }
  
  /**
   * Test if the polynomial was correctly constructed.
   */
  @Test
  public void testValidString() {
    assertEquals("3x^2 -2x^1 +4", p.toString());
  }
  
  /**
   * Test if the polynomial was correctly constructed.
   */
  @Test
  public void testValidString2() {
    Polynomial p7 = new PolynomialImpl("3x^2 +2x^2 -2x^1 +4");
    assertEquals("5x^2 -2x^1 +4", p7.toString());
  }
  
  /**
   * Test if the polynomial was correctly constructed.
   */
  @Test
  public void testValidString3() {
    Polynomial p7 = new PolynomialImpl("3");
    assertEquals("3", p7.toString());
  }
  
  /**
   * Test if the polynomial was correctly constructed.
   */
  @Test
  public void testToString1() {
    Polynomial p7 = new PolynomialImpl("1x^2");
    assertEquals("1x^2", p7.toString());
  }
  
  /**
   * Test 0 is returned when no term is present.
   */
  @Test
  public void testEmptyConstructor() {
    Polynomial p3 = new PolynomialImpl();
    assertEquals("0",p3.toString());
  }
  
  /**
   * Test Illegal constructor parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor1() {
    Polynomial p4 = new PolynomialImpl(null);
  }
  
  /**
   * Test Illegal constructor parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor2() {
    Polynomial p5 = new PolynomialImpl("");
  }
  
  /**
   * Test Illegal constructor parameters.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor3() {
    Polynomial p6 = new PolynomialImpl("abc");
  }
  
  /**
   * Test addTerm throws exception when power is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddTermNegativePower() {
    p.addTerm(4, -2);
  }
  
  /**
   * Test if terms get added.
   */
  @Test
  public void testAddTerm() {
    p.addTerm(4, 2);
    p.addTerm(5, 7);
    p.addTerm(-2, 6);
    p.addTerm(-2, 6);
    p.addTerm(3, 0);
    assertEquals("5x^7 -4x^6 +7x^2 -2x^1 +7",p.toString());
  }
  
  /**
   * Test if existing term gets added.
   */
  @Test
  public void testAddTerm2() {
    p.addTerm(-2, 1);
    assertEquals("3x^2 -4x^1 +4",p.toString());
  }
  
  /**
   * Testing if isSame works when powers are unique.
   */
  @Test
  public void testIsSame1() {
    Polynomial p2 = new PolynomialImpl("-2x^6 +3x^7 +4");
    assertEquals(false,p.isSame(p2));
  }
  
  /**
   * Testing if two polynomials are same.
   */
  @Test
  public void testIsSame2() {
    Polynomial p2 = new PolynomialImpl("-2x^1 +3x^2 +4");
    assertEquals(true,p.isSame(p2));
  }
  
  /**
   * Testing if two polynomials are same when both values are 0.
   */
  @Test
  public void testIsSame3() {
    Polynomial p2 = new PolynomialImpl();
    Polynomial p3 = new PolynomialImpl();
    assertEquals(true,p2.isSame(p3));
  }
  
  /**
   * Testing evaluate function for negative value of x.
   */
  @Test
  public void testEvaluate1() {
    Polynomial p2 = new PolynomialImpl("-2x^1 +3x^2 +4");
    assertEquals(20.00,p2.evaluate(-2.0),0);
  }
  
  /**
   * Testing evaluate function for positive value of x.
   */
  @Test
  public void testEvaluate2() {
    Polynomial p2 = new PolynomialImpl("-2x^1 +3x^2 +4");
    assertEquals(17.75,p2.evaluate(2.5),0);
  }
  
  /**
   * Testing if getCoefficient throws exception when negative power passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetCoeff() {
    p.getCoefficient(-2);
  }
  
  /**
   * Testing if getCoefficient works.
   */
  @Test
  public void testValidGetCoeff1() {
    assertEquals(3, p.getCoefficient(2));
  }
  
  /**
   * Testing if getCoefficient returns 0 when no such power exists.
   */
  @Test
  public void testValidGetCoeff2() {
    assertEquals(0, p.getCoefficient(7));
  }
  
  /**
   * Testing if getDegree works.
   */
  @Test
  public void testGetDegree1() {
    assertEquals(2, p.getDegree());
  }
  
  /**
   * Testing if getDegree works when only constant present.
   */
  @Test
  public void testGetDegree2() {
    Polynomial p10 = new PolynomialImpl("4");
    assertEquals(0, p10.getDegree());
  }
  
  /**
   * Testing if add method works when polynomials with unique powers are added.
   */
  @Test
  public void testAdd1() {
    Polynomial p10 = new PolynomialImpl("6x^7 +4x^5 +3x^4");
    assertEquals("6x^7 +4x^5 +3x^4 +3x^2 -2x^1 +4", p.add(p10).toString());
  }
  
  /**
   * Testing if add method works when polynomials with same powers are added.
   */
  @Test
  public void testAdd2() {
    Polynomial p10 = new PolynomialImpl("6x^7 +4x^5 +3x^4");
    assertEquals("12x^7 +8x^5 +6x^4", p10.add(p10).toString());
  }
  
  /**
   * Testing if add method works when one of the polynomials is 0.
   */
  @Test
  public void testAdd3() {
    Polynomial p10 = new PolynomialImpl("6x^7 +4x^5 +3x^4");
    Polynomial p11 = new PolynomialImpl();
    assertEquals("6x^7 +4x^5 +3x^4", p10.add(p11).toString());
  }
}
