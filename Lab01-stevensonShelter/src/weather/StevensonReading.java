package weather;

import java.util.Objects;

/**
 * Class that calculates different aspects of the weather using temperature, dew point, wind speed 
 * and rain.
 */
public final class StevensonReading implements WeatherReading {

  private final double temperature;
  private final double dewPoint;
  private final double windSpeed;
  private final double rainReceived;
  
  /**
   * A constructor that takes in input values.
   * 
   * @param temperature Air temperature.
   * @param dewPoint Dew point is the temperature below which dews start to form.
   * @param windSpeed speed of the wind in miles per hour.
   * @param rainReceived Total rain received in millimeter.
   * @throws IllegalArgumentException If dew point is greater then air temperature or wind speed
   *         falls below zero or rain value becomes negative an exception is thrown.
   */
  public StevensonReading(double temperature,double dewPoint,double windSpeed,double rainReceived) 
      throws IllegalArgumentException {
    
    if ((dewPoint > temperature) || (windSpeed < 0) || (rainReceived < 0)) {
      throw new IllegalArgumentException(
            "Please enter correct input values.");
    }
      
    this.temperature = temperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.rainReceived = rainReceived;
  }
  
  @Override
  public int getTemperature() {
    int temp = (int) Math.round(this.temperature);
    return temp;
  }

  @Override
  public int getDewPoint() {
    int dew = (int) Math.round(this.dewPoint);
    return dew;
  }

  @Override
  public int getWindSpeed() {
    int wind = (int) Math.round(this.windSpeed);
    return wind;
  }

  @Override
  public int getTotalRain() {
    int rain = (int) Math.round(this.rainReceived); 
    return rain;
  }

  private double getRelativeHumidityDouble() {
    double relativeHumidity1 = 5 * (this.dewPoint - this.temperature) + 100;
    return relativeHumidity1;   
  }
  
  @Override
  public int getRelativeHumidity() {
    return (int) Math.round(this.getRelativeHumidityDouble());
    
  }
  
  private double getHeatIndexDouble() {
    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    double heatIndex = c1 
        + (c2 * this.temperature)
        + (c3 * this.getRelativeHumidityDouble())
        + (c4 * this.temperature * this.getRelativeHumidityDouble()) 
        + (c5 * this.temperature * this.temperature) 
        + (c6 * this.getRelativeHumidityDouble() * this.getRelativeHumidityDouble()) 
        + (c7 * this.getRelativeHumidityDouble() * this.temperature * this.temperature) 
        + (c8 * this.temperature * this.getRelativeHumidityDouble() 
            * this.getRelativeHumidityDouble()) 
        + (c9 * this.temperature * this.temperature  
            * this.getRelativeHumidityDouble() * this.getRelativeHumidityDouble());
    return heatIndex;
  }
  
  @Override
  public int getHeatIndex() {
    return (int) Math.round(this.getHeatIndexDouble());
  }
  
  private double getWindChillDouble() {
    double tempFahrenheit = (temperature * 1.8) + 32;
    double windChill = 35.74 + (0.6215 * tempFahrenheit) - (35.75 * Math.pow(windSpeed, 0.16))
        + (0.4275 * tempFahrenheit * Math.pow(windSpeed, 0.16));
    return windChill;
  }
  
  @Override
  public int getWindChill() { 
    return (int) Math.round(this.getWindChillDouble());
  }

  @Override
  public int hashCode() {
    return Objects.hash(dewPoint, rainReceived, temperature, windSpeed);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof StevensonReading)) {
      return false;
    }
    StevensonReading other = (StevensonReading) obj;
    return Double.doubleToLongBits(dewPoint) == Double.doubleToLongBits(other.dewPoint)
        && Double.doubleToLongBits(rainReceived) == Double.doubleToLongBits(other.rainReceived)
        && Double.doubleToLongBits(temperature) == Double.doubleToLongBits(other.temperature)
        && Double.doubleToLongBits(windSpeed) == Double.doubleToLongBits(other.windSpeed);
  }

  @Override
  public String toString() {
    return String.format("Reading: T = " + this.getTemperature() + ", D = " + this.getDewPoint()
        + ", v = " + this.getWindSpeed() + ", rain = " + this.getTotalRain());
  }
}
