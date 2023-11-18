package io.github.akuniutka.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceSearchTest {
    @Test
    void testIndexOfWhenBothSubstringAndStringAreNull() {
        assertEquals(-1, BruteForceSearch.indexOf(null, null));
    }

    @Test
    void testIndexOfWhenSubstringIsNull() {
        assertEquals(-1, BruteForceSearch.indexOf(null, "Hello, World!"));
    }

    @Test
    void testIndexOfWhenStringIsNull() {
        assertEquals(-1, BruteForceSearch.indexOf("sad", null));
    }

    @Test
    void testIndexOfWhenBothSubstringAndStringAreEmpty() {
        assertEquals(-1, BruteForceSearch.indexOf("", ""));
    }

    @Test
    void testIndexOfWhenSubstringIsEmpty() {
        assertEquals(-1, BruteForceSearch.indexOf("", "Hello, World!"));
    }

    @Test
    void testIndexOfWhenStringIsEmpty() {
        assertEquals(-1, BruteForceSearch.indexOf("sad", ""));
    }

    @Test
    void testIndexOfWhenSubstringIsLongerThanString() {
        assertEquals(-1, BruteForceSearch.indexOf("morning", "noon"));
    }

    @Test
    void testIndexOfWhenSubstringAndStringAreOfEqualLengthButNotContent() {
        assertEquals(-1, BruteForceSearch.indexOf("one", "ten"));
    }

    @Test
    void testIndexOfWhenSubstringAndStringAreEqual() {
        assertEquals(0, BruteForceSearch.indexOf("apple", "apple"));
    }

    @Test
    void testIndexOfWhenStringDoesNotContainSubstring() {
        assertEquals(-1, BruteForceSearch.indexOf("sad", "happy and happier"));
    }

    @Test
    void testIndexOfWhenStringStartsWithSubstring() {
        assertEquals(0, BruteForceSearch.indexOf("sad", "sad very sad"));
    }

    @Test
    void testIndexOfWhenStringEndsWithSubstring() {
        assertEquals(10, BruteForceSearch.indexOf("sad", "happy but sad"));
    }

    @Test
    void testIndexOfWhenSubstringIsVeryLong() {
        assertEquals(9, BruteForceSearch.indexOf("teleports", "teleport teleports"));
    }

    @Test
    void testIndexOfWhenStringContainsSubstring() {
        assertEquals(6, BruteForceSearch.indexOf("sad", "it is sad but true"));
    }

    @Test
    void testIndexOfWhenStringContainsSeveralCopiesOfSubstring() {
        assertEquals(6, BruteForceSearch.indexOf("sad", "it is sad but sad"));
    }
}