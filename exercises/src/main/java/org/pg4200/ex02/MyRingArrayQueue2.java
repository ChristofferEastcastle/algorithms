package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue2<T> implements MyQueue<T> {

    Object[] data;

    private int head = -1;
    private int tail = -1;

    public MyRingArrayQueue2(){
        this(10);
    }

    public MyRingArrayQueue2(int capacity){
        data = new Object[capacity];
    }
    public static void main(String[] args) {

    }


    public void run() {
        MyRingArrayQueue2 queue = new MyRingArrayQueue2<Integer>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(3);
    }

    @Override
    public void enqueue(T value) {
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else if (tail < data.length - 1 && tail > head) {
            tail++;
        } else if (tail == data.length - 1 && head != 0) {
            tail = 0;
        } else {

        }
    }

    private void loopAround() {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
