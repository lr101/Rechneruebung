package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K,V> {

    Hashtable(int capacity) {
        super(capacity);
    }

    @SuppressWarnings("unchecked")
    public V get(Object o) {
        K key = (K) o;
        if (key == null) throw new NullPointerException();
        Entry<K,V> returnValue = getEntry(key);

        return returnValue == null ? null : returnValue.getValue();
    }

    private Entry<K, V> getEntry(K key) {
        int hash = key.hashCode() % hashtable.length;
        for(int i = 0; i < hashtable.length; i++) {
            int index = (hash + i) % hashtable.length;
            if (hashtable[index] != null && hashtable[index].getKey().compareTo(key) == 0) {
                return hashtable[index];
            }
        }
        return null;
    }

    private int linearSondieren(K key) {
        for(int i = 0; i < hashtable.length; i++) {
            int index = (key.hashCode() + i) % hashtable.length;
            if (hashtable[index] == null) {
                return index;
            }
        }
        throw new DictionaryFullException(); //kann das nie erreichen, da unter 50% voll
    }

    private int quadratischSondieren(K key) {
        for(int i = 0; i < hashtable.length; i++) {
            int index = (key.hashCode() + i*i) % hashtable.length;
            if (hashtable[index] == null) {
                return index;
            }
        }
        throw new DictionaryFullException();
    }

    public V put (K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        Entry<K,V> entry = getEntry(key);
        V returnValue = null;
        if (entry != null) {
            returnValue = entry.getValue();
            entry.setValue(value);
        } else {
            if (size == hashtable.length){
                throw new DictionaryFullException();
            } else if (size >= hashtable.length/2 ) {
                hashtable[quadratischSondieren(key)] = new SimpleEntry<>(key, value);
            } else {
                hashtable[linearSondieren(key)] = new SimpleEntry<>(key, value);
            }
            size++;
        }
        return returnValue;
    }


}
