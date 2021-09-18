package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    private int bubbleLimit;

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        bubbleLimit = 4;
        mergeSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] array, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;

        if (end - start <= bubbleLimit) {
            bubbleSort(array, start, end);

        } else {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            merge(array, start, mid, end);
        }
    }

    private <T extends Comparable<T>> void merge(T[] array, int start, int mid, int end ) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        T[] left = (T[]) new Comparable[n1];
        T[] right = (T[]) new Comparable[n2];

        System.arraycopy(array, start, left, 0, n1);
        for (int i = 0; i < n2; i++) {
            right[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) < 0) {
                array[k] = left[i++];
            } else {
                array[k] = right[j++];
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i++];
            k++;
        }

        while (j < n2) {
            array[k] = right[j++];
            k++;
        }
    }

    private <T extends Comparable<T>> void bubbleSort(T[] array, int start, int end) {
        boolean swapped;
        do {
            swapped = false;

            for (int i = start; i < end; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
