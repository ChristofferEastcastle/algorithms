package org.pg4200.ex01;


public class ArrayUtilsImp implements ArrayUtils {

    @Override
    public int min(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int min = array[0];
        for (int num : array){
            if (num < min) min = num;
        }
        return min;
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int max = array[0];
        for (int num : array){
            if (num > max) max = num;
        }
        return max;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        checkArray(array);

        double sum = 0;
        for (int num : array) sum += num;

        return sum / array.length;
    }

    private void checkArray(int[] array) throws IllegalArgumentException{
        if (array == null || array.length <= 0)
            throw new IllegalArgumentException("Array is null or empty");

    }
}
