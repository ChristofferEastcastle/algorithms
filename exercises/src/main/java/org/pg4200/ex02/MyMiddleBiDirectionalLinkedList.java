package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

public class MyMiddleBiDirectionalLinkedList<T> implements MyList<T> {



    private class Node {
        T value;
        Node next;
        Node prev;
    }

    private Node head;

    private Node middle;

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
                middle = null;
            }
        } else if (index == size - 1) {
            tail.prev = tail;
        } else {
            Node current;
            System.out.println((size / 4) + " index: " + index);
            if (index <= size / 4 || index < 10) {
                current = nextTraversal(index, 0, head);
            } else if (index > (size / 4) && index <= size / 2) {
                current = prevTraversal(index, size / 2, middle);
            } else if (index == size / 2 || index < (size / 2) + (size / 4)) {
                current = nextTraversal(index, size / 2, middle);
            } else {
                current = prevTraversal(index, size - 1, tail);
            }

            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        size--;
    }

    private Node prevTraversal(int index, int counter, Node current) {
        while (counter != index) {
            current = current.prev;
            counter--;
        }
        return current;
    }

    private Node nextTraversal(int index, int counter, Node current) {
        while (counter != index) {
            current = current.next;
            counter++;
        }
        return current;
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
            middle = node;
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