package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("Ivanov Ivan", 80),
                new Student("Petrov Petr", 90),
                new Student("Ivanova Ivanka", 69),
                new Student("Ivanova Ivanka", 69),
                new Student("Tretyakova Aglaya", 40)
        );

        System.out.println(
                studentList.stream()
                        .collect(Collectors.toMap(
                                Student::getSurname,
                                e -> e,
                                (oldValue, newValue) -> newValue
                        ))
        );

        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(
                matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList())
        );


        Integer[][] matrixI = {{1, 3}, {5, 7}};
        System.out.println(
                Arrays.stream(matrixI).flatMap(integers -> Arrays.stream(integers.clone())).collect(Collectors.toList())
        );

        System.out.println(

                Stream.of(matrixI).flatMap(integers -> Stream.of(integers.clone())).collect(Collectors.toList())
        );
    }
}
