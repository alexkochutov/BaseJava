package com.basejava.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainStream {

    public static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .filter(a -> (a >= 1) && (a <= 9))
                .sorted()
                .reduce(0, (a, b) -> a * 10 + b);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> result = integers.stream()
                .collect(Collectors.partitioningBy(a -> a % 2 == 0));
        return result.get(false).size() % 2 == 0 ? result.get(false) : result.get(true);
    }
}