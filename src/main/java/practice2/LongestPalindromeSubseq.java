package practice2;

public class LongestPalindromeSubseq {


    public static void main(String[] args) {
        LongestPalindromeSubseq o = new LongestPalindromeSubseq();
        System.out.println(o.longestPalindromeSubseq("bbbab"));  // Output: 4
        System.out.println(o.longestPalindromeSubseq("babda"));  // Output: 3
    }

    public int longestPalindromeSubseq(String s) {
        return longest(s, 0, s.length()-1);
    }

    private int longest(String s, int left, int right) {
        if(left > right){
            return 0;
        }
        if(left == right){
            return 1;
        }
        if(s.charAt(left) == s.charAt(right)){
            return 2 + longest(s, left+1, right-1);
        }else{
            return Math.max(longest(s, left+1, right), longest(s, left, right-1));
        }
    }

}
