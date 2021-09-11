package org.pg4200.ex03;

public class SortCheckerImp implements SortChecker{

    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {
        if (original == null && sorted == null) return true;

        if (original == null || sorted == null) return false;

        if (original.length == 0 || sorted.length == 0) return true;

        if (original.length == 1 && sorted.length == 1) return true;

        T t = sorted[0];
        if (t == null) return false;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == null) return false;
            if (sorted[i].compareTo(sorted[i - 1]) < 0) return false;
            if (sorted[i].compareTo(t) < 0) return false;
        }

        return true;
    }
}
