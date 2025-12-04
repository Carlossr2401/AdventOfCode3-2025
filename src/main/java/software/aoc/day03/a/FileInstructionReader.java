package software.aoc.day03.a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record FileInstructionReader(String filePath) {

    public List<List<Integer>> readAllVoltages() throws IOException {

        List<List<Integer>> allLinesOfVoltages = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                allLinesOfVoltages.add(parseLine(line));
            }
        }

        return allLinesOfVoltages;
    }

    private List<Integer> parseLine(String line) {
        return line.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}