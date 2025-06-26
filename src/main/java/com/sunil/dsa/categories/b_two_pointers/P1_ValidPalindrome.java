package com.sunil.dsa.categories.b_two_pointers;

/*
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

 */
public class P1_ValidPalindrome {

    public static void main(String[] args) {
        P1_ValidPalindrome o = new P1_ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(o.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        String str = parseString(s);
        System.out.println(str);
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String parseString(String s) {
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
