package ru.job4j.oop;

import java.util.Date;

public class Programmer extends Engineer {

    private String favoriteLanguage;

    public Programmer(String name, String education, Date birthday, Project project, String favoriteLanguage) {
        super(name, education, birthday, project);
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFavoriteLanguage() {
        return this.favoriteLanguage;
    }
}
