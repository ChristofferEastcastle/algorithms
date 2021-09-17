package org.pg4200.ex04;

public class FibonacciImpl implements Fibonacci {

    public int compute(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;
        if (n >= 3) return compute(n - 1) + compute(n - 2);
        return 1;
    }
}