package io.github.akuniutka.algorithm.sort;

public class ThreeWayPartitionQuickSort extends AbstractSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] partitions = partition(array, left, right);
        sort(array, left, partitions[0]);
        sort(array, partitions[1], right);
    }

    private static int[] partition(int[] array, int left, int right) {
        int pivot = array[left + (right - left) / 2];
        int leftPartition = left;
        int rightPartition = right;
        int j = left;
        while (j <= rightPartition) {
            if (array[j] < pivot) {
                swap(array, j++, leftPartition++);
            } else if (array[j] == pivot) {
                ++j;
            } else {
                swap(array, j, rightPartition--);
            }
        }
        return new int[]{--leftPartition, ++rightPartition};
    }
}
