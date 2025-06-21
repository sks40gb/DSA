package dp2;

public class P14_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        P14_LongestIncreasingSubsequence o = new P14_LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(o.lengthOfLIS(nums));
        System.out.println(o.lisDP(nums));
        System.out.println(o.lisOS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        return lis(nums, 0, -1);
    }

    private int lis(int[] nums, int index, int preIndex) {
        if (index >= nums.length) {
            return 0;
        }
        int take = 0;
        if (preIndex == -1 || nums[index] > nums[preIndex]) {
            take = 1 + lis(nums, index + 1, index);
        }
        int dontTake = lis(nums, index + 1, preIndex);
        return Math.max(take, dontTake);
    }

    private int lisDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int preIndex = n - 1; preIndex >= -1; preIndex--) {
                int take = 0;
                if (preIndex == -1 || nums[index] > nums[preIndex]) {
                    take = 1 + dp[index + 1][index + 1];
                }
                int dontTake = dp[index + 1][preIndex + 1];
                dp[index][preIndex + 1] = Math.max(take, dontTake);
            }
        }
        return dp[0][0];
    }

    private int lisOS(int[] nums) {
        int n = nums.length;
        int[] current = new int[n + 1];
        int[] next = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int preIndex = n - 1; preIndex >= -1; preIndex--) {
                int take = 0;
                if (preIndex == -1 || nums[index] > nums[preIndex]) {
                    take = 1 + next[index + 1];
                }
                int dontTake = next[preIndex + 1];
                current[preIndex + 1] = Math.max(take, dontTake);
            }
            next = current.clone();
        }
        return current[0];
    }
}
