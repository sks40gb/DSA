package dp;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence o = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(o.lengthOfLIS(nums));
        System.out.println(o.longest(nums, nums.length - 1, Integer.MAX_VALUE));
        System.out.println(o.longestDP(nums));
        System.out.println(o.longestDP2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        return longest(nums, 0, Integer.MIN_VALUE);
    }

    private int longest(int[] nums, int i, int j) {
        if (i >= nums.length) {
            return 0;
        }
        int n = nums[i];
        int dontTake = longest(nums, i + 1, j);
        int take = 0;
        if (n > j) {
            take = 1 + longest(nums, i + 1, i);
        }
        return Math.max(dontTake, take);
    }

    private int longestDP(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int num = nums[i];
                int dontTake = dp[i - 1][j];
                int take = 0;
                if (num < nums[j]) {
                    take = 1 + dp[i - 1][i];
                }
                dp[i][j] = Math.max(dontTake, take);
            }
        }
        return dp[n - 1][n - 1];
    }

    private int longest2(int[] nums, int i, int next) {
        if (i < 0) {
            return 0;
        }
        int n = nums[i];
        int dontTake = longest2(nums, i - 1, next);
        int take = 0;
        if (n < next) {
            take = 1 + longest2(nums, i - 1, n);
        }
        return Math.max(take, dontTake);
    }


    private int longestDP2(int[] nums) {
        //base case
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(nums[i] > nums[j]){
                    dp[i][j] = Math.max(1 + dp[i-1][i-1], dp[i-1][j-1]);
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[n-1][n-1];
    }
}
