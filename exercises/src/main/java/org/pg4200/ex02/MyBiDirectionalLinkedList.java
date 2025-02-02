package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

public class MyBiDirectionalLinkedList<T> implements MyList<T> {




    private class Node {
        T value;
        Node next;
        Node prev;
    }

    private Node head;

    private Node tail;

    private int size = 0;


    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
                tail = null;
            }
        } else if (index == size - 1) {
            tail.prev = tail;
        } else {
            Node current;

            if (index <= (size / 2)) {
                current = head;
                int counter = 0;
                while (counter != index) {
                    current = current.next;
                    counter++;
                }
            } else {
                current = tail;
                int counter = size - 1;
                while (counter != index) {
                    current = current.prev;
                    counter--;
                }
            }
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }

        size--;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        // Checking if best to traverse from head or tail.
        if (index <= (size / 2)) {
            Node current = head;
            int counter = 0;
            while (current != null) {
                if (counter == index) {
                    return current.value;
                }
                current = current.next;
                counter++;
            }
        } else {
            Node current = tail;
            int counter = size - 1;
            while (current != null) {
                if (counter == index) {
                    return current.value;
                }
                current = current.prev;
                counter--;
            }
        }


        assert false;
        return null;
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;

        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;

        } else {
            Node current;
            int counter;
            if (index <= (size / 2)) {
                current = head;
                counter = 0;
                while (counter != index) {
                    current = current.next;
                    counter++;
                }
                node.next = current;
                node.prev = current.prev;
                current.prev.next = node;

            } else {
                current = tail;
                counter = size - 1;
                while (counter != index) {
                    current = current.prev;
                    counter--;
                }
                current.prev.next = node;
                node.next = current;
                current.prev = node;
                node.prev = current.prev;
            }
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }


    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%s --> ", current.value);
            current = current.next;
        }
    }
}