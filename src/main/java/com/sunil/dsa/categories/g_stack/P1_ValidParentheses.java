package com.sunil.dsa.categories.g_stack;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 */

public class P1_ValidParentheses {

    public static void main(String[] args) {
        P1_ValidParentheses o = new P1_ValidParentheses();
        String s = "()[]{}";
        System.out.println(o.isValid(s));
    }


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char fromChar = 'x';
            if(!stack.isEmpty()){
                fromChar = stack.peek();
            }
            char toChar = s.charAt(i);
            if ((toChar == '}' && fromChar == '{') || (toChar == ')' && fromChar == '(') || (toChar == ']' && fromChar == '[')) {
                stack.pop();
            }else{
                stack.push(toChar);
            }
        }
        return stack.isEmpty();

    }
}
