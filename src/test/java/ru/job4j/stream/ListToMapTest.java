package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void doubleArrayToListTest() {
        Integer[][] actual = {{1, 3}, {5, 7}};
        List<Integer> expected = List.of(1, 3, 5, 7);
        assertThat(ListToMap.doubleArrayToList(actual), is(expected));
    }
}