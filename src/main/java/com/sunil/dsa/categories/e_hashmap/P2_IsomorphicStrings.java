package com.sunil.dsa.categories.e_hashmap;

/*
https://leetcode.com/problems/isomorphic-strings/description/

Example 1:

Input: s = "egg", t = "add"
Output: true

Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"
Output: false

Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

 */
public class P2_IsomorphicStrings {

    public static void main(String[] args) {
        P2_IsomorphicStrings o = new P2_IsomorphicStrings();
        String s = "egg";
        String t = "add";
        System.out.println(o.isIsomorphic(s,t));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return isMapped(s, t) && isMapped(t, s);
    }

    public boolean isMapped(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] arr = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (arr[c] > 0 && arr[c] != str2.charAt(i)) {
                return false;
            } else {
                arr[c] = str2.charAt(i);
            }
        }
        return true;
    }

}
