package io.github.akuniutka.algorithm.sort;

public class BubbleSort {
    public void sort(int[] array) {
        int lastMoved = array.length;
        do {
            int i = lastMoved - 1;
            lastMoved = 0;
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    lastMoved = j + 1;
                }
            }
        } while (lastMoved > 0);
    }
}
