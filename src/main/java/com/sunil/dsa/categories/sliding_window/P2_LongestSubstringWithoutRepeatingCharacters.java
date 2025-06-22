package com.sunil.dsa.categories.sliding_window;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

 */
public class P2_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        P2_LongestSubstringWithoutRepeatingCharacters o =
                new P2_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));

    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            while(set.contains(c)){
                Character f = s.charAt(left);
                set.remove(f);
                left++;
            }
            set.add(c);
            max = Math.max(max, set.size());
        }
        return max;
    }


}
