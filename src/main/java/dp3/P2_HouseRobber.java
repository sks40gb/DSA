package dp3;

public class P2_HouseRobber {

    public static void main(String[] args) {
        P2_HouseRobber o = new P2_HouseRobber();
        int[] nums = {1, 2, 3, 1};
        System.out.println(o.rob(nums));
        System.out.println(o.solveDP(nums));
        System.out.println(o.solveSO(nums));
    }

    public int rob(int[] nums) {
        return solve(nums, 0);
    }

    private int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int rob = nums[index] + solve(nums, index + 2);
        int dontRob = solve(nums, index + 1);
        return Math.max(rob, dontRob);
    }

    private int solveDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n -1; i >= 0; i--) {
            int rob = nums[i] + dp[i + 2];
            int dontRob = dp[i + 1];
            dp[i] = Math.max(rob, dontRob);
        }
        return dp[0];
    }

    private int solveSO(int[] nums) {
        int n = nums.length;
        int next = 0;
        int nextToNext = 0;

        for (int i = n -1; i >= 0; i--) {
            int rob = nums[i] + nextToNext;
            int dontRob = next;
            nextToNext = next;
            next = Math.max(rob, dontRob);
        }
        return next;
    }
}
