package ru.job4j.oop;

import java.util.Date;

public class Profession {
    private String name;
    private String education;
    private Date birthday;

    public Profession(String name, String education, Date birthday) {
        this.name = name;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getEducation() {
        return this.education;
    }

    public Date getBirthday() {
        return this.birthday;
    }
}
