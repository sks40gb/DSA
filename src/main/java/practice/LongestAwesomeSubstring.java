package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestAwesomeSubstring {

    public static void main(String[] args) {
        String s = "3242415";
        System.out.println(longestAwesome(s));
    }

    public static int longestAwesome(String s) {
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxLength = 0;
        int mask = 0;

        // Initialize with the base case where the mask is 0 before any characters are processed
        firstOccurrence.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            // Update the mask for the current character
            System.out.println(5^2);
            mask ^= (1 << (s.charAt(i) - '0'));
            System.out.println(s.charAt(i) - '0' + " : " + (1 << (s.charAt(i) - '0')) + " : " + mask);

            // Check if we have seen this mask before
            if (firstOccurrence.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - firstOccurrence.get(mask));
            } else {
                firstOccurrence.put(mask, i);
            }

            // Check all masks with one bit flipped
            for (int j = 0; j < 10; j++) {
                int maskWithOneBitFlipped = mask ^ (1 << j);
                if (firstOccurrence.containsKey(maskWithOneBitFlipped)) {
                    maxLength = Math.max(maxLength, i - firstOccurrence.get(maskWithOneBitFlipped));
                }
            }
        }

        return maxLength;
    }
}
