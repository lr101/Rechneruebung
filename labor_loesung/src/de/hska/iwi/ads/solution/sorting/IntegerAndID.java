package de.hska.iwi.ads.solution.sorting;

public class IntegerAndID implements Comparable<IntegerAndID> {

    private int value;
    private int id;


    public IntegerAndID (int value, int id) {
        this.value = value;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(IntegerAndID e) {
        if (value == e.getValue()) {
            return 0;
        } else if (value < e.getValue()) {
            return -1;
        } else {
            return 1;
        }
    }
}
