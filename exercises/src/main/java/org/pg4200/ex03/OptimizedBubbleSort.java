package org.pg4200.ex03;


import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized) {
        int comparatorCalled = 0, size = array.length - 1;
        int lastSwapped = size;

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < size; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    comparatorCalled++;
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                    lastSwapped = i;
                }
            }
            if (optimized) {
                if (swapped) size = lastSwapped;
            }
        }
        return comparatorCalled;
    }
}