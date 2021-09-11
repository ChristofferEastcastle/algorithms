package org.pg4200.ex03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {
    private static Integer[] integers;

    @BeforeAll
    static void createArrays() {
        integers = new Integer[100000];
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            integers[i] = rand.nextInt(25000);
        }
    }

    @Test
    void testCustomInputStringsOptimized() {
        String[] customInput = {"c", "b", "a", "d", "e", "f"};
        String[] sorted = {"a", "b", "c", "d", "e", "f"};
        InsertionSort sorter = new InsertionSort();

        sorter.sort(customInput, new Comparator<>());
        assertArrayEquals(sorted, customInput);
    }

    @Test
    void testCustomInputStringsNotOptimized() {
        String[] customInput = {"c", "b", "a", "d", "e", "f"};
        String[] sorted = {"a", "b", "c", "d", "e", "f"};
        InsertionSort sorter = new InsertionSort();

        sorter.sort(customInput, new Comparator<>());

        assertArrayEquals(sorted, customInput);
    }

    @Test
    void testCustomInputIntsNotOptimized() {
        Integer[] actual = integers.clone();
        Integer[] array = integers.clone();

        long start = System.currentTimeMillis();
        Arrays.sort(actual);
        long end = System.currentTimeMillis();
        System.out.printf("%.3fs\n", (end - start) * 0.001);
        InsertionSort sorter = new InsertionSort();
        start = System.currentTimeMillis();
        sorter.sort(array, new Comparator<>());
        end = System.currentTimeMillis();
        System.out.printf("%.3fs\n", (end - start) * 0.001);
        assertArrayEquals(actual, array);
    }

    @Test
    void sortGameUserObjects() {
        GameUser[] array = new GameUser[100];
        int j = 100;
        for (int i = 0; i < 100; i++) {
            array[i] = new GameUser(String.valueOf(j--), j);
        }
        GameUser[] actual = array.clone();
        Arrays.sort(actual);

        InsertionSort sorter = new InsertionSort();
        sorter.sort(array, new Comparator<>());

        assertArrayEquals(actual, array);
    }
}
