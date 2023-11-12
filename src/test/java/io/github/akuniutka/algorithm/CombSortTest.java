package io.github.akuniutka.algorithm;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CombSortTest {
    private static final int TIMES = 100;

    @RepeatedTest(TIMES)
    void sort() {
        int[] array = TestData.getRandomArray(1_000, 1_000_000);
        (new CombSort()).sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }
}