package categories.string.easy;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                if(!stack.isEmpty()){
                    result.append(c);
                }
                stack.push(c);
            }else if(c == ')'){
                if(!stack.isEmpty()){

                }
            }
        }
        return result.toString();
    }

}
