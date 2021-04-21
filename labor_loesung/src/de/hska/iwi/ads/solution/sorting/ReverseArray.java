package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray implements Reverse {

    @Override
    public void reverse(Comparable[] a, int from, int to) {
        int r = to;
        for (int l = from; l < r; l++, r--) {
            Comparable b = a[l];
            a[l] = a[r];
            a[r] = b;
        }
    }
}
