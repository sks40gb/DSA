package t150.array_and_string;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame o = new JumpGame();
        int[] jumps = {2, 3, 1, 1, 4}; //true
//        int[] jumps = {3, 2, 1, 0, 4}; //false
        System.out.println(o.canJump(jumps));
    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return jumpIt(nums, 0, dp);
    }

    private boolean jumpIt(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return false;
        }
        if (index == nums.length - 1) {
            return true;
        }
        if (dp[index] != -1) {
            return dp[index] != 0;
        }
        int times = nums[index];
        boolean canJump = false;
        for (int i = 1; i <= times; i++) {
            canJump = canJump || jumpIt(nums, index + i, dp);
        }
        dp[index] = canJump ? 1 : 0;
        return canJump;
    }

    public boolean canJump2(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}















