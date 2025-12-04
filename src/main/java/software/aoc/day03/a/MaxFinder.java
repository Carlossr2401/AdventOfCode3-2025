package software.aoc.day03.a;

import java.util.List;
import java.util.OptionalInt;
import java.util.NoSuchElementException;

public class MaxFinder {

    public record Result(int index, int value) {}

    public Result findHighestTenth(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return new Result(-1, -1);
        }

        int maxValue = list.get(0);
        int maxIndex = 0;

        for (int i = 0; i < list.size()-1; i++) {
            int currentValue = list.get(i);

            if (currentValue > maxValue) {
                maxValue = currentValue;
                maxIndex = i;
            }
        }

        return new Result(maxIndex, maxValue);
    }

    public int findHighestUnit(List<Integer> sublist) {
        if (sublist == null || sublist.isEmpty()) {
            return 0;
        }

        OptionalInt maxUnit = sublist.stream()
                .mapToInt(Integer::intValue)
                .max();

        return maxUnit.orElseThrow(() -> new NoSuchElementException("Sublist is unexpectedly empty."));
    }
}