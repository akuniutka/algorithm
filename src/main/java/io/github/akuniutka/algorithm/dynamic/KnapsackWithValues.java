package io.github.akuniutka.algorithm.dynamic;

public class KnapsackWithValues {
    public static int maxValue(int[] weights, int[] values, int capacity) {
        assertValues(weights, values, capacity);
        int[][] state = new int[2][capacity + 1];
        int current = 1;
        for (int i = 0; i < weights.length; ++i) {
            current = 1 - current;
            for (int j = 1; j <= capacity; ++j) {
                state[current][j] = state[1 - current][j];
                if (j >= weights[i]) {
                    int newValue = values[i] + state[1 - current][j - weights[i]];
                    state[current][j] = Math.max(state[current][j], newValue);
                }
            }
        }
        return state[current][capacity];
    }

    private static void assertValues(int[] weights, int[] values, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity below zero");
        }
        if (weights.length != values.length) {
            throw new IllegalArgumentException("number of weights differs from number of values");
        }
        for (int i = 0; i < weights.length; ++i) {
            if (weights[i] < 0) {
                throw new IllegalArgumentException("weight below zero");
            }
            if (values[i] < 0) {
                throw new IllegalArgumentException("value below zero");
            }
        }
    }
}
