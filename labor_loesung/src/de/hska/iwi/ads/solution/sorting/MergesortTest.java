package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergesortTest {

    @Test
    void testIntegerSort1() {
        Mergesort<Integer> m = new Mergesort<>();
        Integer [] a = {11, 10, 9, 7, 4, 2, 0};
        Integer [] ergebnis = {0, 2, 4, 7, 9, 10, 11};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testStringSort1() {
        Mergesort<String> m = new Mergesort<>();
        String [] a = {"c", "e", "g", "a"};
        String [] ergebnis = {"a", "c", "e", "g"};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testIntegerSort2() {
        Mergesort<Integer> m = new Mergesort<>();
        Integer [] a = {-10, 4, 7, 19, 0 ,23, 5, 19, 17, 100, -4};
        Integer [] ergebnis = {-10, -4, 0, 4, 5, 7, 17, 19, 19, 23, 100};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testStringSort2() {
        Mergesort<String> m = new Mergesort<>();
        String [] a = {"black", "over", "a", "utah", "to", "car", "public", "roads", "moving"};
        String [] ergebnis = {"a", "black", "car", "moving", "over", "public", "roads", "to", "utah"};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testIntegerSortEmpty() {
        Mergesort<Integer> m = new Mergesort<>();
        Integer [] a = {};
        Integer [] ergebnis = {};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testStringSortEmpty() {
        Mergesort<String> m = new Mergesort<>();
        String [] a = {};
        String [] ergebnis = {};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testIntegerSortOneElement() {
        Mergesort<Integer> m = new Mergesort<>();
        Integer [] a = {0};
        Integer [] ergebnis = {0};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testStringSortOneElement() {
        Mergesort<String> m = new Mergesort<>();
        String [] a = {"OneString"};
        String [] ergebnis = {"OneString"};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
    }

    @Test
    void testIntegerAndIDSortStable1() {
        IntegerAndID number1 = new IntegerAndID(1, 1);
        IntegerAndID number2 = new IntegerAndID(2, 2);
        IntegerAndID number3 = new IntegerAndID(2, 3);
        IntegerAndID number4 = new IntegerAndID(1, 4);
        IntegerAndID number5 = new IntegerAndID(2, 5);
        Mergesort<IntegerAndID> m = new Mergesort<IntegerAndID>();
        IntegerAndID [] a = {number1, number2, number3, number4, number5};
        IntegerAndID [] ergebnis = {number1, number4, number2, number3,number5};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
        assertEquals(1, a[0].getId());
        assertEquals(4, a[1].getId());
        assertEquals(2, a[2].getId());
        assertEquals(3, a[3].getId());
        assertEquals(5, a[4].getId());


    }

    @Test
    void testIntegerAndIDSortStable2() {
        IntegerAndID number1 = new IntegerAndID(1, 1);
        IntegerAndID number2 = new IntegerAndID(1, 2);
        IntegerAndID number3 = new IntegerAndID(1, 3);
        IntegerAndID number4 = new IntegerAndID(1, 4);
        IntegerAndID number5 = new IntegerAndID(1, 5);
        Mergesort<IntegerAndID> m = new Mergesort<IntegerAndID>();
        IntegerAndID [] a = {number1, number2, number3, number4, number5};
        IntegerAndID [] ergebnis = {number1, number4, number2, number3,number5};
        m.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
        assertEquals(1, a[0].getId());
        assertEquals(2, a[1].getId());
        assertEquals(3, a[2].getId());
        assertEquals(4, a[3].getId());
        assertEquals(5, a[4].getId());
    }


    boolean arrayEquals(Comparable[] e, Comparable[] a) {
        boolean equals = true;
        if (e.length != a.length) {
            equals = false;
        }
        for (int i = 0; i < e.length; i++) {
            if (a[i].compareTo(e[i]) != 0) {
                equals = false;
            }
        }
        return equals;
    }
}
