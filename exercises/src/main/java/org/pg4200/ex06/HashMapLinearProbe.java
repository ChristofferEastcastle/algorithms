package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;

import java.lang.reflect.Array;

public class HashMapLinearProbe<K, V> implements MyHashMap<K, V> {
    private static final int M = 971;
    private int size = 0;

    private final Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

    private int index(K key) {
        return (key.hashCode() & 0x7f_ff_ff_ff) % M;
    }

    @Override
    public void put(K key, V value) {
        Entry entry = new Entry(key, value);
        int index = index(key);
        if (data[index] != null && data[index].key != null) {
            int counter = 0;
            while (data[index] != null && data[index].key != null) {
                if (data[index].key.equals(key)) {
                    data[index].value = value;
                    return;
                }
                if (++index >= data.length) index = 0;
                if (++counter >= data.length) {
                    return;
                }
            }
        }
        data[index] = entry;
        size++;
    }

    @Override
    public void delete(K key) {
        int index = index(key);
        int counter = 0;
        for (int i = index; i < data.length; i++) {
            if (data[index].key.equals(key)) {
                data[index].key = null;
                size--;
                return;
            }
            if (index == data.length - 1) {
                index = 0;
            }
            if (counter++ == data.length) {
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int counter = 0;
        for (int i = index(key); i < data.length; i++) {
            if (data[i] == null || data[i].key == null) return null;
            if (data[i].key.equals(key)) {
                return data[i].value;
            }
            if (counter++ == data.length) {
                return null;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
