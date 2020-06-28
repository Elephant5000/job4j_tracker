package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String start1 = (o1.contains("/")) ? o1.substring(0, o1.indexOf('/')) : o1;
        String start2 = (o2.contains("/")) ? o2.substring(0, o2.indexOf('/')) : o2;
        if (start1.equals(start2)) {
            return o1.compareTo(o2);
        } else {
            return o2.compareTo(o1);
        }
    }
}