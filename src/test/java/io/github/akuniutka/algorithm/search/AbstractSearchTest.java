package io.github.akuniutka.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.github.akuniutka.algorithm.search.AbstractSearch.*;

public class AbstractSearchTest {
    @Test
    void testAreCorrectWhenBothStringAndSubstringAreNull() {
        assertFalse(areCorrect(null, null));
    }

    @Test
    void testAreCorrectWhenSubstringIsNullAndStringIsEmpty() {
        assertFalse(areCorrect(null, ""));
    }

    @Test
    void testAreCorrectWhenSubstringIsEmptyAndStringIsNull() {
        assertFalse(areCorrect("", null));
    }

    @Test
    void testAreCorrectWhenBothSubstringAndStringAreEmpty() {
        assertFalse(areCorrect("", ""));
    }

    @Test
    void testAreCorrectWhenSubstringIsNullAndStringIsNotEmpty() {
        assertFalse(areCorrect(null, "def"));
    }

    @Test
    void testAreCorrectWhenSubstringIsEmptyAndStringIsNotEmpty() {
        assertFalse(areCorrect("", "def"));
    }

    @Test
    void testAreCorrectWhenSubstringIsNotEmptyAndStringIsNull() {
        assertFalse(areCorrect("abc", null));
    }

    @Test
    void testAreCorrectWhenSubstringIsNotEmptyAndStringIsEmpty() {
        assertFalse(areCorrect("abc", ""));
    }

    @Test
    void testAreCorrectWhenSubstringLongerThanString() {
        assertFalse(areCorrect("abc", "de"));
    }

    @Test
    void testAreCorrectWhenSubstringAndStringAreOfEqualLength() {
        assertTrue(areCorrect("abc", "def"));
    }

    @Test
    void testAreCorrectWhenSubstringIsShorterThanString() {
        assertTrue(areCorrect("ab", "def"));
    }
}
