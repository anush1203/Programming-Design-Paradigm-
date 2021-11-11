
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import weather.StevensonReading;
import weather.WeatherReading;

/**
 * Testing if the code not only works but always works.
 */
public class StevensonReadingTest {

  private WeatherReading obj1;
  private WeatherReading obj2;
  private WeatherReading obj3;

  /**
   * Setting up by providing input values.
   */
  @Before
  public void setUp() {
    obj1 = stevensonObj(23.00, 12.00, 3.00, 12.00);
    obj2 = stevensonObj(23, 12, 3, 12);
    obj3 = stevensonObj(10, 8, 4, 8);
  }

  protected WeatherReading stevensonObj(double temp, double dew, double wind, double rain) {
    return new StevensonReading(temp, dew, wind, rain);
  }

  /**
   * Testing the temperature input values to the constructor.
   */
  @Test
  public void testAirTemp() {
    assertEquals(23, obj1.getTemperature());
  }

  /**
   * Testing the dew point input values to the constructor.
   */
  @Test
  public void testDewPoint() {
    assertEquals(12, obj1.getDewPoint());
  }

  /**
   * Testing the wind speed input values to the constructor.
   */
  @Test
  public void testWind() {
    assertEquals(3, obj1.getWindSpeed());
  }

  /**
   * Testing the total rain input values to the constructor.
   */
  @Test
  public void testRain() {
    assertEquals(12, obj1.getTotalRain());
  }

  /**
   * Testing if we get illegalArgumentException when we pass invalid air temperature.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDewPoint1() {
    stevensonObj(10, 15, 5, 10);
  }
  
  /**
   * Testing if we get illegalArgumentException when we pass invalid air temperature.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDewPoint2() {
    stevensonObj(10, 10.56, 5, 10);
  }

  /**
   * Testing if we get illegalArgumentException when we pass invalid wind speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWindSpeed1() {
    stevensonObj(10, 15, -13, 10);
  }
  
  /**
   * Testing if we get illegalArgumentException when we pass invalid wind speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWindSpeed2() {
    stevensonObj(10, 15, -1, 10);
  }

  /**
   * Testing if we get illegalArgumentException when we pass invalid rain value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRain1() {
    stevensonObj(10, 15, 5, -10);
  }

  /**
   * Testing if we get illegalArgumentException when we pass invalid rain value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRain2() {
    stevensonObj(10, 15, 5, -99);
  }
 
  /**
   * Testing if temperature gets rounded up.
   */
  @Test
  public void testTempRounding1() {
    int expected = 24;
    assertEquals(expected, stevensonObj(23.56, 15, 5, 10).getTemperature());
  }

  /**
   * Testing if temperature gets rounded down.
   */
  @Test
  public void testTempRounding2() {
    int expected = 23;
    assertEquals(expected, stevensonObj(23.44, 15, 5, 10).getTemperature());
  }

  /**
   * Testing if dew point gets rounded up.
   */
  @Test
  public void testDewRounding1() {
    int expected = 16;
    assertEquals(expected, stevensonObj(23.00, 15.65, 5, 10).getDewPoint());
  }

  /**
   * Testing if dew point gets rounded down.
   */
  @Test
  public void testDewRounding2() {
    int expected = 15;
    assertEquals(expected, stevensonObj(23.00, 15.33, 5, 10).getDewPoint());
  }

  /**
   * Testing if wind speed gets rounded up.
   */
  @Test
  public void testWindSpeed1() {
    int expected = 6;
    assertEquals(expected, stevensonObj(23.00, 15.33, 5.70, 10).getWindSpeed());
  }

  /**
   * Testing if wind speed gets rounded down.
   */
  @Test
  public void testWindSpeed2() {
    int expected = 5;
    assertEquals(expected, stevensonObj(23.00, 15.33, 5.12, 10).getWindSpeed());
  }

  /**
   * Testing if total rain gets rounded up.
   */
  @Test
  public void testRain1() {
    int expected = 11;
    assertEquals(expected, stevensonObj(23.00, 15.33, 5.12, 10.97).getTotalRain());
  }

  /**
   * Testing if total rain gets rounded down.
   */
  @Test
  public void testRain2() {
    int expected = 10;
    assertEquals(expected, stevensonObj(23.00, 15.33, 5.12, 10.12).getTotalRain());
  }

  /**
   * Testing if the calculated value for relative humidity is correct.
   */
  @Test
  public void testRelativeHumidity() {
    assertEquals(45, obj1.getRelativeHumidity());
  }
  
  /**
   * Testing if the calculated value for relative humidity is correct for different entry.
   */
  @Test
  public void testRelativeHumidity1() {
    assertEquals(90, stevensonObj(10, 8, 4, 8).getRelativeHumidity());
  }

  /**
   * Testing if the calculated value for heat index is correct.
   */
  @Test
  public void testHeatIndex() {
    assertEquals(28, stevensonObj(10, 8, 4, 8).getHeatIndex());
    assertEquals(25, stevensonObj(23, 12, 3, 12).getHeatIndex());
  }

  /**
   * Testing if the calculated value for wind chill is correct.
   */
  @Test
  public void testWindChill() {
    assertEquals(76, obj1.getWindChill());
    assertEquals(49,stevensonObj(10, 8, 4, 8).getWindChill());
  }

  /**
   * Testing the overridden equals method.
   */
  @Test
  public void testEquals() {
    assertTrue(obj1.equals(obj1));
    assertFalse(obj1 == null);
    // assertFalse(obj1.equals(new StevensonReadingTest()));
    assertFalse(stevensonObj(23, 10, 3, 12).equals(stevensonObj(23, 11, 3, 12)));
    assertFalse(stevensonObj(23, 10, 3, 10).equals(stevensonObj(23, 10, 3, 12)));
    assertFalse(stevensonObj(23, 10, 3, 12).equals(stevensonObj(20, 10, 3, 12)));
    assertFalse(stevensonObj(23, 10, 3, 12).equals(stevensonObj(23, 10, 4, 12)));
  }

  /**
   * Testing the hash code.
   */
  @Test
  public void testHashCode() {
    assertEquals(obj1, obj2);
    assertTrue(obj1.hashCode() == obj2.hashCode());
    assertFalse(obj1.hashCode() == obj3.hashCode());
  }

  /**
   * Testing the toString Method if we get the desired output.
   */
  @Test
  public void testToString() {
    String expected = "Reading: T = 23, D = 12, v = 3, rain = 12";
    assertEquals(expected, obj1.toString());
  }
}
