package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseArrayTest {

    private ReverseArray rev = new ReverseArray();

    @Test
    void testIntegerReverse1() {
        Integer[] a = {0, 1, 2, 3, 4, 5};
        Integer[] b = {5, 4, 3, 2, 1, 0};
        rev.reverse(a,0, 5);
        assertArrayEquals(b, a);
    }

    @Test
    void testStringReverse1() {
        String[] a = {"a", "b", "c", "d", "e"};
        String[] b = {"e", "d", "c", "b", "a"};
        rev.reverse(a,0, 4);
        assertArrayEquals(b, a);
    }

    @Test
    void testIntegerTwiceReverse() {
        Integer[] a = {0, 1, 2, 3, 4, 5, 1938, 9837, 23, 7523, 1212};
        rev.reverse(a,0, 10);
        rev.reverse(a, 0, 10);
        assertArrayEquals(a, a);
    }

    @Test
    void testStringReverse2() {
        String[] a = {"utah", "to", "roads", "public", "over", "moving", "car", "black" ,"a"};
        String[] b = {"a", "black", "car", "moving", "over", "public", "roads", "to", "utah"};
        rev.reverse(a,0, 8);
        assertArrayEquals(b, a);
    }

    @Test
    void testIntegerAndID1 () {
        IntegerAndID number1 = new IntegerAndID(1, 1);
        IntegerAndID number2 = new IntegerAndID(2, 2);
        IntegerAndID number3 = new IntegerAndID(2, 3);
        IntegerAndID number4 = new IntegerAndID(1, 4);
        IntegerAndID number5 = new IntegerAndID(2, 5);
        IntegerAndID [] a = {number1, number2, number3, number4, number5};
        IntegerAndID [] b = {number5, number4, number3, number2, number1};
        rev.reverse(a, 0, 4);
        assertArrayEquals(b, a);
    }

    @Test
    void testIntegerPartlyReverse1() {
        Integer[] a = {0, 1, 2, 3, 4, 5};
        Integer[] b = {4, 3, 2, 1, 0, 5};
        rev.reverse(a,0, 4);
        assertArrayEquals(b, a);
    }

    @Test
    void testIntegerPartlyReverse2() {
        Integer[] a = {0, 1, 2, 3, 4, 5};
        Integer[] b = {0, 5, 4, 3, 2, 1};
        rev.reverse(a,  1, 5);
        assertArrayEquals(b, a);
    }

    @Test
    void testIntegerPartlyReverse3() {
        Integer[] a = {0, 1, 2, 3, 4, 5};
        Integer[] b = {0, 4, 3, 2, 1, 5};
        rev.reverse(a,1, 4);
        assertArrayEquals(b, a);
    }
}
