package org.pg4200.ex04;

import org.junit.jupiter.api.Test;
import org.pg4200.ex03.GameUser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MixedSortTest {
    private MixedSort mixedSort = new MixedSort();


    @Test
    void testSmallInput() {
        Integer[] sorted = {1, 2, 3, 4};
        Integer[] unsorted = {3, 4, 2, 1};
        mixedSort.sort(unsorted);

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

        MixedSort sorter = new MixedSort();
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

        MixedSort sorter = new MixedSort();
        sorter.sort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testLargeInputGameUsers() {
        int n = 100000;
        GameUser[] unsorted = new GameUser[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            Integer randInt = rand.nextInt(n);
            unsorted[i] = new GameUser(randInt.toString(), randInt);
        }
        GameUser[] sorted = unsorted.clone() ;
        Arrays.sort(sorted);

        MixedSort sorter = new MixedSort();
        sorter.sort(unsorted);

        for (var user : unsorted) {
            System.out.printf("%s, ", user.getPoints());
        }

        assertArrayEquals(sorted, unsorted);
    }
}
