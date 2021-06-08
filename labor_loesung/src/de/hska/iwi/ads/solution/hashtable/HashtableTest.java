package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;

import java.util.Map;

public class HashtableTest extends MapTest{

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<>(100);
    }
}


