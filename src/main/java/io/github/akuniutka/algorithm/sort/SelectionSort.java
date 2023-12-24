package io.github.akuniutka.algorithm.sort;

public class SelectionSort extends AbstractSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minAt = i;
            for (int j = i; j < array.length; ++j) {
                if (array[j] < array[minAt]) {
                    minAt = j;
                }
            }
            swap(array, i, minAt);
        }
    }
}
