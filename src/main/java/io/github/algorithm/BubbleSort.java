package io.github.algorithm;

public class BubbleSort {
    public void sort(int[] array) {
        for (int iteration = 1; iteration < array.length; ++iteration) {
            boolean wasSwap = false;
            for (int i = 0; i < array.length - iteration; ++i) {
                if (array[i + 1] < array[i]) {
                    swap(array, i, i + 1);
                    wasSwap = true;
                }
            }
            if (!wasSwap) {
                return;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
