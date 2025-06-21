package dp;

public class SubsetSumRecursive {


    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10};
        int target = 11;

        SubsetSumRecursive obj = new SubsetSumRecursive();
        System.out.println(obj.isSubset(nums, target));

    }

    public boolean isSubset(int[] nums, int target) {
        int n = nums.length;
        return subsetSum(nums, n, target);
    }

    private boolean subsetSum(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == 0 || target < 0) {
            return false;
        }
        boolean pick = subsetSum(nums, index - 1, target - nums[index - 1]);
        boolean dontPick = subsetSum(nums, index - 1, target);
        return pick || dontPick;
    }

    boolean maximumSubarray (int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target; j++) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }


    boolean maximumSubarray2 (int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }


}