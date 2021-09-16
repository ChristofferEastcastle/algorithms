package org.pg4200.ex04;

public class SumArrayRecursive {

    public static int sum(int[] array) {

        return sum(array, 0, array.length - 1);
    }

    private static int sum(int[] array, int start, int end) {
        int current = array[start];

        if (start == end) return current;

        return current + sum(array, ++start, end);
    }

    public static void main(String[] args) {
        int[] arr = {1,34,6,43,2,15,6,6362,3,134,56,54362,2,45,5643,531};
        System.out.println(sum(arr));
    }
}
