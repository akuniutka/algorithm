package io.github.akuniutka.algorithm.dynamic;

public class SimpleKnapsack {
    public static int maxWeight(int[] weights, int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit below zero");
        }
        for (int weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException("weight below zero");
            }
        }
        boolean[][] state = new boolean[2][limit + 1];
        int current = 1;
        int previous = 0;
        state[0][0] = true;
        state[1][0] = true;
        for (int weight : weights) {
            current = previous;
            previous = 1 - current;
            for (int j = 1; j <= limit; ++j) {
                int k = j - weight;
                if (k < 0) {
                    state[current][j] = state[previous][j];
                } else {
                    state[current][j] = state[previous][j] || state[previous][k];
                }
            }
        }
        int j = limit;
        while (!state[current][j]) {
            --j;
        }
        return j;
    }
}
