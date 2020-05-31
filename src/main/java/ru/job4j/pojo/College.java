package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan");
        student.setGroup("4107");
        student.setDate("01.01.2020");
        System.out.println(student.getFio() + "; группа - " + student.getGroup() + "; принят - " + student.getDate());
    }
}
