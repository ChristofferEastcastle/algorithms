package org.pg4200.ex02;

import org.junit.jupiter.api.Test;
import org.pg4200.les02.list.MyList;
import org.pg4200.les02.list.MyListTestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBiDirectionalLinkedListTest extends MyListTestTemplate {

    @Override
    protected <T> MyList<T> getNewInstance(Class<T> klass) {
        return new MyBiDirectionalLinkedList<>();
    }

    @Test
    public void testStep() {
        int n = 1_000;
        int half = n / 2, quarter = n / 4;
        MyList<Integer> data = getNewInstance(Integer.class);


        for (int i = 0; i < n; i++) {
            data.add(i, i);
        }

        assertEquals(n, data.size());


        for (int i = n - 1; i >= half; i--) {
            data.delete(i);
        }

        assertEquals(half, data.size());

        for (int i = half; i < half + quarter; i++) {
            data.add(i, i);
        }

        assertEquals(n - quarter, data.size());

        for (int i = half + quarter; i < n; i++) {
            data.add(i, i);
        }

        assertEquals(n, data.size());
    }

    @Test
    public void testAddAlmostAtEnd() {
        int n = 10;
        MyBiDirectionalLinkedList<Integer> data = new MyBiDirectionalLinkedList<>();
        for (int i = 0; i <= n; i++) {
            data.add(i, i);
        }

        data.add(8, 69);

        int res = data.get(8);
        assertEquals(69, res);
    }

}