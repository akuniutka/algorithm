package io.github.akuniutka.algorithm.search;

/**
 * Provides a method for substring search by
 * <a href="https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm">
 * the Knuth-Morris-Pratt algorithm</a>.
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class KnuthMorrisPrattSearch extends AbstractSearch {

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
        int[] prefixes = prefixes(substring);
        int k = 0;
        for (int i = 0; i < string.length(); i++) {
            while (k > 0 && string.charAt(i) != substring.charAt(k)) {
                k = prefixes[k - 1];
            }
            if (string.charAt(i) == substring.charAt(k)) {
                if (++k == substring.length()) {
                    return i - k + 1;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the array of values of prefix function for every substring [0, i]
     * in {@code string}. Prefix function of string S is a length of the longest
     * prefix (excluding prefix equal to S) that at the same time is a suffix of S.
     *
     * @param string the string for substring of which prefix function to be
     *               calculated
     * @return the array of values of prefix function for every substring [0, i]
     * in {@code string}
     */
    private static int[] prefixes(String string) {
        int[] prefixes = new int[string.length()];
        for (int i = 1; i < string.length(); i++) {
            int k = prefixes[i - 1];
            while (k > 0 && string.charAt(i) != string.charAt(k)) {
                k = prefixes[k - 1];
            }
            if (string.charAt(i) == string.charAt(k)) {
                k++;
            }
            prefixes[i] = k;
        }
        return prefixes;
    }
}
