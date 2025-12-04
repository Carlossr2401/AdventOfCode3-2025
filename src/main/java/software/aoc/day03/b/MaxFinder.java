package software.aoc.day03.b;

import java.util.List;

public class MaxFinder {

    public static long findMaxSubsequence(List<Integer> digits) {
        final int K = 12;
        int L = digits.size();

        if (L < K) {
            throw new IllegalArgumentException("Input list is too short. Required 12 digits, got " + L);
        }

        StringBuilder result = new StringBuilder();
        int currentStartIndex = 0;

        for (int k = 0; k < K; k++) {
            int searchEndIndex = L - (K - 1 - k);

            MaxFinderResult searchResult = findMaxInWindow(
                    digits,
                    currentStartIndex,
                    searchEndIndex
            );

            result.append(searchResult.value());
            currentStartIndex = searchResult.index() + 1;
        }

        return Long.parseLong(result.toString());
    }

    private static MaxFinderResult findMaxInWindow(List<Integer> digits, int startIndex, int endIndex) {
        int maxValue = -1;
        int maxIndex = -1;

        for (int i = startIndex; i < endIndex; i++) {
            int currentValue = digits.get(i);

            if (currentValue > maxValue) {
                maxValue = currentValue;
                maxIndex = i;
            }
            if (maxValue == 9) break;
        }

        return new MaxFinderResult(maxIndex, maxValue);
    }

    private record MaxFinderResult(int index, int value) {}
}