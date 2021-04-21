package de.hska.iwi.ads.solution.sorting;

public class ReverseMergesortTest extends AbstractMergesortTest {
    @Override
    protected AbstractParentMergesort createMergesort() {
        return new ReverseMergesort();
    }
}
