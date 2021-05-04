package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

abstract class AbstractParentMergesort<E extends Comparable<E>> extends AbstractMergesort<E> {
    @Override
    public void mergesort(E[] a, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            mergesort(a, left, m);
            mergesort(a, m + 1, right);
            verschmelzen(a, left, m, right);
        }
    }

    protected abstract void verschmelzen(E[] a, int left, int m, int right);
}
