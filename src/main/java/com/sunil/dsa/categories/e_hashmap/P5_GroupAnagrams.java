package com.sunil.dsa.categories.e_hashmap;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/description/

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class P5_GroupAnagrams {

    public static void main(String[] args) {
        P5_GroupAnagrams o = new P5_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(o.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];
            char[] arr = word.toCharArray();

            Arrays.sort(arr);
            String key = new String(arr);

            if(map.containsKey(key)){
                map.get(key).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            process(result, word);
        }
        return result;
    }

    private void process(List<List<String>> result, String word) {
        if (result.size() == 0) {
            List<String> newList = new ArrayList<>();
            newList.add(word);
            result.add(newList);
        } else {
            for (List<String> list : result) {
                for (String w : list) {
                    if (isAnagram(word, w)) {
                        list.add(word);
                        return;
                    }
                }
            }
            List<String> newList = new ArrayList<>();
            newList.add(word);
            result.add(newList);
        }
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
