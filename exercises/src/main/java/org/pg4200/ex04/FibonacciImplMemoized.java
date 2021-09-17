package org.pg4200.ex04;

import java.util.Arrays;

public class FibonacciImplMemoized implements Fibonacci{

    int[] memoization;

    public FibonacciImplMemoized() {
        memoization = new int[101];
        Arrays.fill(memoization, 0);
    }

    @Override
    public int compute(int n) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memoization[n] != 0) return memoization[n];

        int result = compute(n - 2) + compute(n - 1);

        memoization[n] = result;

        return result;
    }
}
