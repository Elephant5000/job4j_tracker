package ru.job4j.stream;

import ru.job4j.oop.College;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Метод averageScore вычисляет общий средний балл.

Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
Возвращает список из объекта Tuple (имя ученика и средний балл).

Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
Возвращает список из объекта Tuple (название предмета и средний балл).

Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.

Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)

Для решения этой задачи вам нужны методы mapToInt, sum, average.
 */

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToDouble(Subject::getScore)
                .average()
                .getAsDouble();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .getAsDouble())
                )
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        var subjectStream = stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .sorted()
                .distinct();


        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        var rsl = stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                                                            .mapToDouble(Subject::getScore)
                                                            .sum())
                )
                .max(Comparator.comparing(Tuple::getScore))
                .get();
        return rsl;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}