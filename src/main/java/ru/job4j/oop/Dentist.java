package ru.job4j.oop;

import java.util.Date;

public class Dentist extends Doctor {

    private Programmer bestProgrammerFriend;
    public Dentist(String name, String education, Date birthday, int quantityPatient, Programmer bestProgrammerFriend) {
        super(name, education, birthday, quantityPatient);
        this.bestProgrammerFriend = bestProgrammerFriend;
    }

    public Programmer getBestProgrammerFriend() {
        return this.bestProgrammerFriend;
    }
}
