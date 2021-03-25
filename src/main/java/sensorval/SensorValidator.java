package sensorval;

import java.util.List;

public class SensorValidator 
{
    public static boolean _give_me_a_good_name(double value, double nextValue, double maxDelta) {
        if(nextValue - value > maxDelta) {
            return false;
        }
        return true;
    }
    public static boolean validateSOCreadings(List<Double> values) {
        int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++) {
            if(!_give_me_a_good_name(values.get(i), values.get(i + 1), 0.05)) {
            return false;
            }
        }
        return true;
    }
    public static boolean validateCurrentreadings(List<Double> values) {
        int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++) {
            if(!_give_me_a_good_name(values.get(i), values.get(i + 1), 0.1)) {
            return false;
            }
        }
        return true;
    }
}
