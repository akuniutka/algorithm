package io.github.akuniutka.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class TestData {
    private TestData() {
    }

    public static TestArray getEmptyArray() {
        return new TestArray(new int[0], new int[0]);
    }

    public static TestArray getSingleElementArray(int maxValue) {
        Random random = new Random();
        int value = random.nextInt(maxValue);
        return new TestArray(new int[]{value}, new int[]{value});
    }

    public static TestArray getRandomArray(int max_size, int max_value) {
        Random random = new Random();
        int size = random.nextInt(max_size);
        int[] unsorted = new int[size];
        for (int i = 0; i < size; i++) {
            unsorted[i] = random.nextInt(max_value);
        }
        int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted);
        return new TestArray(sorted, unsorted);
    }

    public static class TestArray {
        private final int[] sorted;
        private final int[] unsorted;

        private TestArray(int[] sorted, int[] unsorted) {
            this.sorted = sorted;
            this.unsorted = unsorted;
        }

        public int[] getUnsorted() {
            return Arrays.copyOf(unsorted, unsorted.length);
        }

        public int[] getSorted() {
            return Arrays.copyOf(sorted, sorted.length);
        }
    }
}
