package com.sunil.dsa.categories.g_stack;

import java.util.Stack;

/*
https://leetcode.com/problems/min-stack/
 */
public class P3_MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            int min = minStack.isEmpty() || minStack.peek() > val ? val : minStack.peek();
            stack.push(val);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}

