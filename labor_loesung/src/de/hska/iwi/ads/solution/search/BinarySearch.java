package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {


    private int binarySearch(E[] a, E key, int left, int right) {
        if (left > right) {
            return left;
        } else {
            int center = (left + right) / 2;
            if (key.compareTo(a[center]) == 0){
                return binarySearch(a, key, left, center - 1);
            } else if (key.compareTo(a[center]) < 0){
                return binarySearch(a, key, left, center - 1);
            } else {
                return binarySearch(a, key, center + 1, right);
            }
        }
    }

    @Override

    public int search(E[] a, E key, int left, int right) {
        int i;
        if (key.compareTo(a[left]) < 0) {
            i = left - 1;
        } else if (key.compareTo(a[right]) > 0) {
            i = right + 1;
        } else {
            i = this.binarySearch(a, key, left, right);
        }
        return i;
    }
}