package io.github.akuniutka.algorithm.search;

public class ManacherPalindromeSearch {
    public static String getLongestPalindrome(String string) {
        if (string == null) {
            return null;
        }
        int[] radii = new int[string.length()];
        int left = 0;
        int right = -1;
        int maxLength = 0;
        int bestLeft = 0;
        int bestRight = 0;

        for (int center = 0; center < string.length(); center++) {
            int radius = 0;
            if (center <= right) {
                int mirroredCenter = left + (right - center);
                radius = Math.min(right - center, radii[mirroredCenter]);
            }
            while (center - (radius + 1) >= 0 && center + (radius + 1) < string.length()
                    && string.charAt(center - (radius + 1)) == string.charAt(center + (radius + 1))) {
                radius++;
            }
            radii[center] = radius;
            if (center + radius > right) {
                left = center - radius;
                right = center + radius;
                int length = right - left + 1;
                if (length > maxLength) {
                    maxLength = length;
                    bestLeft = left;
                    bestRight = right + 1;
                }
            }
        }

        radii = new int[string.length()];
        left = 0;
        right = -1;
        for (int center = 0; center < string.length(); center++) {
            int radius = 0;
            if (center <= right) {
                int mirroredCenter = left + (right - center) + 1;
                radius = Math.min(right - center + 1, radii[mirroredCenter]);
            }
            while (center - (radius + 1) >= 0 && center + radius < string.length()
                    && string.charAt(center - (radius + 1)) == string.charAt(center + radius)) {
                radius++;
            }
            radii[center] = radius;
            if (center + radius - 1 > right) {
                left = center - radius;
                right = center + radius - 1;
                int length = right - left + 1;
                if (length > maxLength) {
                    maxLength = length;
                    bestLeft = left;
                    bestRight = right + 1;
                }
            }
        }

        return string.substring(bestLeft, bestRight);
    }
}
