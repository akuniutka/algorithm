package io.github.akuniutka.algorithm.dynamic;

import org.junit.jupiter.api.Test;

import static io.github.akuniutka.algorithm.dynamic.KnapsackWithValues.maxValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KnapsackWithValuesTest {
    private static final int[] WEIGHTS = new int[]{3, 4, 5, 8, 9};
    private static final int[] VALUES = new int[]{1, 6, 4, 7, 6};

    @Test
    void testMaxValueWhenCapacityIsNegative() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxValue(WEIGHTS, VALUES, -1)
        );
        assertEquals("capacity below zero", e.getMessage());
    }

    @Test
    void testMaxValueWhenNumberOfWeightsIsGreaterThanNumberOfValues() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxValue(WEIGHTS, new int[]{0, 1, 2}, 10)
        );
        assertEquals("number of weights differs from number of values", e.getMessage());
    }

    @Test
    void testMaxValueWhenNumberOfValuesIsGreaterThanNumberOfWeights() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxValue(new int[]{1, 2, 3}, VALUES, 10)
        );
        assertEquals("number of weights differs from number of values", e.getMessage());
    }

    @Test
    void testMaxValueWhenWeightIsNegative() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxValue(new int[]{1, -2, 3}, new int[]{3, 4, 5}, 10)
        );
        assertEquals("weight below zero", e.getMessage());
    }

    @Test
    void testMaxValueWhenValueIsNegative() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> maxValue(new int[]{1, 2, 3}, new int[]{3, -4, 5}, 10)
        );
        assertEquals("value below zero", e.getMessage());
    }

    @Test
    void testMaxValueWhenInputDataIsCorrect() {
        assertEquals(10, maxValue(WEIGHTS, VALUES, 11));
    }
}
