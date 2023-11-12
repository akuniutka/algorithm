package io.github.akuniutka.algorithm;

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
        (new BubbleSort()).sort(array);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
