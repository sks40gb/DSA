package com.sunil.dsa.categories.e_hashmap;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/word-pattern/description/

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".

 */
public class P3_WordPattern {

    public static void main(String[] args) {
        P3_WordPattern o = new P3_WordPattern();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(o.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String sentence) {

        String[] words = sentence.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String word = words[i];
            if (map1.containsKey(c) && !map1.get(c).equals(word)) {
                System.out.println(map1);
                return false;
            } else {
                map1.put(c, word);
            }
        }

        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map2.containsKey(word) && map2.get(word) != pattern.charAt(i)) {
                return false;
            } else {
                map2.put(word, pattern.charAt(i));
            }
        }
        return true;
    }
}
