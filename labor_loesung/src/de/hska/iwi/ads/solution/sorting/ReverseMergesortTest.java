package de.hska.iwi.ads.solution.sorting;
import de.hska.iwi.ads.sorting.Sort;

class ReverseMergesortTest extends AbstractMergesortTest {

    @Override
    <E extends Comparable<E>> Sort<E> createSort() {
        return new ReverseMergesort<>();
    }
}

