package io.github.akuniutka.algorithm.search;

/**
 * Provides a naive method for substring search by character-by-character
 * comparison.
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class SequentialSearch extends AbstractSearch {

    /**
     * Returns the index within {@code string} of the first occurrence of
     * {@code substring}.
     *
     * @param substring the string being searched for
     * @param string    the string tested whether it contains {@code substring}
     * @return the index of the first occurrence of {@code substring}, or
     * {@code -1} if there is no such occurrence.
     */
    public static int indexOf(String substring, String string) {
        if (!areCorrect(substring, string)) {
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
