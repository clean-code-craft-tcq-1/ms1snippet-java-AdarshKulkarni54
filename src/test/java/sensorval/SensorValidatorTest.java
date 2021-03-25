package sensorval;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SensorValidatorTest
{

  @Test
  public void reportsErrorWhenSOCjumps()
  {
    List<Double> socValues = Arrays.asList(0.0, 0.01, 0.5, 0.51);
    assertFalse(SensorValidator.validateSOCReadings(socValues));
  }

  @Test
  public void reportsErrorWhenCurrentjumps()
  {
    List<Double> currentValues = Arrays.asList(0.03, 0.03, 0.03, 0.33);
    assertFalse(SensorValidator.validateCurrentReadings(currentValues));
  }

  @Test
  public void reportsErrorWhenNoSOCAndCurrentValues()
  {
    assertFalse(SensorValidator.validateSOCReadings(null));
    assertFalse(SensorValidator.validateCurrentReadings(null));
  }

  @Test
  public void reportsErrorWhenSOCValuesContainsNull()
  {
    List<Double> socValues = Arrays.asList(0.0, 0.01, null, 0.51);
    assertFalse(SensorValidator.validateSOCReadings(socValues));
  }

  @Test
  public void reportsErrorWhenCurrentValuesContainsNull()
  {
    List<Double> currentValues = Arrays.asList(0.03, 0.03, null, 0.33);
    assertFalse(SensorValidator.validateCurrentReadings(currentValues));
  }

  @Test
  public void reportsSuccessWhenSOCValuesHaveJumps()
  {
    List<Double> socValues = Arrays.asList(0.0, 0.01, 0.01, 0.01);
    assertTrue(SensorValidator.validateSOCReadings(socValues));
  }

  @Test
  public void reportsSuccessWhenCurrentValuesHaveJumps()
  {
    List<Double> currentValues = Arrays.asList(0.03, 0.03, 0.03, 0.1);
    assertTrue(SensorValidator.validateCurrentReadings(currentValues));
  }

}
