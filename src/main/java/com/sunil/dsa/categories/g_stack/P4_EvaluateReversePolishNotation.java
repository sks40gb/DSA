package com.sunil.dsa.categories.g_stack;

import java.util.Stack;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
 */

public class P4_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        P4_EvaluateReversePolishNotation o = new P4_EvaluateReversePolishNotation();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(o.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i].length() == 1 ? tokens[i].charAt(0) : 'x';
            if("+-*/".contains(tokens[i])){
                int second = stack.pop();
                int first = stack.pop();
                int result = applyOperator(tokens[i],first, second);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    private int applyOperator(String operator, int first, int second) {
        switch (operator){
            case "+" : return first + second;
            case "-" : return first - second;
            case "*" : return first * second;
            case "/" : return first / second;
            default: throw new IllegalArgumentException("Invalid operator " + operator);
        }
    }

}
