package dp;

public class MaxAlternatingSum {

    public static void main(String[] args) {
        int[] nums = {4,2,5,3};
        long result = new MaxAlternatingSum().maxAlternatingSum(nums);
        System.out.println(result);
    }

    public long maxAlternatingSum(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];
        return maxSum(nums, 0, 1, dp);
    }

    private static int maxSum(int[] nums, int index, int sign, int[][] dp) {
        int op = sign + 1;
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index][op] != 0) {
            return dp[index][op];
        }
        int take = maxSum(nums, index + 1, -sign, dp) + (sign * nums[index]);
        int dontTake = maxSum(nums, index + 1, sign, dp);
        return dp[index][op] = Math.max(take, dontTake);
    }
}
