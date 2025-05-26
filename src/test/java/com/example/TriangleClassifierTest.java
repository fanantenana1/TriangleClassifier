package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TriangleClassifierTest {
    @Test
    public void testEquilateral() {
        assertEquals("Equilateral", TriangleClassifier.classify(5, 5, 5));
    }

    @Test
    public void testIsosceles() {
        assertEquals("Isosceles", TriangleClassifier.classify(5, 5, 3));
    }

    @Test
    public void testScalene() {
        assertEquals("Scalene", TriangleClassifier.classify(4, 5, 6));
    }

    @Test
    public void testInvalid() {
        assertEquals("Invalid", TriangleClassifier.classify(1, 2, 3));
    }
}

