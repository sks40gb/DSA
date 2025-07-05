package com.sunil.dsa.categories.g_stack;

/*
https://leetcode.com/problems/basic-calculator/

Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 */

import java.util.Stack;

public class P5_BasicCalculator {

    public static void main(String[] args) {
        P5_BasicCalculator o = new P5_BasicCalculator();
        String s = "(1+(4+5+2)-3)+(6+8)"; //23
        System.out.println(o.calculate(s));
    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>(); //-1,1
        int sign = 1;  //-1
        int num = 0;   //2
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) { //Add to current number
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') { //reset everything for new calculation
                stack.push(result);
                stack.push(sign);
                num = 0;
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result = result + sign * num; //-2
                num = 0;
                sign = 1;
                result *= stack.pop();  //apply the sign
                result += stack.pop();  //-2 + -1 =-3
            }
        }
        return result + (sign * num);
    }

}
