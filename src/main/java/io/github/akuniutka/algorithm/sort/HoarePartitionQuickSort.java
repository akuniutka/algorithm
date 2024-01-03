package io.github.akuniutka.algorithm.sort;

public class HoarePartitionQuickSort extends AbstractSort {
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (right - left < 1) {
            return;
        }
        int splitIndex = partition(array, left, right);
        quickSort(array, left, splitIndex - 1);
        quickSort(array, splitIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = left + (right - left) / 2;
        int i = left;
        int j = right;
        while (true) {
            while (i <= right && array[i] <= array[pivot]) {
                ++i;
            }
            while (j >= left && array[j] >= array[pivot]) {
                --j;
            }
            if (j < i) {
                break;
            }
            swap(array, i, j);
        }
        if (pivot > i) {
            swap(array, i, pivot);
            pivot = i;
        } else if (pivot < j) {
            swap(array, pivot, j);
            pivot = j;
        }
        return pivot;
    }
}
