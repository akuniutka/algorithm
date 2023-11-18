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
        }
        int n = substring.length();
        if (n > string.length()) {
            return -1;
        } else if (n == string.length()) {
            return areEqual(substring, string) ? 0 : -1;
        }
        int i = n;
        Hash hash1 = new Hash(substring);
        Hash hash2 = new Hash(string.substring(0, i));
        while (true) {
            if (hash1.equals(hash2)) {
                if (areEqual(substring, string.substring(i - n, i))) {
                    return i - n;
                }
            }
            if (i == string.length()) {
                return -1;
            }
            hash2.update(string.charAt(i++));
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

    private static class Hash {
        private final char[] buffer;
        private final long multiplicand;
        private int current;
        private long value;

        Hash(String s) {
            this.buffer = s.toCharArray();
            for (int i = 0; i < buffer.length; ++i) {
                value = (value * FACTOR + s.charAt(i)) % BASE;
            }
            this.multiplicand = power(FACTOR, buffer.length - 1);
        }

        void update(char ch) {
            value -= (buffer[current] * multiplicand) % BASE;
            if (value < 0) {
                value += BASE;
            }
            value = (value * FACTOR + ch) % BASE;
            buffer[current++] = ch;
            if (current == buffer.length) {
                current = 0;
            }
        }

        boolean equals(Hash hash) {
            return this.value == hash.value;
        }
    }
}
