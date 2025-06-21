package dp;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = new TargetSum().findTargetSumWays(nums, target);
        System.out.println(result);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, nums.length - 1);
    }

    private int solve(int[] nums, int target, int index) {
        if (index == -1) {
            return target == 0 ? 1 : 0;
        }
        int plus = solve(nums, target - nums[index], index - 1);
        int minus = solve(nums, target + nums[index], index - 1);
        return plus + minus;
    }

    private int solveDP(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int plus = dp[i-1][j - nums[i]];
                int minus = dp[i-1][j + nums[i]];
                dp[i][j] =  plus + minus;
            }
        }
        return dp[n-1][target];
    }
}
