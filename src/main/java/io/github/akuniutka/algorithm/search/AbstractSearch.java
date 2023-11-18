package io.github.akuniutka.algorithm.search;

/**
 * The abstract base class which provides common utility methods for its
 * subclasses.
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class AbstractSearch {

    /**
     * Returns {@code true} when both strings are not {@code null} and are equal.
     *
     * @param s1 the first of two strings to compare
     * @param s2 the second string in comparison
     * @return {@code true} if (1) each character in s1 equals to the character
     * in s2 at the same position or (2) both s1 and s2 are empty. If
     * either s1 or s2 are {@code null}, returns {@code false}
     */
    protected static boolean areEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
