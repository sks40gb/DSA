package practice2;

import java.util.Arrays;

public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = new CombinationSum4().combinationSum4(nums, target);
        System.out.println(result);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return sum(nums, target, dp);
    }

    public int sum(int[] nums, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            times += sum(nums, target - nums[i], dp);
        }
        return dp[target] = times;
    }
}
