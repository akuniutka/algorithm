package io.github.akuniutka.algorithm.sort;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minAt = i;
            for (int j = i; j < array.length; ++j) {
                if (array[j] < array[minAt]) {
                    minAt = j;
                }
            }
            int temp = array[minAt];
            array[minAt] = array[i];
            array[i] = temp;
        }
    }
}
