package ru.job4j.sort;

import ru.job4j.tracker.*;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int change = money - price;
        for (int coins : COINS) {
            while (change - coins >= 0) {
                change -= coins;
                rsl[size++] = coins;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}