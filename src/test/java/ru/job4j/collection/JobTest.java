package ru.job4j.collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByAscName() {
        Job job1 = new Job("job1", 1);
        Job job2 = new Job("job2", 1);
        Job job3 = new Job("job3", 1);
        List<Job> rsl = new ArrayList<Job>();
        rsl.add(job2); rsl.add(job1); rsl.add(job3);
        Collections.sort(rsl, new  JobAscByName());
        List<Job> expected = List.of(job1, job2, job3);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenComparatorByDescName() {
        Job job1 = new Job("job1", 1);
        Job job2 = new Job("job2", 1);
        Job job3 = new Job("job3", 1);
        List<Job> rsl = new ArrayList<Job>();
        rsl.add(job2); rsl.add(job1); rsl.add(job3);
        Collections.sort(rsl, new JobDescByName());
        List<Job> expected = List.of(job3, job2, job1);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenComparatorByAscPriority() {
        Job job1 = new Job("job1", 1);
        Job job2 = new Job("job2", 3);
        Job job3 = new Job("job3", 2);
        List<Job> rsl = new ArrayList<Job>();
        rsl.add(job2); rsl.add(job1); rsl.add(job3);
        Collections.sort(rsl, new JobAscByPriority());
        List<Job> expected = List.of(job1, job3, job2);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenComparatorByDescPriority() {
        Job job1 = new Job("job1", 1);
        Job job2 = new Job("job2", 3);
        Job job3 = new Job("job3", 2);
        List<Job> rsl = new ArrayList<Job>();
        rsl.add(job2); rsl.add(job1); rsl.add(job3);
        Collections.sort(rsl, new JobDescByPriority());
        List<Job> expected = List.of(job2, job3, job1);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenComparatorByAscNameAscPriority() {
        Job job1 = new Job("job1", 1);
        Job job2 = new Job("job3", 1);
        Job job3 = new Job("job1", 2);
        List<Job> rsl = new ArrayList<Job>();
        rsl.add(job2); rsl.add(job1); rsl.add(job3);
        Collections.sort(rsl, new  JobAscByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = List.of(job1, job3, job2);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenComparatorByDescNameAscPriority() {
        Job job1 = new Job("job1", 1);
        Job job2 = new Job("job3", 1);
        Job job3 = new Job("job1", 2);
        List<Job> rsl = new ArrayList<Job>();
        rsl.add(job2); rsl.add(job1); rsl.add(job3);
        Collections.sort(rsl, new JobDescByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = List.of(job2, job1, job3);
        assertThat(rsl, is(expected));
    }

}