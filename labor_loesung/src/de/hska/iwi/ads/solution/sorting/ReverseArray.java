package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

    @Override
    public void reverse(E[] a, int from, int to) {
        int r = to;
        for (int l = from; l < r; l++, r--) {
            E b = a[l];
            a[l] = a[r];
            a[r] = b;
        }
    }
}
