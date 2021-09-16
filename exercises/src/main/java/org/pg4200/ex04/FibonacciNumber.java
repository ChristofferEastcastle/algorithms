package org.pg4200.ex04;

public class FibonacciNumber {

    public static long fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(30));
    }
}
