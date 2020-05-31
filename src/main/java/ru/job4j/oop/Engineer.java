package ru.job4j.oop;

import java.util.Date;

public class Engineer extends Profession {

    private Project actualProject;

    public Engineer(String name, String education, Date birthday, Project actualProject) {
        super(name, education, birthday);
        this.actualProject = actualProject;
    }

    public Project getActualProject() {
        return actualProject;
    }
}
