package ru.job4j.oop;

public class Project {

    private String name;
    private String status;

    public Project(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
