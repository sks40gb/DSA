package t150.array_and_string;

import java.util.Arrays;

public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 o = new JumpGame2();
        int[] jumps = {2, 3, 1, 1, 4}; //true
        System.out.println(o.jump(jumps));
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return jumpIt(nums, 0, dp, "[" + nums[0] + "]");
    }

    private int jumpIt(int[] nums, int index, int[] dp, String result) {
        if (index >= nums.length - 1) {
            System.out.println(result);
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int times = nums[index];
        int min = Integer.MAX_VALUE - 1; // Prevent overflow when adding 1 later
        for (int i = 1; i <= times; i++) {
            int jump = jumpIt(nums, index + i, dp, result + "[" + nums[index + 1] + "]") + 1;
            min = Integer.min(min, jump);
        }
        dp[index] = min;
        return dp[index];
    }

    public int jump2(int[] nums) {
        int curEnd = 0;
        int curFurthest = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFurthest = Math.max(curFurthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFurthest;
                jumps++;
            }
        }
        return jumps;
    }

}
