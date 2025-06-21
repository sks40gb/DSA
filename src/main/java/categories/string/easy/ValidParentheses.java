package categories.string.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/?envType=problem-list-v2&envId=ehkbkaxt
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "[({})()]";
        boolean isValid = isValid(s);
        System.out.println(isValid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char toChar = s.charAt(i);
            if (!stack.isEmpty() && ((toChar == '}' && stack.peek() == '{') ||
                    (toChar == ')' && stack.peek() == '(') ||
                    (toChar == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                stack.push(toChar);
            }
        }
        return stack.isEmpty();
    }
}
