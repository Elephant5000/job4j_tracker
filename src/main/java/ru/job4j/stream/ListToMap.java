package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {

    public static List<Integer> doubleArrayToList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }

}
