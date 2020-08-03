package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(-1, 0, 1, -2, 2);
        List<Integer> positiveList = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        System.out.println(positiveList);
    }
}
