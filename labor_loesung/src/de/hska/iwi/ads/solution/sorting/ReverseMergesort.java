package de.hska.iwi.ads.solution.sorting;

public class ReverseMergesort extends AbstractParentMergesort {


    protected void verschmelzen (Comparable[] a, int left, int m, int right) {
        int l = left;
        int r = right;

        ReverseArray rev = new ReverseArray();
        rev.reverse(a, m + 1, right);
        for (int i = left; i <= right; i++) {
            if ( a[l].compareTo(a[r]) <= 0) {
                b[i] = a[l];
                l++;
            } else {
                b[i] = a[r];
                r--;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}
