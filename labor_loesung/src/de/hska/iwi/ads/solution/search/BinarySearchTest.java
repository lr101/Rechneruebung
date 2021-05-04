package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest extends SearchTest {

    /**
     * Creates the BinarySearch object to be used for the Tests in this and the parent class
     * @param <E> Generic type of object
     * @return BinarySearch object
     */
    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        return new BinarySearch<>();
    }

    @Test
    void testIntegerInsideBoundarys () {
        Search<Integer> search = createSearch();
        Integer [] a = {0, 2, 4, 7, 9, 10, 12};

        assertEquals(1, search.search(a, 1));
        assertEquals(2, search.search(a, 3));
        assertEquals(3, search.search(a, 5));
        assertEquals(4, search.search(a, 8));
        assertEquals(6, search.search(a, 11));
    }

    @Test
    void testIntegerOutsideBoundarys () {
        Search<Integer> search = createSearch();
        Integer [] a = {2, 5, 10};

        assertEquals(-1, search.search(a, 0));
        assertEquals(-1, search.search(a, 1));
        assertEquals(3, search.search(a, 11));
        assertEquals(3, search.search(a, 12));
    }

    @Test
    void testMultipleInteger () {
        Search<Integer> search = createSearch();
        Integer [] a = {2, 2, 2, 2, 3, 3, 3, 3, 3, 10, 10, 10, 10, 10, 10};

        assertEquals(0, search.search(a, 2));
        assertEquals(4, search.search(a, 3));
        assertEquals(9, search.search(a, 10));
    }
  
  @Test
    void testIntegerSort1() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {11, 10, 9, 7, 4, 2, 0};
        Integer[] ergebnis = {0, 2, 4, 7, 9, 10, 11};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSort2() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] ergebnis = {1, 2, 3, 4, 5, 6, 7, 8};
        sortObject.sort(a);
        assertArrayEquals(a, ergebnis);

    }

    @Test
    void testIntegerPosition1() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {2, 0, 4, 7, 9, 10, 11};
        sortObject.sort(a);
        assertEquals(2, a[1]);
    }

    @Test
    void testIntegerPosition2() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {2, 2, 2, 2, 2, 2, 1};
        sortObject.sort(a);
        assertEquals(1, a[0]);
    }

    @Test
    void testStability1() {
        StabilityCheck number1 = new StabilityCheck(1, 1);
        StabilityCheck number2 = new StabilityCheck(1, 2);
        StabilityCheck number3 = new StabilityCheck(1, 3);
        StabilityCheck number4 = new StabilityCheck(1, 4);
        StabilityCheck number5 = new StabilityCheck(1, 5);

        AbstractMergesortUniversal<StabilityCheck> testObject = createMergesort();
        StabilityCheck[] a = {number1, number2, number3, number4, number5};
        StabilityCheck[] ergebnis = {number1, number2, number3, number4, number5};
        testObject.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
        assertEquals(1, a[0].getId());
        assertEquals(2, a[1].getId());
        assertEquals(3, a[2].getId());
        assertEquals(4, a[3].getId());
        assertEquals(5, a[4].getId());

    }

    @Test
    void testStability2() {
        StabilityCheck number1 = new StabilityCheck(1, 1);
        StabilityCheck number2 = new StabilityCheck(2, 2);
        StabilityCheck number3 = new StabilityCheck(1, 3);
        StabilityCheck number4 = new StabilityCheck(3, 4);
        StabilityCheck number5 = new StabilityCheck(2, 5);

        AbstractMergesortUniversal<StabilityCheck> testObject = createMergesort();
        StabilityCheck[] a = {number1, number2, number3, number4, number5};
        StabilityCheck[] ergebnis = {number1, number3, number2, number5, number4};
        testObject.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
        assertEquals(1, a[0].getId());
        assertEquals(3, a[1].getId());
        assertEquals(2, a[2].getId());
        assertEquals(4, a[4].getId());
        assertEquals(5, a[3].getId());

}
