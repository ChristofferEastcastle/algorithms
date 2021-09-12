package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue2<T> implements MyQueue<T> {

    Object[] data;

    private int head = -1;
    private int tail = -1;


    private int size = 0;

    public MyRingArrayQueue2(){
        this(10);
    }

    public MyRingArrayQueue2(int capacity){
        data = new Object[capacity];
    }
    public static void main(String[] args) {

        var queue = new MyRingArrayQueue2<Integer>();
        queue.run();

    }


    public void run() {
        MyRingArrayQueue2<Integer> queue = new MyRingArrayQueue2<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.print();
        System.out.println(queue.peek());
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        System.out.println(queue.peek());

        for (int i = 5; i < 15; i++) {
            queue.enqueue(i);
        }
        System.out.printf("head: %d tail: %d\n", head, tail);
        System.out.println(queue.size());
        queue.print();
        System.out.println(queue.peek());
    }

    public void print() {
        for (int i = head; i <= tail; i++) {
            System.out.printf("%s, ", data[i]);
        }
        System.out.println();
    }
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
                    Object[] temp = new Object[data.length * 2];
                    System.arraycopy(data, 0, temp, 0, data.length);
                    data = temp;
                    tail++;
                }
            }
        } else {
            if (tail < head - 1) {
                tail++;
            } else {
                int size = data.length - head;
                Object[] temp = new Object[data.length * 2];
                if (size >= 0) System.arraycopy(data, head, temp, 0, size);

                if (tail + 1 >= 0) System.arraycopy(data, 0, temp, size, tail + 1);
                head = 0;
                tail = data.length;
                data = temp;
            }
        }
        data[tail] = value;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw  new RuntimeException();

        T value = (T) data[head];

        if (size == 1) {
            head = -1;
            tail = -1;
        } else {
            head++;
            if (head >= data.length) {
                head = 0;
            }
        }

        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException();
        return (T) data[head];
    }

    @Override
    public int size() { return size; }

}
