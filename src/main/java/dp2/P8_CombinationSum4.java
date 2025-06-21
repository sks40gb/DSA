package dp2;

public class P8_CombinationSum4 {

    public static void main(String[] args) {
        P8_CombinationSum4 o = new P8_CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 5;
        System.out.println(o.combinationSum4(nums, target));
        System.out.println(o.combinationSum4DP(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            ways += combinationSum4(nums, target - nums[i]);
        }
        return ways;
    }

    public int combinationSum4DP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            int ways = 0;
            for (int i = 0; i < nums.length; i++) {
                if (t - nums[i] >= 0) {
                    ways += dp[t - nums[i]];
                }
            }
            dp[t] = ways;
        }
        return dp[target];
    }

}
