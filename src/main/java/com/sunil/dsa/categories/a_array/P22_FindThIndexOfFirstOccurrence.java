package com.sunil.dsa.categories.a_array;

public class P22_FindThIndexOfFirstOccurrence {
    public static void main(String[] args) {
        P22_FindThIndexOfFirstOccurrence o = new P22_FindThIndexOfFirstOccurrence();
        String haystack = "leetcode";
        String needle = "sad";
        System.out.println(o.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        for(int i=0; i < haystack.length() - needle.length() -1; i++){
            if(matched(haystack, needle, i)){
                return i;
            }
        }
        return -1;
    }

    private boolean matched(String haystack, String needle, int start) {
        for(int i=0; i < needle.length(); i++){
            if(needle.charAt(i) != haystack.charAt(start+i)){
                return false;
            }
        }
        return true;
    }
}
