package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;


public class MyArrayListResizable<T> extends MyArrayList<T> {


    public MyArrayListResizable() { super(); }
    public MyArrayListResizable(int capacity) { super(capacity); }


    @Override
    public void add(int index, T value) {
        if (this.size + 1 > data.length) {
            Object[] newArray = new Object[this.size * 2];
            data = copyToNew(newArray);
        }
        super.add(index, value);
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    private Object[] copyToNew(Object[] array) {
        if (this.size >= 0) System.arraycopy(data, 0, array, 0, this.size);
        return array;
    }
}