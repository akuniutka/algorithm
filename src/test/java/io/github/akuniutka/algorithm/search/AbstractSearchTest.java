package io.github.akuniutka.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSearchTest {
    @Test
    void testAreEqualWhenBothStringsAreNull() {
        assertFalse(AbstractSearch.areEqual(null, null));
    }

    @Test
    void testAreEqualWhenOnlyFirstStringIsNull() {
        assertFalse(AbstractSearch.areEqual(null, "pear"));
    }

    @Test
    void testAreEqualWhenOnlySecondStringIsNUll() {
        assertFalse(AbstractSearch.areEqual("apple", null));
    }

    @Test
    void testAreEqualWhenBothStringsAreEmpty() {
        assertTrue(AbstractSearch.areEqual("", ""));
    }

    @Test
    void testAreEqualWhenOnlyFirstStringIsEmpty() {
        assertFalse(AbstractSearch.areEqual("", "pear"));
    }

    @Test
    void testAreEqualWhenOnlySecondStringIsEmpty() {
        assertFalse(AbstractSearch.areEqual("apple", ""));
    }

    @Test
    void testAreEqualWhenStringsAreOfDifferentLength() {
        assertFalse(AbstractSearch.areEqual("apple", "pear"));
        assertFalse(AbstractSearch.areEqual("pear", "apple"));
    }

    @Test
    void testAreEqualWhenStringsAreDifferent() {
        assertFalse(AbstractSearch.areEqual("one", "ten"));
    }

    @Test
    void testAreEqualWhenStringsAreEqual() {
        assertTrue(AbstractSearch.areEqual("noon", "noon"));
    }
}