package io.github.akuniutka.algorithm.sort;

public class HeapSort extends AbstractSort {
    public static void sort(int[] array) {
        int end = array.length - 1;
        int start = (end - 1) / 2 + 1;
        while (end > 0) {
            if (start == 0) {
                swap(array, start, end--);
            } else {
                --start;
            }
            siftElement(array, start, end);
        }
    }

    private static void siftElement(int[] array, int element, int end) {
        int child = greaterChild(array, element, end);
        while (child != -1 && array[element] < array[child]) {
            swap(array, element, child);
            element = child;
            child = greaterChild(array, element, end);
        }
    }

    private static int greaterChild(int[] array, int parent, int end) {
        int child = parent * 2 + 1;
        if (child > end) {
            return -1;
        } else if (child + 1 <= end && array[child] < array[child + 1]) {
            ++child;
        }
        return child;
    }
}
