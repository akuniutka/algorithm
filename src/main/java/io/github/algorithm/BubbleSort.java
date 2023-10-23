package io.github.algorithm;

public class BubbleSort {
    public void sort(int[] array) {
        for (int iteration = 1; iteration < array.length; ++iteration) {
            for (int i = 0; i < array.length - iteration; ++i) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}
