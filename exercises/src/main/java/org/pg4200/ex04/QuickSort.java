package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort implements MySort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) return;

        sort(array, 0, array.length - 1);
    }


    private <T extends Comparable<T>> void sort(T[] array, int left, int right) {
        if (left >= right) return;

        int p = partition(array, left, right);

        sort(array, left, p - 1);
        sort(array, p + 1, right);
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        if (array == null || array.length <= 1) return - 1;
        T pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);

        return i + 1;
    }

    private <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        if (array == null || array.length <= 1) return;
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
