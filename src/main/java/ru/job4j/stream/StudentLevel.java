package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                //.flatMap(Stream::ofNullable) в уроке выше так убираются NULL
                .filter(st -> st != null) // но раз в задании через Фильтр, то так
                .sorted((left, right) -> left.getScore() - right.getScore())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
