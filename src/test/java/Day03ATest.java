import org.junit.Test;
import software.aoc.day03.a.VoltageCalculator;
import software.aoc.day03.a.MaxFinder; // Necesario para acceder al Record Result si se requiere
import java.util.List;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class Day03ATest {

    private final VoltageCalculator calculator = new VoltageCalculator();


    @Test
    public void testBasicVoltageCalculation() {
        List<Integer> voltages = List.of(8, 9, 7, 5);
        assertEquals(95, calculator.calculateHighestVoltage(voltages));
    }


    @Test
    public void testFirstIndexPrecedenceIsChosen() {
        List<Integer> voltages = List.of(8, 9, 7, 9, 4);
        assertEquals(99, calculator.calculateHighestVoltage(voltages));
    }


    @Test
    public void testUnitMaxIsChosenFromRemainingList() {
        List<Integer> voltages = List.of(2, 5, 8, 1, 9, 4);
        assertEquals(89, calculator.calculateHighestVoltage(voltages));
    }


    @Test
    public void testUnitIsZeroIfMaxIsLastElement() {
        List<Integer> voltages = List.of(5, 8, 3, 9);
        assertEquals(90, calculator.calculateHighestVoltage(voltages));
    }

    @Test
    public void testUnitIsZeroIfOnlyOneElement() {
        List<Integer> voltages = List.of(5);
        assertEquals(50, calculator.calculateHighestVoltage(voltages));
    }


    @Test
    public void testLargeTenthValue() {
        List<Integer> voltages = List.of(90, 95, 80, 99);
        assertEquals(990, calculator.calculateHighestVoltage(voltages));
    }

    @Test
    public void testLargeTenthAndUnitValue() {
        List<Integer> voltages = List.of(90, 95, 80, 99);
        assertEquals(9099, calculator.calculateHighestVoltage(voltages));
    }
}