package array;

/**
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class P9_JumpGame {

    public static void main(String[] args) {
        P9_JumpGame o = new P9_JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(o.canJump(nums));
        System.out.println(o.solveDP(nums));
        System.out.println(o.solveArray(nums));
    }

    public boolean canJump(int[] nums) {
        return solve(nums, 0);
    }

    private boolean solve(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        boolean canJump = false;
        for (int i = index + 1; i <= index + nums[index]; i++) {
            canJump = canJump || solve(nums, i);
        }
        return canJump;
    }

    private boolean solveDP(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int index = n - 2; index >= 0; index--) {
            boolean canJump = false;
            for (int i = index + 1; i <= index + nums[index]; i++) {
                canJump = canJump || dp[i];
            }
            dp[index] = canJump;
        }
        return dp[0];
    }

    private boolean solveArray(int[] nums) {
        //{2, 3, 1, 1, 4}
        int maxReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
           if(maxReach < i){
               return false;
           }
           maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

}
