package ru.job4j.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FreezeStr {

    private static List<Character> stringToList(String str) {
        List<Character> rsl = new LinkedList<>();
        for (int index = 0; index < str.length(); index++) {
            rsl.add(str.charAt(index));
        }
        return rsl;
    }

    public static boolean eq(String left, String right) {
        boolean rsl = true;
        if (left.length() == right.length()) {
            List<Character> leftStr = stringToList(left);
            List<Character> rightStr = stringToList(right);
            for (Character character : leftStr) {
                if (rightStr.contains(character)) {
                    rightStr.remove(character);
                } else {
                    rsl = false;
                    break;
                }
            }
        } else {
            rsl = false;
        }
        return rsl;
    }
}