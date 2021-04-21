package de.hska.iwi.ads.solution.sorting;

public class MergsortTest extends AbstractMergesortTest {



    @Override
    protected Mergesort<Integer> createMergesortInteger() {
        return new Mergesort<>();
    }

    @Override
    protected Mergesort<String> createMergesortString() {
        return new Mergesort<>();
    }

    @Override
    protected Mergesort<IntegerAndID> createMergesortIntegerAndID() {
        return new Mergesort<>();
    }
}
