package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    private boolean stringIsInt(String string) {
        if (string == null) {
            return false;
        }
        return string.matches("^-?\\d+$");
    }

    private List<Integer> intTaskNumber(String str) {
        List<Integer> rsl = new ArrayList<Integer>();
        int separator = str.indexOf('.');
        while (separator != -1) {
            String task = str.substring(0, separator);
            if (stringIsInt(task)) {
                rsl.add(Integer.valueOf(task));
                str = str.substring(separator + 1, str.length());
                separator = str.indexOf('.');
            } else {
                break;
            }
        }
        return rsl;
    }

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        List<Integer> leftTask = intTaskNumber(left);
        List<Integer> rightTask = intTaskNumber(right);
        int minLenTask = Math.min(leftTask.size(), rightTask.size());
        for (int index = 0; index < minLenTask; index++) {
            rsl = Integer.compare(leftTask.get(index), rightTask.get(index));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(leftTask.size(), rightTask.size());
        }
        return rsl;
    }
}
