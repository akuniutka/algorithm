package io.github.akuniutka.algorithm.dynamic;

import org.junit.jupiter.api.Test;

import static io.github.akuniutka.algorithm.dynamic.SimpleKnapsack.maxWeight;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleKnapsackTest {
    private static final int[] WEIGHTS = new int[]{4, 5, 5, 6, 6, 6, 10, 9, 8, 8};

    @Test
    void testMaxWeightWhenLimitIsNegative() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxWeight(WEIGHTS, -1)
        );
        assertEquals("limit below zero", e.getMessage());
    }

    @Test
    void testMaxWeightWhenWeightIsNegative() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxWeight(new int[]{1, -1}, 1)
        );
        assertEquals("weight below zero", e.getMessage());
    }

    @Test
    void testMaxWeightWhenLimitIsZero() {
        assertEquals(0, maxWeight(WEIGHTS, 0));
    }

    @Test
    void testMaxWeightWhenWeightsEmpty() {
        assertEquals(0, maxWeight(new int[0], 10));
    }

    @Test
    void testMaxWeightWhenAnswerIsEqualLimit() {
        assertEquals(20, maxWeight(WEIGHTS, 20));
    }

    @Test
    void testMaxWeightWhenAnswerIsBelowLimit() {
        assertEquals(6, maxWeight(WEIGHTS, 7));
    }

    @Test
    void testMaxWeightWhenAnswerIsZero() {
        assertEquals(0, maxWeight(WEIGHTS, 3));
    }
}
