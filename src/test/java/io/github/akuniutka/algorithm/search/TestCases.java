package io.github.akuniutka.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class TestCases {
    private final BiFunction<String, String, Integer> indexOf;

    protected TestCases(BiFunction<String, String, Integer> indexOf) {
        this.indexOf = indexOf;
    }

    @Test
    void testIndexOfWhenBothSubstringAndStringAreNull() {
        assertEquals(-1, indexOf.apply(null, null));
    }

    @Test
    void testIndexOfWhenSubstringIsNull() {
        String haystack = "Hello, World!";
        assertEquals(-1, indexOf.apply(null, haystack));
    }

    @Test
    void testIndexOfWhenStringIsNull() {
        String needle = "sad";
        assertEquals(-1, indexOf.apply(needle, null));
    }

    @Test
    void testIndexOfWhenBothSubstringAndStringAreEmpty() {
        String haystack = "";
        String needle = "";
        assertEquals(-1, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenSubstringIsEmpty() {
        String haystack = "Hello, World!";
        String needle = "";
        assertEquals(-1, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenStringIsEmpty() {
        String haystack = "";
        String needle = "sad";
        assertEquals(-1, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenSubstringIsLongerThanString() {
        String haystack = "noon";
        String needle = "morning";
        assertEquals(-1, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenSubstringAndStringAreEqualByLengthButNotByContent() {
        String haystack = "ten";
        String needle = "one";
        assertEquals(-1, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenSubstringAndStringAreEqual() {
        String haystack = "apple";
        String needle = "apple";
        assertEquals(0, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenStringDoesNotContainSubstring() {
        String haystack = "happy and happier";
        String needle = "sad";
        assertEquals(-1, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenStringStartsWithSubstring() {
        String haystack = "sad very sad";
        String needle = "sad";
        assertEquals(0, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenStringEndsWithSubstring() {
        String haystack = "happy but sad";
        String needle = "sad";
        assertEquals(10, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenSubstringIsLongEnoughToOverflowHash() {
        String haystack = "teleport teleports";
        String needle = "teleports";
        assertEquals(9, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenStringContainsSubstringInTheMiddle() {
        String haystack = "it is sad but true";
        String needle = "sad";
        assertEquals(6, indexOf.apply(needle, haystack));
    }

    @Test
    void testIndexOfWhenStringContainsSeveralCopiesOfSubstring() {
        String haystack = "it is sad but sad";
        String needle = "sad";
        assertEquals(6, indexOf.apply(needle, haystack));
    }
}
