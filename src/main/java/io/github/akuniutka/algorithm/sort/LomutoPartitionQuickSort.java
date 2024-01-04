package io.github.akuniutka.algorithm.sort;

public class LomutoPartitionQuickSort extends AbstractSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(array, left, right);
        sort(array, left, partition - 1);
        sort(array, partition + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        for (int j = left; j < right; ++j) {
            if (array[j] < array[right]) {
                swap(array, j, i++);
            }
        }
        swap(array, right, i);
        return i;
    }
}
