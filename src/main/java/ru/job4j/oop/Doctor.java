package ru.job4j.oop;

import java.util.Date;

public class Doctor extends Profession {

    private int quantityPatient;

    public Doctor(String name, String education, Date birthday, int quantityPatient) {
        super(name, education, birthday);
        this.quantityPatient = quantityPatient;
    }

    public int getQuantityPatient() {
        return quantityPatient;
    }

    public void setQuantityPatient(int quantityPatient) {
        this.quantityPatient = quantityPatient;
    }
}
