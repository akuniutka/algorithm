package io.github.akuniutka.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AbstractSortTest {
    @Test
    void testSwap() {
        int[] expected = new int[]{1, 4, 3, 2, 5};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 1, 3);
        assertArrayEquals(expected, actual);
    }
}