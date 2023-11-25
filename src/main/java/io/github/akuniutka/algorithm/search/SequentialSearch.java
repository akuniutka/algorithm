package io.github.akuniutka.algorithm.search;

/**
 * Provides a naive method for searching a substring within a given string
 * by using character-by-character comparison.
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class SequentialSearch {
    /**
     * Returns the position of the first occurrence of {@code substring}
     * within {@code string}.
     *
     * @param substring  the string being searched for
     * @param string     the string tested whether it contains {@code substring}
     * @return index in {@code string} where {@code substring} starts or
     * {@code -1} if there is no such {@code substring} within {@code string} or
     * {@code substring} is {@code null}
     */
    public static int indexOf(String substring, String string) {
        if (substring == null || string == null || substring.isEmpty()) {
            return -1;
        }
        for (int i = 0; i <= string.length() - substring.length(); ++i) {
            int j = 0;
            while (j < substring.length() && substring.charAt(j) == string.charAt(i + j)) {
                ++j;
            }
            if (j == substring.length()) {
                return i;
            }
        }
        return -1;
    }
}
