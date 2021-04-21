package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

abstract class AbstractParentMergesort extends AbstractMergesort {
    @Override
    public void mergesort(Comparable[] a, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            mergesort(a, left, m);
            mergesort(a, m + 1, right);
            verschmelzen(a, left, m, right);
        }
    }

    protected abstract void verschmelzen(Comparable[] a, int left, int m, int right);
}
