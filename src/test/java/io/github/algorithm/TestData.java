package io.github.algorithm;

import java.util.Random;

public class TestData {
    private TestData() {
    }

    public static int[] getRandomArray(int max_size, int max_value) {
        Random random = new Random();
        int size = random.nextInt(max_size);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max_value);
        }
        return array;
    }
}
