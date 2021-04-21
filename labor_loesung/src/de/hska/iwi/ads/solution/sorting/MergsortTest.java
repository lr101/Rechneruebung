package de.hska.iwi.ads.solution.sorting;

public class MergsortTest extends AbstractMergesortTest {

    @Override
    protected AbstractParentMergesort createMergesort() {
        return new Mergesort();
    }
}
