package transmission;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing AutomaticTransmission class so that it not only works but works all the time.
 */
public class AutomaticTransmissionTest {

  private AutomaticTransmission tesla;

  /**
   * Setting up the threshold values.
   */
  @Before
  public void setUp() {
    tesla = new AutomaticTransmission(15, 30, 45, 60, 75);
  }

  /**
   * Creating AutomaticTransmission instances in an easy and efficient way.
   * 
   * @param speedThreshold1 Speed at which gear goes from 1 to 2.
   * @param speedThreshold2 Speed at which gear goes from 2 to 3.
   * @param speedThreshold3 Speed at which gear goes from 3 to 4.
   * @param speedThreshold4 Speed at which gear goes from 4 to 5.
   * @param speedThreshold5 Speed at which gear goes from 5 to 6.
   * @return A new instance created.
   */
  protected Transmission autoT(int speedThreshold1, int speedThreshold2, int speedThreshold3,
      int speedThreshold4, int speedThreshold5) {
    return new AutomaticTransmission(speedThreshold1, speedThreshold2, speedThreshold3,
        speedThreshold4, speedThreshold5);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorIllegalSpeed1() {
    autoT(10, 2, 4, 6, 8);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorIllegalSpeed2() {
    autoT(2, 10, 4, 6, 8);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorIllegalSpeed3() {
    autoT(2, 4, 10, 6, 8);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorIllegalSpeed4() {
    autoT(2, 4, 6, 10, 8);
  }
  
  /**
   * Testing constructor for invalid threshold1 speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorIllegalSpeed5() {
    autoT(0, 4, 6, 10, 12);
  }

  /**
   * Testing constructor for negative threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeSpeed1() {
    autoT(-2, 4, 6, 8, 10);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeSpeed2() {
    autoT(2, -4, 6, 8, 10);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeSpeed3() {
    autoT(2, 4, -6, 8, 10);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeSpeed4() {
    autoT(2, 4, 6, -8, 10);
  }

  /**
   * Testing constructor for invalid threshold speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNegativeSpeed5() {
    autoT(2, 4, 6, 8, -10);
  }

  // /**
  // * Testing constructor when two threshold speeds are same.
  // */
  // @Test(expected = IllegalArgumentException.class)
  // public void testConstructorSameSpeed1() {
  // autoT(2, 2, 6, 8, 10);
  // }
  //
  // /**
  // * Testing constructor when two threshold speeds are same.
  // */
  // @Test(expected = IllegalArgumentException.class)
  // public void testConstructorSameSpeed2() {
  // autoT(2, 4, 4, 8, 10);
  // }
  //
  // /**
  // * Testing constructor when two threshold speeds are same.
  // */
  // @Test(expected = IllegalArgumentException.class)
  // public void testConstructorSameSpeed3() {
  // autoT(2, 4, 6, 6, 10);
  // }
  //
  // /**
  // * Testing constructor when two threshold speeds are same.
  // */
  // @Test(expected = IllegalArgumentException.class)
  // public void testConstructorSameSpeed4() {
  // autoT(2, 2, 6, 8, 8);
  // }

  /**
   * Testing if the increaseSpeed method increases the speed correctly.
   */
  @Test
  public void testIncreaseSpeed1() {
    for (int i = 0; i < 31; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(31, tesla.getSpeed());
  }

  /**
   * Testing if the increaseSpeed method increases the speed correctly.
   */
  @Test
  public void testIncreaseSpeed2() {
    for (int i = 0; i < 10; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(10, tesla.getSpeed());
  }

  /**
   * Testing if the decreaseSpeed method decreases the speed correctly.
   */
  @Test
  public void testDecreaseSpeed1() {
    for (int i = 0; i < 31; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 10; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(21, tesla.getSpeed());
  }

  /**
   * Testing if the decreaseSpeed method decreases the speed correctly.
   */
  @Test
  public void testDecreaseSpeed2() {
    for (int i = 0; i < 10; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 5; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(5, tesla.getSpeed());
  }

  /**
   * Testing if the decreaseSpeed method throws exception when speed goes below zero.
   */
  @Test(expected = IllegalStateException.class)
  public void testDecreaseSpeedIllegal1() {
    for (int i = 0; i < 10; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 11; i++) {
      tesla.decreaseSpeed();
    }
  }

  /**
   * Testing if the decreaseSpeed method throws exception when speed goes below zero.
   */
  @Test(expected = IllegalStateException.class)
  public void testDecreaseSpeedIllegal2() {
    tesla.increaseSpeed();
    tesla.decreaseSpeed();
    tesla.decreaseSpeed();
  }

  /**
   * Testing the speed of the transmission when we initialize a new instance.
   */
  @Test
  public void testGetSpeedZero() {
    assertEquals(0, tesla.getSpeed());
  }

  /**
   * Testing the gear of the transmission when we initialize a new instance.
   */
  @Test
  public void testGetGearZero() {
    assertEquals(0, tesla.getGear());
  }

  /**
   * Testing if the gear goes from 0 to 1 at the correct speed.
   */
  @Test
  public void testGear0to1() {
    tesla.increaseSpeed();
    assertEquals(1, tesla.getGear());
  }

  /**
   * Testing if the gear goes from 1 to 2 at the correct speed.
   */
  @Test
  public void testGear1to2() {
    for (int i = 0; i < 16; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(2, tesla.getGear());
  }

  /**
   * Testing if the gear goes from 2 to 3 at the correct speed.
   */
  @Test
  public void testGear2to3() {
    for (int i = 0; i < 31; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(3, tesla.getGear());
  }

  /**
   * Testing if the gear goes from 3 to 4 at the correct speed.
   */
  @Test
  public void testGear3to4() {
    for (int i = 0; i < 46; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(4, tesla.getGear());
  }

  /**
   * Testing if the gear goes from 4 to 5 at the correct speed.
   */
  @Test
  public void testGear4to5() {
    for (int i = 0; i < 61; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(5, tesla.getGear());
  }

  /**
   * Testing if the gear goes from 5 to 6 at the correct speed.
   */
  @Test
  public void testGear5to6() {
    for (int i = 0; i < 76; i++) {
      tesla.increaseSpeed();
    }
    assertEquals(6, tesla.getGear());
  }

  /**
   * Testing if the gear goes down from 6 to 5 at the correct speed.
   */
  @Test
  public void testGear6to5() {
    for (int i = 0; i < 76; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 4; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(5, tesla.getGear());
  }

  /**
   * Testing if the gear goes down from 5 to 4 at the correct speed.
   */
  @Test
  public void testGear5to4() {
    for (int i = 0; i < 61; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 4; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(4, tesla.getGear());
  }

  /**
   * Testing if the gear goes down from 4 to 3 at the correct speed.
   */
  @Test
  public void testGear4to3() {
    for (int i = 0; i < 46; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 4; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(3, tesla.getGear());
  }

  /**
   * Testing if the gear goes down from 3 to 2 at the correct speed.
   */
  @Test
  public void testGear3to2() {
    for (int i = 0; i < 31; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 4; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(2, tesla.getGear());
  }

  /**
   * Testing if the gear goes down from 2 to 1 at the correct speed.
   */
  @Test
  public void testGear2to1() {
    for (int i = 0; i < 16; i++) {
      tesla.increaseSpeed();
    }
    for (int i = 0; i < 4; i++) {
      tesla.decreaseSpeed();
    }
    assertEquals(1, tesla.getGear());
  }

  /**
   * Testing if the gear goes down from 1 to 0 at the correct speed.
   */
  @Test
  public void testGear1to0() {
    tesla.increaseSpeed();
    tesla.decreaseSpeed();
    assertEquals(0, tesla.getGear());
  }

  /**
   * Testing if we get illegalStateException when speed goes negative.
   */
  @Test(expected = IllegalStateException.class)
  public void testGearInvalid() {
    tesla.decreaseSpeed();
  }

  /**
   * Testing if the format of our result is the same as what we are expecting.
   */
  @Test
  public void testToString() {
    String expected = "Transmission (speed = 0, gear = 0)";
    assertEquals(expected, tesla.toString());
  }
}
