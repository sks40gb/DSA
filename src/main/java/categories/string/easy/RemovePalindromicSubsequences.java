package categories.string.easy;

/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/?envType=problem-list-v2&envId=ehkbkaxt
 */
public class RemovePalindromicSubsequences {

    public static void main(String[] args) {
        String input = "ababa";
        int count = new RemovePalindromicSubsequences().removePalindromeSub(input);
        System.out.println(count);
    }

    public int removePalindromeSub(String input) {
        if(input.isEmpty()){
            return 0;
        }
        if(isPalindrome(input)){
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String input){
        int left = 0;
        int right = input.length()-1;
        while(left < right){
            if(input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
