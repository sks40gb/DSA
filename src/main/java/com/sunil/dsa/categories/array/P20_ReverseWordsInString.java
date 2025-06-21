package com.sunil.dsa.categories.array;

import java.util.ArrayList;

/**
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 */
public class P20_ReverseWordsInString {

    public static void main(String[] args) {
        P20_ReverseWordsInString o = new P20_ReverseWordsInString();
        String s = "the sky is blue";
        System.out.println(o.reverseWords1(s));
        System.out.println(o.reverseWords2(s));
    }

    public String reverseWords1(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (result == "") {
                result = words[i];
            } else {
                result += " " + words[i];
            }
        }
        return result;
    }

    public String reverseWords2(String s) {
        String[] words = s.split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

}
