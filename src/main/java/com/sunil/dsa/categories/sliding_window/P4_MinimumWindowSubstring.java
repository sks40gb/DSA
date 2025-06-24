package com.sunil.dsa.categories.sliding_window;

/*

https://leetcode.com/problems/minimum-window-substring/

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

 */
public class P4_MinimumWindowSubstring {

    public static void main(String[] args) {
        P4_MinimumWindowSubstring o = new P4_MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(o.minWindow(s,t));
    }

    public String minWindow(String s, String t) {

        int left = 0;
        String ans = null;
        int[] freq = new int[256];
        int[] target = new int[256];

        for(int i=0; i < t.length(); i++){
            target[t.charAt(i)]++; //"ABC"
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(target[c] > 0){
                freq[s.charAt(i)]++;
            }
            while(isEqual(freq, target)){
                if(ans == null || ans.length() > (i-left + 1)){
                    ans = s.substring(left, i+1);
                }
                if(freq[s.charAt(left)] > 0){
                    freq[s.charAt(left)]--;
                }
                left++;
            }
        }
        return ans == null ? "" : ans;
    }

    private static boolean isEqual(int[] freq, int[] target) {
        for (int i = 0; i < target.length; i++) {
            if(target[i] > freq[i]){
                return false;
            }
        }
        return true;
    }


}
