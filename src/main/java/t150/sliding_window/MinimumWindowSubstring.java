package t150.sliding_window;

import java.util.Arrays;
import java.util.Map;

/*
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring o = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = o.minWindow(s, t);
        System.out.println("Result " + result);
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] chars = new int[128]; // ASCII character map
        for (char c : t.toCharArray()) {
            chars[c]++; // Initialize character counts from `t`
        }

        int counter = t.length(); // Number of characters to match
        int leftIndex = 0;
        String minString = "";

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {

            if (chars[s.charAt(rightIndex)] > 0) {
                counter--; // Decrease count when matching a needed character
            }
            chars[s.charAt(rightIndex)]--; // Decrease count in chars array

            while (counter == 0) { // Try shrinking the window
                String str = s.substring(leftIndex, rightIndex + 1);
                if (minString.isEmpty() || str.length() < minString.length()) {
                    minString = str;
                }

                chars[s.charAt(leftIndex)]++; // Restore character count
                if (chars[s.charAt(leftIndex)] > 0) {
                    counter++; // Increase counter if a needed character is removed
                }
                leftIndex++; // Move leftIndex forward
            }
        }
        return minString;
    }

}





