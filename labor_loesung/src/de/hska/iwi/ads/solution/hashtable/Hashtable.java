package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;
import de.hska.iwi.ads.dictionary.AbstractHashMap;

import java.util.AbstractMap;
import java.util.Map;

public class Hashtable <K extends Comparable<K>, V> extends AbstractHashMap <K,V> {

    @Override
    public V get(Object key) {
            if (key == null) throw new NullPointerException();
            Entry<K, V> entry = getEntry((K) key);
            return entry == null ? null : entry.getValue();
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }
}

//    public V put(K key, V value) {
//        if (key == null || value == null) {throw new NullPointerException();}
//        Entry<K, V> newEntry = getEntry(key);
//        V valueReturn;
//        if (newEntry != null) {
//            valueReturn = newEntry.getValue();
//            newEntry.setValue(value);
//        } else {
//            Entry<K, V> startEntry = new SimpleEntry (key, value);
//            AbstractDoubleLinkedList.ListElement headerElement = new AbstractDoubleLinkedList.ListElement(startEntry, null, head);
//            if (size != 0) {
//                head.previous = headerElement;}
//            head = headerElement;
//            valueReturn = null;
//            size++;
//        }
//        return valueReturn;
//    }

    private Entry<K, V> getEntry(K key) {
        Entry<K,V> [] currentMap = hashtable;
        currentMap.next();
            for (int i = 0; i < currentMap.length; currentMap[i].)) {
                currentMap[i].getKey().compareTo(key) != 0 &&

                return currentMap[i];
        }
        return null;
    }
}
