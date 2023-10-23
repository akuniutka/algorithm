package io.github.algorithm;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTest {
    private static final int TIMES = 100;

    @RepeatedTest(TIMES)
    void sort() {
        Random random = new Random();
        int size = random.nextInt(1_000);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1_000_000);
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        for (int i = 0; i < size - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }
}