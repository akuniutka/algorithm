package io.github.akuniutka.algorithm.dynamic;

public class SimpleKnapsack {
    public static int maxWeight(int[] weights, int limit) {
        assertValues(weights, limit);
        boolean[][] state = initialState(limit);
        int current = 1;
        for (int weight : weights) {
            current = 1 - current;
            for (int j = 1; j <= limit; ++j) {
                state[current][j] = state[1 - current][j];
                if (j >= weight) {
                    state[current][j] = state[current][j] || state[1 - current][j - weight];
                }
            }
        }
        return farthestTrue(state[current]);
    }

    private static void assertValues(int[] weights, int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit below zero");
        }
        for (int weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException("weight below zero");
            }
        }
    }

    private static boolean[][] initialState(int limit) {
        boolean[][] state = new boolean[2][limit + 1];
        state[0][0] = true;
        state[1][0] = true;
        return state;
    }

    private static int farthestTrue(boolean[] array) {
        int j = array.length - 1;
        while (!array[j]) {
            --j;
        }
        return j;
    }
}
