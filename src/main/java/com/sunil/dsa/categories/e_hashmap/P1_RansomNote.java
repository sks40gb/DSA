package com.sunil.dsa.categories.e_hashmap;

/*
https://leetcode.com/problems/ransom-note/description/

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

 */
public class P1_RansomNote {

    public static void main(String[] args) {
        P1_RansomNote o = new P1_RansomNote();
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(o.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String a, String b) {
        int[] counts = new int[26];

        for(int i=0; i < b.length(); i++){
            char c = b.charAt(i);
            counts[c - 'a']++;
        }

        for(int i=0; i < a.length(); i++){
            char c = a.charAt(i);
            if(counts[c - 'a'] <= 0){
                return false;
            }else{
                counts[c - 'a']--;
            }
        }
        return true;
    }
}
