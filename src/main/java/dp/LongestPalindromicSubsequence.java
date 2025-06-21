package dp;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "cbbd";
        int result = longestPoly(s,"",0);
        System.out.println(result);
    }

    private static int longestPoly(String s, String sub, int i) {
        if(i == s.length()){
            if(isPoly(sub)){
                return sub.length();
            }else{
                return 0;
            }
        }
        int pick = longestPoly(s,sub + s.charAt(i), i+1);
        int notPick = longestPoly(s, sub, i+1);
        return Math.max(pick, notPick);
    }

    private static boolean isPoly(String sub) {
        int left = 0;
        int right = sub.length() -1;
        while(left < right){
            if(sub.charAt(left) != sub.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
