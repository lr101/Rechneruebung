package de.hska.iwi.ads.solution.sorting;


public class ReverseMergesortTest extends AbstractMergesortTest {
    @Override
    protected ReverseMergesort<Integer> createMergesortInteger() {
        return new ReverseMergesort<>();
    }

    @Override
    protected ReverseMergesort<String> createMergesortString() {
        return new ReverseMergesort<>();
    }

    @Override
    protected ReverseMergesort<IntegerAndID> createMergesortIntegerAndID() {
        return new ReverseMergesort<>();
    }
}
