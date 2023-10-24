package io.github.algorithm;

public class ShakerSort {
    public void sort(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            boolean wasSwap = false;
            for (int i = left; i < right; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    wasSwap = true;
                }
            }
            --right;
            if (!wasSwap) {
                return;
            } else {
                wasSwap = false;
            }
            for (int i = right; i > left; --i) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    wasSwap = true;
                }
            }
            ++left;
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
