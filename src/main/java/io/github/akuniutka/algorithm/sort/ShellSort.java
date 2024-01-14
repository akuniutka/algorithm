package io.github.akuniutka.algorithm.sort;

public class ShellSort {
    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int distance = distance(array.length);
        while (distance > 0) {
            for (int i = distance; i < array.length; ++i) {
                int temp = array[i];
                int j = i;
                while (j >= distance && array[j - distance] > temp) {
                    array[j] = array[j - distance];
                    j -= distance;
                }
                array[j] = temp;
            }
            distance = (++distance >> 1) - 1;
        }
    }

    private static int distance(int length) {
        int threshold = length;
        if ((threshold & 1) == 0) {
            threshold >>= 1;
        } else {
            threshold = (threshold >> 1) + 1;
        }
        int distance = 1;
        while (distance < threshold) {
            distance <<= 1;
        }
        return distance - 1;
    }
}
