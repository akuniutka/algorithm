package io.github.akuniutka.algorithm.search;

/**
 * Provides a faster-than-naive method for substring search by
 * <a href="https://en.wikipedia.org/wiki/Rabin%2DKarp_algorithm">
 * the Rabin-Karp algorithm</a>.
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class RabinKarpSearch extends AbstractSearch {

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
//        if (substring == null || string == null || substring.isEmpty()) {
//            return -1;
//        } else if (substring.length() > string.length()) {
//            return -1;
//        }
        if (!areCorrect(substring, string)) {
            return -1;
        }
        Substring sub1 = new Substring(substring);
        Substring sub2 = new Substring(string, substring.length());
        while (true) {
            if (sub1.getHash() == sub2.getHash() && sub2.equals(sub1)) {
                return sub2.getOffset();
            } else if (!sub2.canSlideToRight()) {
                return -1;
            }
            sub2.slideToRight();
        }
    }

    private static class Substring {
        private static final int BASE = Integer.MAX_VALUE;
        private static final int FACTOR = Byte.MAX_VALUE;
        private final String string;
        private final int length;
        private final int maxOffset;
        private long multiplicand;
        private int offset;
        private long hash;

        Substring(String string) {
            this(string, string == null ? -1 : string.length());
        }

        Substring(String string, int n) {
            if (string == null) {
                throw new IllegalArgumentException("string is null");
            } else if (string.length() < n) {
                throw new IllegalArgumentException("n exceeds string length");
            }
            this.string = string;
            length = n;
            maxOffset = string.length() - length;
            if (maxOffset > 0) {
                multiplicand = power(FACTOR, length - 1);
            }
            for (int i = 0; i < length; ++i) {
                hash = (hash * FACTOR + string.charAt(i)) % BASE;
            }
        }

        int getOffset() {
            return offset;
        }

        char charAt(int index) {
            return string.charAt(offset + index);
        }

        long getHash() {
            return hash;
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
            if (substring == null || length != substring.length) {
                return false;
            }
            int i = 0;
            while (i < length && charAt(i) == substring.charAt(i)) {
                ++i;
            }
            return i == length;
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
