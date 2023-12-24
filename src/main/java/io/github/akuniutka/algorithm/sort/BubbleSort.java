package io.github.akuniutka.algorithm.sort;

public class BubbleSort extends AbstractSort {
    public static void sort(int[] array) {
        int lastMoved = array.length;
        do {
            int i = lastMoved - 1;
            lastMoved = 0;
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    lastMoved = j + 1;
                }
            }
        } while (lastMoved > 0);
    }
}
