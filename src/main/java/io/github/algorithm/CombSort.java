package io.github.algorithm;

public class CombSort {
    public void sort(int[] array) {
        int shift = array.length;
        do {
            shift = shift * 1000 / 1247;
            for (int i = 0; i + shift < array.length; ++i) {
                if (array[i] > array[i + shift]) {
                    swap(array, i, i + shift);
                }
            }
        } while (shift > 1);
        for (int iteration = 1; iteration < array.length; ++iteration) {
            for (int j = 0; j < array.length - iteration; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
