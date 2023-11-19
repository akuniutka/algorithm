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
        if (substring.length() > string.length()) {
            return -1;
        } else if (substring.length() == string.length()) {
            return areEqual(substring, string) ? 0 : -1;
        }
        Substring sub1 = new Substring(substring);
        Substring sub2 = new Substring(string, substring.length());
        while (true) {
            if (sub2.equals(sub1)) {
                return sub2.getOffset();
            } else if (!sub2.canSlideToRight()) {
                return -1;
            }
            sub2.slideToRight();
        }
    }

    private static class Substring {
        private static final int BASE = 1_000_000_000 + 7;
        private static final int FACTOR = 13;
        private final String string;
        private final int length;
        private final int maxOffset;
        private final long multiplicand;
        private int offset;
        private long hash;

        Substring(String string) {
            this(string, string.length());
        }

        Substring(String string, int n) {
            if (string.length() < n) {
                throw new IllegalArgumentException("n exceeds string length");
            }
            this.string = string;
            length = n;
            maxOffset = string.length() - n;
            for (int i = 0; i < length; ++i) {
                hash = (hash * FACTOR + string.charAt(i)) % BASE;
            }
            multiplicand = power(FACTOR, length - 1);
        }

        int getOffset() {
            return offset;
        }

        char charAt(int index) {
            return string.charAt(offset + index);
        }

        boolean canSlideToRight() {
            return offset != maxOffset;
        }

        void slideToRight() {
            if (offset == maxOffset) {
                throw new IndexOutOfBoundsException("offset will exceed maximum value");
            }
            hash -= (charAt(0) * multiplicand) % BASE;
            if (hash < 0) {
                hash += BASE;
            }
            hash = (hash * FACTOR + charAt(length)) % BASE;
            ++offset;
        }

        boolean equals(Substring substring) {
            if (length != substring.length || hash != substring.hash) {
                return false;
            }
            for (int i = 0; i < length; ++i) {
                if (charAt(i) != substring.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private long power(int a, int power) {
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
    }
}
