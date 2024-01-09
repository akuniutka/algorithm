package io.github.akuniutka.algorithm.sort;

public class ComparisonCountingSort {
    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int[] buffer = new int[array.length];
        int[] positions = new int[array.length];
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    ++positions[i];
                } else {
                    ++positions[j];
                }
            }
            buffer[positions[i]] = array[i];
        }
        buffer[positions[array.length - 1]] = array[array.length - 1];
        System.arraycopy(buffer, 0, array, 0, buffer.length);
    }
}
