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
            distance = ++distance / 2 - 1;
        }
    }

    private static int distance(int length) {
        int threshold = length / 2;
        int distance = 1;
        while (distance <= threshold) {
            distance *= 2;
        }
        return distance - 1;
    }
}
