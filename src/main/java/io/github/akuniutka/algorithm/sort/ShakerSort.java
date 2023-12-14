package io.github.akuniutka.algorithm.sort;

public class ShakerSort {
    public void sort(int[] array) {
        int start = array.length - 1;
        int lastMoved = -1;
        int step = -1;
        do {
            step = -step;
            int finish = start;
            start = lastMoved + step;
            lastMoved = start;
            for (int j = start; Integer.signum(finish - j) == step; j += step) {
                if (Integer.signum(array[j] - array[j + step]) == step) {
                    int temp = array[j + step];
                    array[j + step] = array[j];
                    array[j] = temp;
                    lastMoved = j + step;
                }
            }
        } while (lastMoved != start);
    }
}
