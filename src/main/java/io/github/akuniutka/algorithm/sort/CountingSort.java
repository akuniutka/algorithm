package io.github.akuniutka.algorithm.sort;

public class CountingSort {
    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        if (min == max) {
            return;
        }
        int[] buffer = new int[array.length];
        System.arraycopy(array, 0, buffer, 0, array.length);
        int[] count = new int[max - min + 1];
        for (int i : buffer) {
            ++count[i - min];
        }
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = buffer.length - 1; i >= 0; --i) {
            array[--count[buffer[i] - min]] = buffer[i];
        }
    }
}
