package org.pg4200.ex08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {
    private AnotherStreamList<String> initTestData(){
        AnotherStreamList<String> list = new AnotherStreamList<>();

        list.add("a");
        list.add("a");
        list.add("strange");
        list.add("things");
        list.add("with");
        list.add("streams");
        list.add("streams");
        list.add("streams");

        return list;
    }

    @Test
    public void testCount(){

        var list = initTestData();

        int result = list.stream().count();

        assertEquals(list.size(), result);
    }

    @Test
    public void testDistinct() {
        var list = initTestData();
        assertEquals(5, list.stream().distinct().count());

    }

    @Test
    public void testSkip() {
        var list = initTestData();

        assertEquals(2, list.stream().skip(6).count());
    }
}
