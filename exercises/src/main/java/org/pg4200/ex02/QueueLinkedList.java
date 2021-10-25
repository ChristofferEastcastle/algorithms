package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class QueueLinkedList<T> implements MyQueue<T> {

    private int size = 0;
    private Node head;
    private Node tail;

    public boolean contains(T value) {
        Node current = head;

        while (current != null) {
            if (current.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%s, ", current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.print();

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }
        queue.print();
    }

    public void enqueue(T value) {
        Node node = new Node(value);

        if (head == null) head = node;

        else tail.next = node;

        tail = node;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException();

        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException();
        return head.value;
    }

    public int size() { return size; }

    private class Node {
        private final T value;
        private Node next;

        public Node(T value) { this.value = value; }
    }
}