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
            int element = start;
            while (true) {
                int child = element * 2 + 1;
                if (child > end) {
                    break;
                }
                if (child + 1 <= end && array[child] < array[child + 1]) {
                    child = child + 1;
                }
                if (array[element] < array[child]) {
                    swap(array, element, child);
                    element = child;
                } else {
                    break;
                }
            }
        }
    }
}
