package io.github.akuniutka.algorithm.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortTestCases {
    private static final int TIMES = 100;
    private static final int MAX_SIZE = 1_000;
    private static final int MAX_VALUE = 1_000_000;
    private final Consumer<int[]> sort;

    protected SortTestCases(Consumer<int[]> sort) {
        this.sort = sort;
    }

    @Test
    void testSortWhenArrayIsEmpty() {
        TestData.TestArray testArray = TestData.getEmptyArray();
        int[] expected = testArray.getSorted();
        int[] actual = testArray.getUnsorted();
        sort.accept(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSortWhenArrayContainsSingleElement() {
        TestData.TestArray testArray = TestData.getSingleElementArray(MAX_VALUE);
        int[] expected = testArray.getSorted();
        int[] actual = testArray.getUnsorted();
        sort.accept(actual);
        assertArrayEquals(expected, actual);
    }

    @RepeatedTest(TIMES)
    void testSortWithRandomArrays() {
        TestData.TestArray testArray = TestData.getRandomArray(MAX_SIZE, MAX_VALUE);
        int[] expected = testArray.getSorted();
        int[] actual = testArray.getUnsorted();
        sort.accept(actual);
        assertArrayEquals(expected, actual);
    }
}
