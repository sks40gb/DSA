package com.sunil.dsa.categories.g_stack;

/*
https://leetcode.com/problems/simplify-path/description/

Example 1:
Input: path = "/home/"
Output: "/home"

Example 2:
Input: path = "/home//foo/"
Output: "/home/foo"
 */

import java.util.Stack;

public class P2_SimplifyPath {
    public static void main(String[] args) {
        P2_SimplifyPath o = new P2_SimplifyPath();
        String path = "/home/user/Documents/../Pictures";
        System.out.println(o.simplifyPath(path)); //Output: "/home/user/Pictures"
    }

    public String simplifyPath(String path) {

        String[] files = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String file : files) {
            //If the file is empty or current directory
            if (file.isEmpty() || file.equals(".")) {
                continue;
            }
            //Goto parent directory
            if (file.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(file);
            }
        }
        String result = String.join("/", stack);
        return "/" + result;
    }

}
