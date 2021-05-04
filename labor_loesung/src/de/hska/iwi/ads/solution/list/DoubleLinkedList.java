package de.hska.iwi.ads.solution.list;
import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;


public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {


    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * This implementation iterates over entrySet() searching for an entry with the specified key.
     * If such an entry is found, the entry's value is returned.
     * If the iteration terminates without finding such an entry, null is returned.
     * Note that this implementation requires linear time in the size of the map;
     * many implementations will override this method.
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    @SuppressWarnings("unchecked")
    public V get (Object key) {
        if (key == null) throw new NullPointerException();
        Entry<K, V> entry = getEntry((K) key);
        return entry == null ? null : entry.getValue();
    }

    /**
     *Associates the specified value with the specified key in this map (optional operation).
     * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
     * (A map m is said to contain a mapping for a key k if and only if m.containsKey(k) would return true.)
     *
     * @param key - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     * (A null return can also indicate that the map previously associated null with key,
     * if the implementation supports null values.)
     */
    public V put(K key, V value) {
        if (value == null || key == null) throw new NullPointerException();
        Entry<K, V> entry = getEntry(key);
        V returnValue;
        if (entry != null) {
            returnValue = entry.getValue();
            entry.setValue(value);
        } else {
            Entry<K, V> newEntry = new java.util.AbstractMap.SimpleEntry<>(key, value);
            ListElement newHead = new ListElement(newEntry, null, head);
            if (size != 0) head.previous = newHead;
            head = newHead;
            returnValue = null;
            size++;
        }
        return returnValue;
    }


    /**
     * Iterates in linear time through the List starting at the head. Returns the Entry associated with the key
     * or null if no Entry can be found
     *
     * @param key - key with which the specified Entry is to be associated
     * @return Entry containing the Key and Value Map
     */
    private Entry<K, V> getEntry (K key) {
        if (size > 0) {
            for (ListElement currentListElement = head; currentListElement != null; currentListElement = currentListElement.next) {
                if (currentListElement.entry.getKey().compareTo(key) == 0) {
                    return currentListElement.entry;
                }
            }
        }
        return null;
    }



}
