package ru.job4j.oop;

import java.util.Date;

public class Builder extends Engineer {

    private String qualification;

    public Builder(String name, String education, Date birthday, Project project, String qualification) {
        super(name, education, birthday, project);
        this.qualification = qualification;
    }

    public String getQualification() {
        return this.qualification;
    }
}
