package com.sunil.dsa.categories.a_array;

public class P19_LongestCommonPrefix {

    public static void main(String[] args) {
        P19_LongestCommonPrefix o = new P19_LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(o.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        int count = 0;
        String word = strs[0];

        for (int i = 0; i < word.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || word.charAt(i) != strs[j].charAt(i)) {
                    return word.substring(0, count);
                }
            }
            count++;
        }
        return word.substring(0, count);

    }

}

