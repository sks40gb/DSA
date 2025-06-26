package com.sunil.dsa.categories.b_two_pointers;

/*
https://leetcode.com/problems/is-subsequence/description/

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

 */
public class P2_IsSubsequence {

    public static void main(String[] args) {
        P2_IsSubsequence o = new P2_IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(o.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return sIndex == s.length();
    }

}
