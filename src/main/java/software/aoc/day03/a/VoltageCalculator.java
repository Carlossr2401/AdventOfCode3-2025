package software.aoc.day03.a;

import java.util.List;
import java.util.NoSuchElementException;

public class VoltageCalculator {

    private final MaxFinder maxFinder = new MaxFinder();

    public int calculateHighestVoltage(List<Integer> voltages) {

        MaxFinder.Result highestTenth = maxFinder.findHighestTenth(voltages);

        if (highestTenth.index() == -1) {
            throw new NoSuchElementException("Voltage list is empty or invalid.");
        }

        int subListStart = highestTenth.index() + 1;

        if (subListStart >= voltages.size()) {
            // Si no quedan unidades, la unidad es 0
            return highestTenth.value() * 10;
        }

        List<Integer> remainingUnits = voltages.subList(subListStart, voltages.size());

        int highestUnit = maxFinder.findHighestUnit(remainingUnits);

        return highestTenth.value() * 10 + highestUnit;
    }
}