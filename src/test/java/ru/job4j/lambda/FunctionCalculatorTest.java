package ru.job4j.lambda;

import org.junit.Test;
import ru.job4j.lambda.FunctionCalculator;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionCalculatorTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalculator.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLineFunction() {
        List<Double> result = FunctionCalculator.diapason(5, 8, x -> x + 1);
        List<Double> expected = Arrays.asList(6D, 7D, 8D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSqFunction() {
        List<Double> result = FunctionCalculator.diapason(1, 4, x -> x * x + 1);
        List<Double> expected = Arrays.asList(2D, 5D, 10D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenExpFunction() {
        List<Double> result = FunctionCalculator.diapason(1, 4, x -> Math.pow(2,x) + 1);
        List<Double> expected = Arrays.asList(3D, 5D, 9D);
        assertThat(result, is(expected));
    }
}