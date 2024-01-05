package io.github.akuniutka.algorithm.sort;

public class MergeSort {
    public static void sort(int[] array) {
        int[] buffer = new int[array.length];
        sort(array, 0, array.length - 1, buffer);
    }

    private static void sort(int[] array, int left, int right, int[] buffer) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        sort(array, left, middle, buffer);
        sort(array, middle + 1, right, buffer);
        System.arraycopy(array, left, buffer, left, right - left + 1);
        int a = left;
        int b = middle + 1;
        for (int i = left; i <= right; ++i) {
            if (b <= right && (a > middle || buffer[b] < buffer[a])) {
                array[i] = buffer[b++];
            } else {
                array[i] = buffer[a++];
            }
        }
    }
}
