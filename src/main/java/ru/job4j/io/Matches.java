package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        int number = 11;
        int pleers = 1;
        Scanner input = new Scanner(System.in);
        String countStr = new String();
        int countInt;
        System.out.println("Игра 11 спичек.");
        System.out.println("На столе  - " + number + " спичек");
        while (number > 0) {
            System.out.println();
            System.out.println("Игрок " + pleers + " заберите 1-3 спички");
            countStr = input.nextLine();
            countInt = Integer.valueOf(countStr);
            if (countInt < 1 || countInt > 3) {
                System.out.println("Будь внимателен, от 1 до 3 спичек! Давай снова");
                continue;
            }
            if (countInt > number) {
                System.out.println("Ты, конечно победил. Но давай не будем брать спичек больше чем их осталось");
                continue;
            }
            number = number - countInt;
            System.out.println("На столе осталось - " + number + " спичек");
            if (number > 0) {
                pleers = ((pleers == 1) ? 2 : 1);
            }
        }
        System.out.println("Выиграл Игрок - " + pleers);
    }
}
