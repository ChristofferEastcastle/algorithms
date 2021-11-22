package org.pg4200.ex05;

import org.pg4200.les05.MyMapTreeBased;

import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K, V> {

    protected Node root;
    protected int size = 0;

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(key, value, root);

    }

    private Node put(K key, V value, Node subTree) {
        if (subTree == null) {
            Node node = new Node();
            node.firstKey = key;
            node.firstValue = value;
            size++;
            return node;
        }

        int firstKeyCmp = key.compareTo(subTree.firstKey);

        if (firstKeyCmp < 0) {
            subTree.left = put(key, value, subTree.left);
        } else if (firstKeyCmp == 0) {
            subTree.firstValue = value;
        } else {

            if (subTree.secondKey == null) {
                size++;
                subTree.secondKey = key;
                subTree.secondValue = value;
            } else {
                int secondKeyCompare = key.compareTo(subTree.secondKey);

                if (secondKeyCompare < 0) {
                    subTree.middle = put(key, value, subTree.middle);
                } else if (secondKeyCompare == 0) {
                    subTree.secondValue = value;
                } else {
                    subTree.right = put(key, value, subTree.right);
                }
            }
        }
        return subTree;
    }

    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);
        root = delete(key, root);
    }

    protected Node delete(K key, Node subTree) {
        if (subTree == null) return null;

        int cmp = key.compareTo(subTree.firstKey);

        if (cmp < 0) {
            subTree.left = delete(key, subTree);
            return subTree;
        } else if (cmp == 0) {

            Node smallest = findSmallest(key,subTree);
            subTree.firstKey = null;
            subTree.secondKey = null;
            return subTree;
        } else {
            int secondCmp = key.compareTo(subTree.secondKey);

            if (secondCmp < 0) {
                subTree.middle = delete(key, subTree);
            } else if (secondCmp == 0) {
                //subTree = swap()
            }

        }
        subTree.middle = delete(key, subTree);
        return subTree;
    }

    private Node findSmallest(K key, Node subTree) {
        if (subTree.firstKey == null) return subTree;
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getMaxTreeDepth() {
        return 0;
    }

    protected class Node {
        K firstKey;
        K secondKey;
        V firstValue;
        V secondValue;

        Node left;
        Node middle;
        Node right;
    }
}
