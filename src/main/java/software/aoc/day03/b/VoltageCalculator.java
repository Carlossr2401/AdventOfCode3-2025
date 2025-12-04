package software.aoc.day03.b;

import java.util.List;

public class VoltageCalculator {

    public long calculateHighestVoltage(List<Integer> voltages) {

        return MaxFinder.findMaxSubsequence(voltages);
    }
}