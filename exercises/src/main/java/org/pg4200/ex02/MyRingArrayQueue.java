package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    private Object[] data;

    public MyRingArrayQueue() { this(10); }

    public MyRingArrayQueue(int capacity) {
        data = new Object[capacity];
    }

    private int head = -1;
    private int tail = -1;

    @Override
    public void enqueue(T value) {
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else if (head <= tail) {
            if (tail < data.length - 1) {
                tail++;
            } else {
                if (head != 0) {
                    tail = 0;
                } else {
                    var tempArray = new Object[data.length * 2];
                    for (int i = 0; i < data.length; i++) {
                        tempArray[i] = data[i];
                    }
                    data = tempArray;
                    tail++;
                }
            }
        } else {
            assert tail < head;
            if (tail < head - 1) {
                tail++;
            } else {
                int size = data.length - head;
                var newArray = new Object[data.length * 2];
                for (int i = 0; i < size; i++) {
                    newArray[i] = data[head + i];
                }

                for (int i = 0; i < tail + 1; i++) {
                    newArray[size + i] = data[i];
                }
                head = 0;
                tail = data.length;
                data = newArray;
            }
        }
        data[tail] = value;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException();

        T value = (T) data[head];

        if (size() == 1) {
            head = -1;
            tail = -1;
        } else {
            head++;
            if (head >= data.length) {
                head = 0;
            }
        }
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException();

        return (T) data[head];
    }

    @Override
    public int size() {
        if (head < 0) {
            return 0;
        } else if (head == tail) {
            return 1;
        } else if (head < tail) {
            return (tail - head) + 1;
        } else {
            int size = 0;
            size += (data.length - head);
            size += tail + 1;

            return size;
        }
    }

    private Object[] copyToNew() {
        var array = new Object[data.length * 2];
        for (int i = 0; i < data.length - head; i++) {
            array[i] = data[i + head];
        }
        return array;
    }
}
