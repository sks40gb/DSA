package dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubsetSum o = new PartitionEqualSubsetSum();
        System.out.println(o.canPartition(nums));
    }

    private boolean canPartition(int[] nums) { // index -> 0, target -> 0
        int sum = getSum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
//        return f(nums, target, n - 1);
//        return fDP(nums, target);
        return fDP2(nums, target);
    }

    boolean f(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index < 0) {
            return false;
        }
        return f(nums, target - nums[index], index - 1) || f(nums, target, index - 1);
    }

//    boolean f(int[] nums, int target) {
//        if (target == 0) {
//            return true;
//        }
//        if (target < 0) {
//            return false;
//        }
//        return f(nums, target - nums[index], index - 1) || f(nums, target, index - 1);
//    }

    boolean fDP2(int[] nums, int target) {

        int n = nums.length;
        boolean[] current = new boolean[target + 1];
        current[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i] >= 0) {
                    current[j] = current[j - nums[i]] || current[j];
                }
            }
        }
        return current[target];
    }

    boolean fDP3(int[] nums, int target) {
        int n = nums.length;
        boolean[] current = new boolean[target + 1];
        current[0] = true;  // Base case: Subset sum of 0 can always be achieved

        for (int i = 0; i < n; i++) {
            // Iterate from right to left to avoid using the same element more than once
            for (int j = target; j >= nums[i]; j--) {
                current[j] = current[j] || current[j - nums[i]];
            }
        }
        return current[target];
    }

    boolean fDP(int[] nums, int target) {

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    private int getSum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }


}
