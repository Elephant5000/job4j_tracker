package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(new Fact().calc(7));
        System.out.println(new Fact().calc(-7));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Для отрицательных чисел Факториал не существует");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}