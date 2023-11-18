package io.github.akuniutka.algorithm.sort;

public class BubbleSort {
    public void sort(int[] array) {
        int lastToCheck = array.length - 2;
        int lastSwapped;
        while (lastToCheck >= 0) {
            lastSwapped = 0;
            for (int i = 0; i <= lastToCheck; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    lastSwapped = i + 1;
                }
            }
            lastToCheck = lastSwapped - 2;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
