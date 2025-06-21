package dp3;

public class P5_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        P5_LongestIncreasingSubsequence o = new P5_LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(o.lengthOfLIS(nums));
        System.out.println(o.solveDP(nums));
    }

    public int lengthOfLIS(int[] nums) {
        return solve(nums, 0, -1);
    }

    private int solve(int[] nums, int index, int preIndex) {
        if (index == nums.length) {
            return 0;
        }
        int dontTake = solve(nums, index + 1, preIndex);
        int take = 0;
        if (preIndex == -1 || nums[index] > nums[preIndex]) {
            take = 1 + solve(nums, index + 1, index);
        }
        return Math.max(take, dontTake);
    }

    private int solveDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int preIndex = index - 1; preIndex >= -1; preIndex--) {

                int dontTake = dp[index + 1][preIndex + 1];
                int take = 0;
                if (preIndex == -1 || nums[index] > nums[preIndex]) {
                    take = 1 + dp[index + 1][index + 1];
                }
                dp[index][preIndex + 1] = Math.max(take, dontTake);
            }
        }
        return dp[0][0];
    }

}
