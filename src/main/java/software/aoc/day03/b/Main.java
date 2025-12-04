package software.aoc.day03.b;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInstructionReader reader = new FileInstructionReader("src/main/resources/banks");

        List<List<Integer>> allVoltageSets = reader.readAllVoltages();

        VoltageCalculator calculator = new VoltageCalculator();

        AtomicLong grandTotal = new AtomicLong(0);

        for (List<Integer> voltageSet : allVoltageSets) {

            long calculatedVoltage = calculator.calculateHighestVoltage(voltageSet);

            grandTotal.addAndGet(calculatedVoltage);
        }

        System.out.println("Suma total de voltajes calculados: " + grandTotal.get());
    }
}