package categories.string.easy;

public class MaximumNestingDepthOfParentheses {
    public static void main(String[] args) {
        String input = "(1+(2*3)+((8)/4))+1";
        int depth = new MaximumNestingDepthOfParentheses().maxDepth(input);
        System.out.println(depth);
    }

    public int maxDepth(String s) {
        int max = 0;
        int openBracket = 0;
        for(char ch: s.toCharArray()) {
            if( ch == '(') {
                openBracket++;
            }
            else if(ch == ')'){
                openBracket--;
            }
            max = Math.max(max, openBracket);
        }
        return max;
    }
}
