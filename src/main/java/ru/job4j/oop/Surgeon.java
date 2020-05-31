package ru.job4j.oop;

import java.util.Date;

public class Surgeon extends Doctor {

    private String relaxMethod;

    public Surgeon(String name, String education, Date birthday, int quantityPatient, String relaxMethod) {
        super(name, education, birthday, quantityPatient);
        this.relaxMethod = relaxMethod;
    }

    public String getRelaxMethod() {
        return relaxMethod;
    }
}
