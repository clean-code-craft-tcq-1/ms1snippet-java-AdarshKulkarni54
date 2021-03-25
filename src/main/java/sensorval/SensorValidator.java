package sensorval;

import java.util.List;
import java.util.function.Predicate;

public class SensorValidator
{
  private static final double MAX_SOC_DELTA = 0.05;
  private static final double MAX_CURRENT_DELTA = 0.1;

  public static final Predicate<List<Double>> IS_VALID_VALUES = values -> values != null && !values.isEmpty() && !values.contains(null);

  public static boolean valuesHaveNoSuddenJumps(final double value, final double nextValue, final double maxDelta)
  {
    return nextValue - value > maxDelta;
  }

  public static boolean validateReadings(final List<Double> values, final double maxDeltaValue)
  {
    for (int i = 0; i < values.size() - 1; i++)
    {
      if (valuesHaveNoSuddenJumps(values.get(i), values.get(i + 1), maxDeltaValue))
      {
        return false;
      }
    }
    return true;
  }

  public static boolean validateSOCReadings(final List<Double> socValues)
  {
    return IS_VALID_VALUES.test(socValues) && validateReadings(socValues, MAX_SOC_DELTA);
  }

  public static boolean validateCurrentReadings(final List<Double> currentValues)
  {
    return IS_VALID_VALUES.test(currentValues) && validateReadings(currentValues, MAX_CURRENT_DELTA);
  }

}
