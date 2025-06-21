package com.sunil.dsa.categories.array;

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
        System.out.println(o.reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if(result == ""){
                result = words[i];
            }else{
                result += " " + words[i];
            }
        }
        return result;
    }

}
