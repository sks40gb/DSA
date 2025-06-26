package com.sunil.dsa.categories.c_sliding_window;

import java.util.*;

/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]

Example 2 :
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

@TODO : Retry
 */

public class P3_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        P3_SubstringWithConcatenationOfAllWords o =
                new P3_SubstringWithConcatenationOfAllWords();

        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        System.out.println(o.findSubstring(s, words));

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Try all possible starting points within one word length
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If more than expected, slide window from left
                    while (windowMap.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Found a valid window
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Word not in list, reset everything
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int len = words[0].length() * words.length;
        for (int i = 0; i < s.length() - len + 1; i++) {
            List<String> list = new ArrayList<>(Arrays.asList(words));
            if (isMatched(s, list, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isMatched(String s, List<String> words, int index) {
        int size = words.size();
        int len = words.get(0).length();
        for (int i = 0; i < size; i++) {
            int left = index + i * len;
            int right = left + len;
            String sub = s.substring(left, right);
            words.remove(sub);
        }
        return words.size() == 0;
    }

}
