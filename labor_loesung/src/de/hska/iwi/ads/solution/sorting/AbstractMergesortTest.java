package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractMergesortTest {

    protected abstract Sort<Integer> createMergesortInteger();
    protected abstract Sort<String> createMergesortString();
    protected abstract Sort<IntegerAndID> createMergesortIntegerAndID();



    @Test
    void testIntegerSort1() {
        Sort<Integer> m = createMergesortInteger();
        Integer [] a = {11, 10, 9, 7, 4, 2, 0};
        Integer [] ergebnis = {0, 2, 4, 7, 9, 10, 11};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSort1() {
        Sort<String> m = createMergesortString();
        String [] a = {"c", "e", "g", "a"};
        String [] ergebnis = {"a", "c", "e", "g"};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSort2() {
        Sort<Integer> m = createMergesortInteger();
        Integer [] a = {-10, 4, 7, 19, 0 ,23, 5, 19, 17, 100, -4};
        Integer [] ergebnis = {-10, -4, 0, 4, 5, 7, 17, 19, 19, 23, 100};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSort2() {
        Sort<String> m = createMergesortString();
        String [] a = {"black", "over", "a", "utah", "to", "car", "public", "roads", "moving"};
        String [] ergebnis = {"a", "black", "car", "moving", "over", "public", "roads", "to", "utah"};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSortEmpty() {
        Sort<Integer> m = createMergesortInteger();
        Integer [] a = {};
        Integer [] ergebnis = {};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSortEmpty() {
        Sort<String> m = createMergesortString();
        String [] a = {};
        String [] ergebnis = {};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSortOneElement() {
        Sort<Integer> m = createMergesortInteger();
        Integer [] a = {0};
        Integer [] ergebnis = {0};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSortOneElement() {
        Sort<String> m = createMergesortString();
        String [] a = {"OneString"};
        String [] ergebnis = {"OneString"};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerAndIDSortStable1() {
        Sort<IntegerAndID> m = createMergesortIntegerAndID();
        IntegerAndID number1 = new IntegerAndID(1, 1);
        IntegerAndID number2 = new IntegerAndID(2, 2);
        IntegerAndID number3 = new IntegerAndID(2, 3);
        IntegerAndID number4 = new IntegerAndID(1, 4);
        IntegerAndID number5 = new IntegerAndID(2, 5);
        IntegerAndID [] a = {number1, number2, number3, number4, number5};
        IntegerAndID [] ergebnis = {number1, number4, number2, number3,number5};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
        assertEquals(1, a[0].getId());
        assertEquals(4, a[1].getId());
        assertEquals(2, a[2].getId());
        assertEquals(3, a[3].getId());
        assertEquals(5, a[4].getId());


    }

    /*
        ReverseMergesort ist hier nicht stabil, da 'l' über 'm+1' hinauslaeuft
        und somit in dem Bereich von [m+1 .. rechts] ist, welcher vorher umgedreht wurde.
        Somit wurden a[3] mit a[4] vertauscht

     */
    @Test
    void testIntegerAndIDSortStable2() {
        Sort<IntegerAndID> m = createMergesortIntegerAndID();
        IntegerAndID number1 = new IntegerAndID(1, 1);
        IntegerAndID number2 = new IntegerAndID(1, 2);
        IntegerAndID number3 = new IntegerAndID(1, 3);
        IntegerAndID number4 = new IntegerAndID(1, 4);
        IntegerAndID number5 = new IntegerAndID(1, 5);
        IntegerAndID [] a = {number1, number2, number3, number4, number5};
        IntegerAndID [] ergebnis = {number1, number2, number3, number4,number5};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
        assertEquals(1, a[0].getId());
        assertEquals(2, a[1].getId());
        assertEquals(3, a[2].getId());
        assertEquals(4, a[3].getId());
        assertEquals(5, a[4].getId());
    }

    @Test
    void testIntegerZeitaufwand () {
        Sort<Integer> m = createMergesortInteger();
        Integer[] a = new Integer[5000000]; //5.000.000
        Arrays.fill(a, 0);
        m.sort(a);
    }
}
