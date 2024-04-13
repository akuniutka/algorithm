package io.github.akuniutka.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManacherPalindromeSearchTest {
    @Test
    void testGetLongestPalindromeWhenStringIsNull() {
        assertNull(ManacherPalindromeSearch.getLongestPalindrome(null));
    }

    @Test
    void testGetLongestPalindromeWhenStringIsEmpty() {
        String string = "";
        String expected = "";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenSingleCharacter() {
        String string = "a";
        String expected = "a";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenTwoDifferentCharacters() {
        String string = "ab";
        String expected = "a";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenTwoIdenticalCharacters() {
        String string = "aa";
        String expected = "aa";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenOddInEnd() {
        String string = "dcbab";
        String expected = "bab";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenEvenInEnd() {
        String string = "dcbaa";
        String expected = "aa";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }


    @Test
    void testGetLongestPalindromeWhenOddInMiddle() {
        String string = "dcbabef";
        String expected = "bab";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenEvenInMiddle() {
        String string = "dcbaaefg";
        String expected = "aa";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenSeveralOdd() {
        String string = "dcbabefgfeh";
        String expected = "efgfe";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenBothOddAndEven() {
        String string = "dcbaaefffh";
        String expected = "fff";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLongestPalindromeWhenSeveral() {
        String string = "dcbaaeffffh";
        String expected = "ffff";

        String actual = ManacherPalindromeSearch.getLongestPalindrome(string);

        assertEquals(expected, actual);
    }

}