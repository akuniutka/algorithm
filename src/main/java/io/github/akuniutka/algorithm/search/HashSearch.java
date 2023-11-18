package io.github.akuniutka.algorithm.search;

/**
 * Provides a faster-than-naive method for searching a substring within
 * a given string by comparing hashes of character sequences instead of
 * character-by-character comparison.
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class HashSearch extends AbstractSearch {
    private static final int BASE = 1_000_000_000 + 7;
    private static final int FACTOR = 13;

    /**
     * Returns the position of the first occurrence of {@code substring}
     * within {@code string}.
     *
     * @param substring the string being searched for
     * @param string    the string tested whether it contains {@code substring}
     * @return index in {@code string} where {@code substring} starts or
     * {@code -1} if there is no such {@code substring} within {@code string} or
     * {@code substring} is {@code null}
     */
    public static int indexOf(String substring, String string) {
        if (substring == null || string == null || substring.isEmpty()) {
            return -1;
        } else if (substring.length() > string.length()) {
            return -1;
        } else if (string.length() == substring.length()) {
            return areEqual(string, substring) ? 0 : -1;
        }
        int l = 1, r = substring.length();
        long f = power(FACTOR, r - 1);
        int hashA = calculateHash(substring);
        int hashB = calculateHash(string.substring(l, r + 1));
        while (true) {
            if (hashA == hashB) {
                if (areEqual(substring, string.substring(l, r + 1))) {
                    return l;
                }
            }
            if (++r == string.length()) {
                return -1;
            }
            hashB = recalculateHash(hashB, string.charAt(l++), string.charAt(r), f);
        }
    }

    private static long power(int a, int power) {
        if (power == 0) {
            return 1;
        } else if (power == 1) {
            return a;
        }
        long z = power(a, power / 2);
        z = (z * z) % BASE;
        if (power % 2 == 1) {
            z = (z * a) % BASE;
        }
        return z;
    }

    private static int calculateHash(String s) {
        long hash = 0L;
        for (int i = 0; i < s.length(); ++i) {
            hash = (hash * FACTOR + s.charAt(i)) % BASE;
        }
        return (int) hash;
    }

    private static int recalculateHash(int previousValue, char subtract, char add, long factor) {
        return (int) ((previousValue - subtract * factor) * FACTOR + add) % BASE;
    }
}
