package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.averagingInt(Subject::getScore)))
                .entrySet().stream()
                .map(subjectMap -> new Tuple(subjectMap.getKey(), subjectMap.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                                                            .mapToDouble(Subject::getScore)
                                                            .sum())
                )
                .max(Comparator.comparing(Tuple::getScore))
                .get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(subjectMap -> new Tuple(subjectMap.getKey(), subjectMap.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .get();
    }
}