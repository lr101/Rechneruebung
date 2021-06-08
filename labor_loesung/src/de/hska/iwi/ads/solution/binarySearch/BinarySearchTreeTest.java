package de.hska.iwi.ads.solution.binarySearch;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.hashtable.Hashtable;

import java.util.Map;

public class BinarySearchTreeTest extends MapTest {
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new BinarySearchTree<>();
    }
}