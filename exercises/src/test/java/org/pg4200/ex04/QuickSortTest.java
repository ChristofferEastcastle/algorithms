package org.pg4200.ex04;

import org.junit.jupiter.api.Test;
import org.pg4200.ex03.GameUser;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {
    private QuickSort QuickSort = new QuickSort();


    @Test
    void testSmallInput() {
        Integer[] sorted = {1, 2, 3, 4};
        Integer[] unsorted = {3, 4, 2, 1};
        QuickSort.sort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testMediumInput() {
        int n = 50;
        Random rand = new Random();
        Integer[] unsorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = rand.nextInt(n);
        }
        Integer[] sorted = unsorted.clone() ;
        Arrays.sort(sorted);

        QuickSort sorter = new QuickSort();
        sorter.sort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testLargeInput() {
        int n = 100000;
        Random rand = new Random();
        Integer[] unsorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = rand.nextInt(n);
        }
        Integer[] sorted = unsorted.clone() ;
        Arrays.sort(sorted);

        QuickSort sorter = new QuickSort();
        sorter.sort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testLargeInputGameUsers() {
        int n = 100000;
        GameUser[] unsorted = new GameUser[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randInt = rand.nextInt(n);
            unsorted[i] = new GameUser(Integer.toString(randInt), randInt);
        }
        GameUser[] sorted = unsorted.clone() ;
        Arrays.sort(sorted);

        QuickSort sorter = new QuickSort();
        sorter.sort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }
}
