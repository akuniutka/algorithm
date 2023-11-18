package io.github.akuniutka.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSearchTest {
    @Test
    void testIndexOfWhenBothSubstringAndStringAreNull() {
        assertEquals(-1, HashSearch.indexOf(null, null));
    }

    @Test
    void testIndexOfWhenSubstringIsNull() {
        assertEquals(-1, HashSearch.indexOf(null, "Hello, World!"));
    }

    @Test
    void testIndexOfWhenStringIsNull() {
        assertEquals(-1, HashSearch.indexOf("sad", null));
    }

    @Test
    void testIndexOfWhenBothSubstringAndStringAreEmpty() {
        assertEquals(-1, HashSearch.indexOf("", ""));
    }

    @Test
    void testIndexOfWhenSubstringIsEmpty() {
        assertEquals(-1, HashSearch.indexOf("", "Hello, World!"));
    }

    @Test
    void testIndexOfWhenStringIsEmpty() {
        assertEquals(-1, HashSearch.indexOf("sad", ""));
    }

    @Test
    void testIndexOfWhenSubstringIsLongerThanString() {
        assertEquals(-1, HashSearch.indexOf("morning", "noon"));
    }

    @Test
    void testIndexOfWhenSubstringAndStringAreOfEqualLengthButNotContent() {
        assertEquals(-1, HashSearch.indexOf("one", "ten"));
    }

    @Test
    void testIndexOfWhenSubstringAndStringAreEqual() {
        assertEquals(0, HashSearch.indexOf("apple", "apple"));
    }

    @Test
    void testIndexOfWhenStringDoesNotContainSubstring() {
        assertEquals(-1, HashSearch.indexOf("sad", "happy and happier"));
    }

    @Test
    void testIndexOfWhenStringContainsSubstring() {
        assertEquals(6, HashSearch.indexOf("sad", "it is sad but true"));
    }

    @Test
    void testIndexOfWhenStringContainsSeveralCopiesOfSubstring() {
        assertEquals(6, HashSearch.indexOf("sad", "it is sad but sad"));
    }
}