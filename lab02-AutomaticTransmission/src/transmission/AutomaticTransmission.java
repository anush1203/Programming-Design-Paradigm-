package transmission;

/**
 *A system that automatically changes gear as speed increases and decreases.
 *The change in gear is determined by different threshold values mentioned by the user.
 */
public class AutomaticTransmission implements Transmission {

  private final int speedThreshold1;
  private final int speedThreshold2;
  private final int speedThreshold3;
  private final int speedThreshold4;
  private final int speedThreshold5;
  private int currentSpeed;
  private int currentGear;
  
  /**
   * Setting the threshold values for speeds at which gears change.
   * @param speedThreshold1 Speed at which gear goes from 1 to 2.
   * @param speedThreshold2 Speed at which gear goes from 2 to 3.
   * @param speedThreshold3 Speed at which gear goes from 3 to 4.
   * @param speedThreshold4 Speed at which gear goes from 4 to 5.
   * @param speedThreshold5 Speed at which gear goes from 5 to 6.
   */
  public AutomaticTransmission(int speedThreshold1, int speedThreshold2, int speedThreshold3,
      int speedThreshold4, int speedThreshold5) {
    
    if (speedThreshold1 > speedThreshold2 || speedThreshold2 > speedThreshold3 
        || speedThreshold3 > speedThreshold4 || speedThreshold4 > speedThreshold5 
        || speedThreshold1 <= 0) {
      throw new IllegalArgumentException("Enter appropriate speed values");
    }
    this.speedThreshold1 = speedThreshold1;
    this.speedThreshold2 = speedThreshold2;
    this.speedThreshold3 = speedThreshold3;
    this.speedThreshold4 = speedThreshold4;
    this.speedThreshold5 = speedThreshold5;
    
    this.currentSpeed = 0;
    this.currentGear = 0;
  }

  
  @Override
  public void increaseSpeed() {
    currentSpeed += 1;
    changeGear();
  }

  @Override
  public void decreaseSpeed() throws IllegalStateException {
    currentSpeed -= 1;    
    if (currentSpeed < 0) {
      throw new IllegalStateException("Speed can not be negative");
    }
    changeGear();
  }

  @Override
  public int getSpeed() {
    return currentSpeed;
  }

  @Override
  public int getGear() {
    return currentGear;
  }

  /**
   * Different ranges at which we want gears to change. 
   */
  private void changeGear() {
    if (currentSpeed == 0) {
      currentGear = 0;
    }
    if (currentSpeed > 0 && currentSpeed <= this.speedThreshold1) {
      currentGear = 1;
    }
    if (currentSpeed >= this.speedThreshold1 && currentSpeed <= this.speedThreshold2) {
      currentGear = 2;
    }
    if (currentSpeed >= this.speedThreshold2 && currentSpeed <= this.speedThreshold3) {
      currentGear = 3;
    }
    if (currentSpeed >= this.speedThreshold3 && currentSpeed <= this.speedThreshold4) {
      currentGear = 4;
    }
    if (currentSpeed >= this.speedThreshold4 && currentSpeed <= this.speedThreshold5) {
      currentGear = 5;
    }
    if (currentSpeed >= this.speedThreshold5) {
      currentGear = 6;
    }
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %s, gear = %s)", currentSpeed,
        currentGear);
  }
}
