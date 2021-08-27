package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.pg4200.ex01.TriangleClassification.*;

public class TriangleClassificationTest{

    @Test
    public void lessThanOrEqualToZero(){
        assertEquals(Classification.NOT_A_TRIANGLE, classify(0, -3, -29));

    }

    @Test
    public void testEquilateral(){
        assertEquals(Classification.EQUILATERAL, classify(5, 5 ,5));
    }

    @Test
    public void testIsosceles(){
        assertEquals(Classification.ISOSCELES, classify(4, 5, 4));
    }

    @Test
    public void testScalene(){
        assertEquals(Classification.SCALENE, classify(2, 4, 3));
    }

    @Test
    public void testMax(){
        assertEquals(Classification.NOT_A_TRIANGLE, classify(10, 3, 4));
    }
}
