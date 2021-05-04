package de.hska.iwi.ads.solution.sorting;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;

import de.hska.iwi.ads.interfaces.Vector;
import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

public abstract class AbstractMergesortTest {

    public abstract <E extends Comparable<E>> Sort<E> createMergesort();
  
 
    @Test
    void testIntegerSort1() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = {11, 10, 9, 7, 4, 2, 0};
        Integer[] ergebnis = {0, 2, 4, 7, 9, 10, 11};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSort2() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] ergebnis = {1, 2, 3, 4, 5, 6, 7, 8};
        sortObject.sort(a);
        assertArrayEquals(a, ergebnis);

    }

    @Test
    void testIntegerPosition1() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = {2, 0, 4, 7, 9, 10, 11};
        sortObject.sort(a);
        assertEquals(2, a[1]);
    }

    @Test
    void testIntegerPosition2() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = {2, 2, 2, 2, 2, 2, 1};
        sortObject.sort(a);
        assertEquals(1, a[0]);
    }

    

  
    @Test
    void testStringSort1() {
        Sort<String> m = createSort();
        String [] a = {"c", "e", "g", "a"};
        String [] ergebnis = {"a", "c", "e", "g"};
        m.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSort2() {
        Sort<String> sortObject = createMergesort();
        String[] a = {"black", "over", "a", "utah", "to", "car", "public", "roads", "moving"};
        String[] ergebnis = {"a", "black", "car", "moving", "over", "public", "roads", "to", "utah"};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSortEmpty() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = {};
        Integer[] ergebnis = {};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSortEmpty() {
        Sort<String> sortObject = createMergesort();
        String[] a = {};
        String[] ergebnis = {};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSortOneElement() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = {0};
        Integer[] ergebnis = {0};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSortOneElement() {

        Sort<String> sortObject = createMergesort();
        String[] a = {"OneString"};
        String[] ergebnis = {"OneString"};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerZeitaufwand() {
        Sort<Integer> sortObject = createMergesort();
        Integer[] a = new Integer[100000];
        java.util.Arrays.fill(a, 0);
        sortObject.sort(a);

    }
  
    void testIntegerAndIDSortStable1() {
        Sort<IntegerAndID> m = createSort();
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
        Sort<IntegerAndID> m = createSort();
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

}
