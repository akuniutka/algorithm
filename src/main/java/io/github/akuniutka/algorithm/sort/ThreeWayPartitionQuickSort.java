package io.github.akuniutka.algorithm.sort;

public class ThreeWayPartitionQuickSort extends AbstractSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        long parts = partition(array, left, right);
        int i = (int) (parts >> 32);
        int j = (int) parts;
        sort(array, left, i);
        sort(array, j, right);
    }

    private static long partition(int[] array, int left, int right) {
        int pivot = array[left + (right - left) / 2];
        int less = left, greater = right;
        int i = left;
        while (i <= greater) {
            if (array[i] < pivot) {
                swap(array, i++, less++);
            } else if (array[i] == pivot) {
                ++i;
            } else {
                swap(array, i, greater--);
            }
        }
        --less;
        ++greater;
        return (long) less << 32 | greater;
    }
}
