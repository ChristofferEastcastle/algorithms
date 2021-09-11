package org.pg4200.ex03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptimizedBubbleSortTest {
    private static Integer[] integers;

    @BeforeAll
    static void createArrays() {
        integers = new Integer[10000];
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            integers[i] = rand.nextInt(25000);
        }
    }

    @Test
    void testCustomInputStringsOptimized() {
        String[] customInput = {"c", "b", "a", "d", "e", "f"};
        String[] sorted = {"a", "b", "c", "d", "e", "f"};
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        int out = sorter.sort(customInput, new Comparator<>(), true);
        System.out.println(out);

        for (String s : customInput) {
            System.out.printf("%s, ", s);
        }
        System.out.println();

        assertArrayEquals(sorted, customInput);
    }

    @Test
    void testCustomInputStringsNotOptimized() {
        String[] customInput = {"c", "b", "a", "d", "e", "f"};
        String[] sorted = {"a", "b", "c", "d", "e", "f"};
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        int out = sorter.sort(customInput, new Comparator<>(), false);
        System.out.println(out);

        for (String s : customInput) {
            System.out.printf("%s, ", s);
        }

        assertArrayEquals(sorted, customInput);
    }

    @Test
    void testCustomInputIntsNotOptimized() {
        Integer[] actual = integers.clone();
        Integer[] array = integers.clone();

        Arrays.sort(actual);
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        long start = System.currentTimeMillis();
        int out = sorter.sort(array, new Comparator<>(), false);
        long end = System.currentTimeMillis();
        System.out.printf("%d : %.3f\n", out, (end - start) * 0.001);
        assertArrayEquals(actual, array);
    }

    @Test
    void testCustomInputIntsOptimized() {
        Integer[] actual = integers.clone();
        Integer[] array = integers.clone();

        Arrays.sort(actual);
        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        long start = System.currentTimeMillis();
        int out = sorter.sort(array, new Comparator<>(), true);
        long end = System.currentTimeMillis();
        System.out.printf("%d : %.3f\n", out, (end - start) * 0.001);
        assertArrayEquals(actual, array);
    }
}
