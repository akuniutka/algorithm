package io.github.akuniutka.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractSortTest {
    @Test
    @SuppressWarnings("ConstantConditions")
    void testSwapWhenArrayIsNull() {
        assertThrows(NullPointerException.class,
                () -> AbstractSort.swap(null, 0, 0)
        );
    }

    @Test
    void testSwapWhenFirstIndexIsNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> AbstractSort.swap(new int[]{1, 2}, -1, 1)
        );
    }

    @Test
    void testSwapWhenSecondIndexIsNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> AbstractSort.swap(new int[]{1, 2}, 1, -1)
        );
    }

    @Test
    void testSwapWhenFirstIndexIsGraterThanArrayLength() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> AbstractSort.swap(new int[]{1, 2}, 5, 1)
        );
    }

    @Test
    void testSwapWhenSecondIndexIsGreaterThanArrayLength() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> AbstractSort.swap(new int[]{1, 2}, 1, 5)
        );
    }

    @Test
    void testSwapWhenFirstIndexIzZero() {
        int[] expected = new int[]{4, 2, 3, 1, 5};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 0, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwapWhenSecondIndexIsZero() {
        int[] expected = new int[]{4, 2, 3, 1, 5};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 3, 0);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwapWhenFirstIndexEqualsLastOneInArray() {
        int[] expected = new int[]{1, 2, 3, 5, 4};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 4, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwapWhenLastIndexEqualsLastOneInArray() {
        int[] expected = new int[]{1, 2, 3, 5, 4};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 3, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwapWhenFirstIndexIsLessThanSecondOne() {
        int[] expected = new int[]{1, 4, 3, 2, 5};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 1, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwapWhenFirstIndexIsGreaterThanSecondOne() {
        int[] expected = new int[]{1, 4, 3, 2, 5};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 3, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwapWhenFirstIndexEqualsSecondOne() {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = new int[]{1, 2, 3, 4, 5};
        AbstractSort.swap(actual, 2, 2);
        assertArrayEquals(expected, actual);
    }
}