package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false)
                .flatMap(integerIterator -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(integerIterator, Spliterator.ORDERED), false))
                .collect(Collectors.toList());
    }
}