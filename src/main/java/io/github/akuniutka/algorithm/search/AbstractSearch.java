package io.github.akuniutka.algorithm.search;

/**
 * Provides a utility method {@code checkStrings} for subclasses to check if strings
 * are not {@code null} and not empty and {@code string} is not shorter than {@code
 * substring}
 *
 * @author Andrei Kuniutka
 * @version 1.0
 * @since 1.0
 */
public class AbstractSearch {

    /**
     * Checks that both {@code substring} and {@code string} are not {@code null}
     * and not empty and {@code string} is not shorter than {@code substring}.
     *
     * @param substring the string being searched for
     * @param string    the string tested whether it contains {@code substring}
     * @return {@code true} if strings passed checks.
     */
    protected static boolean areCorrect(String substring, String string) {
        return substring != null && string != null && !substring.isEmpty() && substring.length() <= string.length();
    }
}
