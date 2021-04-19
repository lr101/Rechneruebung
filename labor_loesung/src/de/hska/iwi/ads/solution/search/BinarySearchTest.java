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


}
