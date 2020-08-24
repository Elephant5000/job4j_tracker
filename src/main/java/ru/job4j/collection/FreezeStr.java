package ru.job4j.collection;

import java.util.*;

public class FreezeStr {

    public static boolean eq(String left, String right) {
        boolean rsl = true;
        if (left.length() == right.length()) {
            Map<Character, Integer> leftStr = new HashMap<>();
            for (Character character : left.toCharArray()) {
                if (leftStr.containsKey(character)) {
                    leftStr.put(character, leftStr.get(character) + 1);
                } else {
                    leftStr.put(character, 1);
                }
            }
            for (Character character : right.toCharArray()) {
                if (leftStr.containsKey(character) && leftStr.get(character) > 0) {
                        leftStr.put(character, leftStr.get(character) -1);
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