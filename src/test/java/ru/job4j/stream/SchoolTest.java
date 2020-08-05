package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void when70to100collect() {
        List<Student> studentList = List.of(
                new Student("Ivanov Ivan", 80),
                new Student("Petrov Petr", 90),
                new Student("Ivanova Ivanka", 69),
                new Student("Tretyakova Aglaya", 40)
        );
        List<Student> expect = List.of(
                new Student("Ivanov Ivan", 80),
                new Student("Petrov Petr", 90)
        );
        List<Student> result = School.collect(studentList, student -> student.getScore() >= 70);
        assertThat(result, is(expect));
    }

    @Test
    public void when50to70collect() {
        List<Student> studentList = List.of(
                new Student("Ivanov Ivan", 80),
                new Student("Petrov Petr", 90),
                new Student("Ivanova Ivanka", 69),
                new Student("Tretyakova Aglaya", 40)
        );
        List<Student> expect = List.of(
                new Student("Ivanova Ivanka", 69)
        );
        List<Student> result = School.collect(studentList, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(result, is(expect));
    }

    @Test
    public void when0to50collect() {
        List<Student> studentList = List.of(
                new Student("Ivanov Ivan", 80),
                new Student("Petrov Petr", 90),
                new Student("Ivanova Ivanka", 69),
                new Student("Tretyakova Aglaya", 40)
        );
        List<Student> expect = List.of(
                new Student("Tretyakova Aglaya", 40)
        );
        List<Student> result = School.collect(studentList, student -> student.getScore() < 50);
        assertThat(result, is(expect));
    }

}