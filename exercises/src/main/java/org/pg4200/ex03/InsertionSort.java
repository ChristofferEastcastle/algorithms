package org.pg4200.ex03;

public class InsertionSort {

    public <T extends Comparable<T>> void sort(T[] array, Comparator<T> comparator) {
        if (array == null) return;

        for (int i = 1; i < array.length; i++) {

            for (int j = i -1; j >= 0; j--) {

                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}