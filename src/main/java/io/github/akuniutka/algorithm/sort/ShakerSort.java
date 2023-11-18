package io.github.akuniutka.algorithm.sort;

public class ShakerSort {
    public void sort(int[] array) {
        int left = 0, right = array.length - 1;
        int lastSwapped = left;
        while (left < right) {
            for (int i = left; i < right; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    lastSwapped = i + 1;
                }
            }
            right = --lastSwapped;
            if (left >= right) {
                return;
            }
            for (int i = right; i > left; --i) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    lastSwapped = i - 1;
                }
            }
            left = ++lastSwapped;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}