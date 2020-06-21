package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                if (left.charAt(index) > right.charAt(index)) {
                    rsl = 1;
                } else {
                    rsl = -1;
                }
                break;
            }
        }
        if (rsl == 0) {
            rsl = (left.length() > right.length()) ? 1 : (left.length() < right.length() ? -1 : 0);
        }
        return rsl;
    }
}