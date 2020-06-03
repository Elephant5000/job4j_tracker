package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        int number = 11;
        int pleers = 1;
        Scanner input = new Scanner(System.in);
        int count = 0;
        System.out.println("Игра 11 спичек.");
        System.out.println("На столе  - " + number + " спичек");
        while (number > 0) {
            System.out.println();
            System.out.println("Игрок " + pleers + " заберите 1-3 спички");
            count = Integer.valueOf(input.nextLine());
            if (count < 1 || count > 3) {
                System.out.println("Будь внимателен, от 1 до 3 спичек! Давай снова");
                continue;
            }
            if (count > number) {
                System.out.println("Ты, конечно победил. Но давай не будем брать спичек больше чем их осталось");
                continue;
            }
            number = number - count;
            System.out.println("На столе осталось - " + number + " спичек");
            if (number > 0) {
                pleers = ((pleers == 1) ? 2 : 1);
            }
        }
        System.out.println("Выиграл Игрок - " + pleers);
    }
}
