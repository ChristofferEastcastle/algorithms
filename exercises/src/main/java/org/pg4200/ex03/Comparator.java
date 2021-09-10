package org.pg4200.ex03;

public class Comparator<T extends Comparable<?super T>> implements java.util.Comparator<T> {

    @Override
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}
