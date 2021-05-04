package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Sort;

class MergsortTest extends AbstractMergesortTest {

    @Override
    <E extends Comparable<E>> Sort<E> createSort() {
        return new Mergesort<>();
    }
}
