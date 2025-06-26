package com.sunil.dsa.categories.e_hashmap;

import java.util.Arrays;

/*
https://leetcode.com/problems/valid-anagram/description/

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

 */
public class P4_ValidAnagram {

    public static void main(String[] args) {
        P4_ValidAnagram o = new P4_ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(o.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] source = new int[26];
        for (int i = 0; i < n; i++) {
            source[s.charAt(i) - 'a']++;
        }

        int[] target = new int[26];
        for (int i = 0; i < n; i++) {
            target[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(source, target);
    }
}
