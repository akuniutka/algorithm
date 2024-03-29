package io.github.akuniutka.algorithm.sort;

public class CombSort extends AbstractSort {
    public static void sort(int[] array) {
        int finish = array.length;
        int step = array.length;
        int lastMoved = array.length;
        do {
            if (step > 7) {
                step = (int) Math.rint(step / 1.247);
            } else if (step > 1) {
                --step;
            } else {
                finish = lastMoved;
                lastMoved = 0;
            }
            for (int j = 0; j + step < finish; ++j) {
                if (array[j] > array[j + step]) {
                    swap(array, j, j + step);
                    if (step == 1) {
                        lastMoved = j + step;
                    }
                }
            }
        } while (step > 1 || lastMoved != 0);
    }
}
