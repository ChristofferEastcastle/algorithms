package org.pg4200.ex03;

import java.util.Arrays;

public class SortCheckerImp implements SortChecker{

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {
        if (original == null && sorted == null) return true;

        if (original == null || sorted == null) return false;

        if (original.length == 0 || sorted.length == 0) return true;

        if (original.length == 1 && sorted.length == 1) return true;

        if (original.length != sorted.length) return false;

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] == null || original[i] == null) return false;
        }
        T[] array = original.clone();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (sorted[i] != array[i]) return false;
        }

        return true;
    }
}