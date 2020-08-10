package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        //List <Student> studentList = new ArrayList<>();
        List<Student> studentList = List.of(
                new Student("Ivanov Ivan", 80),
                new Student("Petrov Petr", 90),
                new Student("Ivanova Ivanka", 69),
                new Student("Ivanova Ivanka", 69),
                new Student("Tretyakova Aglaya", 40)
        );

        System.out.println(studentList);

        System.out.println(
                studentList.stream().distinct().collect(Collectors.toMap(
                e -> e.getSurname(),
                e -> e
        ))
        );
    }
}
